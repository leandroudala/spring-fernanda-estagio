package app.udala.fernanda.projeto.tecnoestagio.controller.form;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ToolUpdate {
	@NotNull
	private Long id;

	@NotNull
	@NotEmpty
	private List<String> tags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
