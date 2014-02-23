package mh.dev.blog.repository.graph;

import java.util.List;

import mh.dev.blog.model.graph.GraphWord;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.CRUDRepository;

public interface GraphWordRepository extends CRUDRepository<GraphWord> {

	@Query("Match (word:GraphWord) Where word.text = {0} return word")
	public List<GraphWord> text(String text);

}
