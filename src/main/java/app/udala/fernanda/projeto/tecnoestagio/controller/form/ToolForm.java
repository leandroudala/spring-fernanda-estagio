package app.udala.fernanda.projeto.tecnoestagio.controller.form;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import app.udala.fernanda.projeto.tecnoestagio.model.Tag;
import app.udala.fernanda.projeto.tecnoestagio.model.Tool;

public class ToolForm {
	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String link;

	@NotNull
	@NotEmpty
	private String description;

	@NotNull
	@NotEmpty
	private List<Tag> tags;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public Tool toTool() {
		Tool tool = new Tool();
		tool.setName(name);
		tool.setDescription(description);
		tool.setLink(link);
		tool.setTags(tags);
		return tool;
	}

}
