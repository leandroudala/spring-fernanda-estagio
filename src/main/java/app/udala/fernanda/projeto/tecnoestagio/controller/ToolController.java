package app.udala.fernanda.projeto.tecnoestagio.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import app.udala.fernanda.projeto.tecnoestagio.controller.dto.ToolDto;
import app.udala.fernanda.projeto.tecnoestagio.controller.form.ToolForm;
import app.udala.fernanda.projeto.tecnoestagio.controller.form.ToolUpdate;
import app.udala.fernanda.projeto.tecnoestagio.model.Tag;
import app.udala.fernanda.projeto.tecnoestagio.model.Tool;
import app.udala.fernanda.projeto.tecnoestagio.repository.TagRepository;
import app.udala.fernanda.projeto.tecnoestagio.repository.ToolRepository;

@RestController
@RequestMapping("/tools")
public class ToolController {

	@Autowired
	private ToolRepository toolRepository;

	@Autowired
	private TagRepository tagRepository;

	@GetMapping
	public ResponseEntity<List<ToolDto>> getTools(@RequestParam(required = false) String tag) {
		// criando lista de Tool
		List<Tool> collected;

		// Verificando se há filtro
		if (tag != null)
			collected = toolRepository.findByTagsName(tag);
		else
			collected = toolRepository.findAll();

		// retornando todos os Tools encontrados
		return ResponseEntity.ok(collected.stream().map(ToolDto::new).collect(Collectors.toList()));
	}

	@PostMapping
	public ResponseEntity<ToolDto> insertTool(@Valid @RequestBody ToolForm toolData, UriComponentsBuilder uriBuilder) {
		// cadastrando a nova tool
		Tool newTool = toolRepository.save(toolData.toTool());

		// extraindo todas as Tags da tool para realizar cadastro
		List<Tag> tags = newTool.getTags().stream().map(tag -> {
			tag.setTool(newTool);
			return tag;
		}).collect(Collectors.toList());

		// cadastrando todas as tags
		tagRepository.saveAll(tags);

		// retornando mensagem de sucesso oa usuário
		URI location = uriBuilder.path("/tools/{id}").buildAndExpand(newTool.getId()).toUri();
		return ResponseEntity.created(location).body(new ToolDto(newTool));
	}

	@PutMapping
	public ResponseEntity<ToolDto> updateTool(@Valid @RequestBody ToolUpdate toolUpdate) {
		// verificando se existe tool com este ID
		Optional<Tool> search = toolRepository.findById(toolUpdate.getId());
		if (search.isEmpty())
			// retornando 404 caso não exista
			return ResponseEntity.notFound().build();

		// armazenando Tool em uma variável
		Tool tool = search.get();

		// obtendo todas as novas tags que deverão ser cadastradas (similar ao forEach)
		List<Tag> tags = toolUpdate.getTags().stream().map(name -> new Tag(name, tool)).collect(Collectors.toList());

		// cadastrando novas tags
		tagRepository.saveAll(tags);

		// adicionando novas tags à variável Tool para ser exibida ao usuário
		tool.getTags().addAll(tags);

		// retornando mensagem de sucesso ao usuário
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ToolDto> deleteTool(@PathVariable Long id) {
		// buscando Tool pelo id
		Optional<Tool> search = toolRepository.findById(id);

		// retorna 404 se não encontrar
		if (search.isEmpty())
			return ResponseEntity.notFound().build();

		// deletando a Tool
		Tool tool = search.get();
		toolRepository.delete(tool);

		// retorna 204 para sucesso (sem conteúdo)
		return ResponseEntity.noContent().build();
	}

}
