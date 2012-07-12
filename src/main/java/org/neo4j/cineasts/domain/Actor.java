package org.neo4j.cineasts.domain;

import java.util.Set;

public class Actor {
	String id;
	String name;
	Set<Movie> filmography;
	Role playedIn(Movie movie, String role){ return null; }
}
