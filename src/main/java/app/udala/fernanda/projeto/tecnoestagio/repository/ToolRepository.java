package app.udala.fernanda.projeto.tecnoestagio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.udala.fernanda.projeto.tecnoestagio.model.Tool;

public interface ToolRepository extends JpaRepository<Tool, Long> {
	List<Tool> findByTagsName(String tag);
}
