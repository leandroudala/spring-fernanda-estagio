package app.udala.fernanda.projeto.tecnoestagio.controller.dto;

import app.udala.fernanda.projeto.tecnoestagio.model.Tag;

public class TagDto {
	private final String name;

	public TagDto(Tag tag) {
		this.name = tag.getName();
	}

	public String getName() {
		return name;
	}

}
