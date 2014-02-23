package mh.dev.blog.test.controller;

import mh.dev.blog.Application;
import mh.dev.blog.model.graph.GraphWord;
import mh.dev.blog.repository.graph.GraphWordRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@WebAppConfiguration
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
public class GraphTest {

	@Autowired
	private GraphWordRepository repository;

	@Test
	public void graphtTest() {
		GraphWord graphWord1 = new GraphWord();
		graphWord1.setText("word1");
		repository.save(graphWord1);

		GraphWord graphWord2 = new GraphWord();
		graphWord2.setText("word2");
		repository.save(graphWord2);

		Assert.assertEquals(1, repository.text("word1").size());
		Assert.assertEquals(0, repository.text("word3").size());
	}

}
