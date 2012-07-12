package org.neo4j.cineasts.domain;

import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Movie {

	@GraphId
	Long nodeId;
	@Indexed(unique=true)
	String id;
	String title;
	int year;
	Set<Role> cast;
	
	// Required
	public Movie(){}
	
	public String getTitle()
	{
		return title;
	}
	
	public Long getNodeId()
	{
		return nodeId;
	}

	public Movie(String title, int year) {
		this.title = title;
		this.year = year;
	}
	
	public Movie(int id, String title, int year) {
		this(title, year);
		this.id = String.valueOf(id);
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		Movie movie = (Movie)o;
		if(nodeId == null) return super.equals(o);
		return nodeId.equals(movie.nodeId);
	}
}
