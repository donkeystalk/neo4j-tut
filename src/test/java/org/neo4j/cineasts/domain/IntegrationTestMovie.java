package org.neo4j.cineasts.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IntegrationTestMovie {

	@Autowired
	Neo4jTemplate template;
	
	@Test
	@Transactional
	public void persistedMovieShouldBeRetrievableFromGraphDb()
	{
		Movie forrestGump = template.save(new Movie("Forrest Gump", 1994));
		Movie retrievedMovie = template.findOne(forrestGump.getNodeId(), Movie.class);
		assertEquals("retrieved movie matches persisted one", forrestGump, retrievedMovie);
		assertEquals("retrieved movie title matches", "Forrest Gump", retrievedMovie.getTitle());
	}
	
	@Test
	@Transactional
	public void persistedMovieShouldBeRetrievableById()
	{
		int id = 1;
		Movie forrestGump = template.save(new Movie(id, "Forrest Gump", 1994));
	}
	
}
