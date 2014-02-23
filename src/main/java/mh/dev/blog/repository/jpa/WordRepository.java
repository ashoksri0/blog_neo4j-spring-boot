package mh.dev.blog.repository.jpa;

import java.util.List;

import mh.dev.blog.model.jpa.Word;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Long> {

	public Word findByText(String text);

	@Query(value = "Select w From Word w")
	public List<Word> all();
}
