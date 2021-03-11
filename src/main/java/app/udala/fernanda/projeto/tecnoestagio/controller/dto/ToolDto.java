package app.udala.fernanda.projeto.tecnoestagio.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import app.udala.fernanda.projeto.tecnoestagio.model.Tag;
import app.udala.fernanda.projeto.tecnoestagio.model.Tool;

public class ToolDto {
	private final Long id;
	private final String name;
	private final String link;
	private final String description;
	private final List<String> tags;

	public ToolDto(Tool tool) {
		id = tool.getId();
		name = tool.getName();
		description = tool.getDescription();
		link = tool.getLink();
		tags = tool.getTags().stream().map(Tag::toString).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getTags() {
		return tags;
	}

}
