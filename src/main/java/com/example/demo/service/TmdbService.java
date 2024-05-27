package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class TmdbService {
	@Autowired
	private RestTemplate restTemplate;

	@Value("${tmdb.api.key}")
	private String apiKey;

	private final String url = "https://api.themoviedb.org/3";
	
	private String language = "&language=es-ES";

	
	//PELÍCULAS
	public String getMovieGenreList() {
		String search = url + "/genre/movie/list"+ "?api_key=" + apiKey + language;

		return restTemplate.getForObject(search, String.class);

	}
	
	public String getPopularMovies() {
		String search = url + "/movie/popular?api_key=" + apiKey + language;

		return restTemplate.getForObject(search, String.class);

	}

	public String getCurrentMovies() {
		String search = url + "/movie/now_playing?api_key=" + apiKey + language;

		return restTemplate.getForObject(search, String.class);

	}

	public String getUpcomingMovies() {
		String search = url + "/movie/upcoming?api_key=" + apiKey + language;

		return restTemplate.getForObject(search, String.class);

	}

	public String getTopRatedMovies() {
		String search = url + "/movie/top_rated?api_key=" + apiKey + language;

		return restTemplate.getForObject(search, String.class);

	}
	
	public String getMoviesByGenre(int id_genre) {
		String search = url + "/discover/movie?api_key=" + apiKey + language + "&with_genres=" + id_genre;
		
		return restTemplate.getForObject(search, String.class);
 
	}
	
	public String getSpanishMovie() {

		String search = url + "/discover/movie?api_key=" + apiKey + language + "&with_origin_country=ES&with_original_language=es";
		
		return restTemplate.getForObject(search, String.class);
	}
	
	public String getActionMovie() {
		String search = url + "/discover/movie?api_key=" + apiKey + language + "&with_genres=28";
		
		return restTemplate.getForObject(search, String.class);
	}
	
	public String getDramaMovie() {
		String search = url + "/discover/movie?api_key=" + apiKey + language + "&with_genres=18";
		
		return restTemplate.getForObject(search, String.class);
	}

	
	public String getMovieById(long id_movie) {
		String search = url + "/movie/" + id_movie + "?api_key=" + apiKey + language;

		return restTemplate.getForObject(search, String.class);

	}
	
	//SERIES
	public String getSerieGenreList() {
		String search = url + "/genre/tv/list"+ "?api_key=" + apiKey + language;

		return restTemplate.getForObject(search, String.class);

	}
	
	public String getPopularSeries() {
		String search = url + "/tv/popular?api_key=" + apiKey + language;

		return restTemplate.getForObject(search, String.class);

	}

	public String getSeriesAiringToday() {
		String search = url + "/tv/airing_today?api_key=" + apiKey + language;

		return restTemplate.getForObject(search, String.class);

	}

	public String getSeriesOnAir() {
		String search = url + "/tv/on_the_air?api_key=" + apiKey + language;

		return restTemplate.getForObject(search, String.class);

	}

	public String getTopRatedSeries() {
		String search = url + "/tv/top_rated?api_key=" + apiKey + language;

		return restTemplate.getForObject(search, String.class);

	}
	
	public String getSeriesByGenre(int id_genre) {
		String search = url + "/discover/tv?api_key=" + apiKey + language + "&with_genres=" + id_genre;
		
		return restTemplate.getForObject(search, String.class);
 
	}
	
	public String getSpanishSerie() {

		String search = url + "/discover/tv?api_key=" + apiKey + language + "&with_origin_country=ES&with_original_language=es";
		
		return restTemplate.getForObject(search, String.class);
	}
	
	public String getActionSerie() {
		String search = url + "/discover/tv?api_key=" + apiKey + language + "&with_genres=10759";
		
		return restTemplate.getForObject(search, String.class);
	}
	
	public String getDramaSerie() {
		String search = url + "/discover/tv?api_key=" + apiKey + language + "&with_genres=18";
		
		return restTemplate.getForObject(search, String.class);
	}
	
	public String getSeriesById(long id_serie) {
		String search = url + "/tv/" + id_serie + "?api_key=" + apiKey + language;

		return restTemplate.getForObject(search, String.class);

	}
	public JsonNode searchMovies(String word) {
        String search = url + "/search/movie?api_key=" + apiKey + "&query=" + word + "&language=es-ES";
        return restTemplate.getForObject(search, JsonNode.class);
    }
 
    public JsonNode searchSeries(String word) {
        String search = url + "/search/tv?api_key=" + apiKey + "&query=" + word + "&language=es-ES";
        return restTemplate.getForObject(search, JsonNode.class);
    }
 
    public JsonNode multiSearch(String word) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode result = mapper.createObjectNode();
        result.set("movies", searchMovies(word));
        result.set("series", searchSeries(word));
        return result;
    }
}
