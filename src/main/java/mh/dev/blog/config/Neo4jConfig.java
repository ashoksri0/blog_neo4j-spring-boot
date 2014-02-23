package mh.dev.blog.config;

import javax.persistence.EntityManagerFactory;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.JtaTransactionManagerFactoryBean;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableNeo4jRepositories(basePackages = "mh.dev.blog.repository.graph")
public class Neo4jConfig extends Neo4jConfiguration {

	@Bean
	public GraphDatabaseService graphDatabaseService() {
		return new GraphDatabaseFactory().newEmbeddedDatabase("graph.db");
	}

	@Autowired
	@Bean(name = "transactionManager")
	public PlatformTransactionManager neo4jTransactionManager(EntityManagerFactory entityManagerFactory, GraphDatabaseService graphDatabaseService)
			throws Exception {
		return new ChainedTransactionManager(new JpaTransactionManager(entityManagerFactory),
				new JtaTransactionManagerFactoryBean(graphDatabaseService).getObject());
	}
}
