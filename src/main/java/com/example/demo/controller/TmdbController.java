package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.ProductResponseDto;
import com.example.demo.service.ProductDtoService;
import com.example.demo.service.TmdbService;
import com.fasterxml.jackson.databind.JsonNode;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("")
@Tag(name = "Endpoint peliculas")
public class TmdbController {
	
	private final AppException appException = new AppException("Api external error", HttpStatus.INTERNAL_SERVER_ERROR);
	
	@Autowired
	private TmdbService apiService;
	
	@Autowired
	private ProductDtoService productDtoService;

	@Operation(summary = "Obtencion de todos los generos de la categoria peliculas")
	// LISTA de GENEROS de películas
	@GetMapping("/movies/genrelist")
	public ResponseEntity<?> getMovieGenreList() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String genre = apiService.getMovieGenreList();
			responseContent.put("result", genre);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}
	
	

	@Operation(summary = "Obtencion de las peliculas de origen español")
	// Peliculas populares ESPAÑOLAS
	@GetMapping("/movies/spanish/{page}")
	public ResponseEntity<?> getSpanishMovie(@PathVariable int page) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String spanishMovie = apiService.getSpanishMovie(page);
			responseContent.put("result", spanishMovie);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}

	@Hidden
	// Peliculas de ACCION
	@GetMapping("/movies/genre/action")
	public ResponseEntity<?> getActionMovie() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String actionMovies = apiService.getActionMovie();
			responseContent.put("result", actionMovies);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}

	@Hidden
	// Peliculas de DRAMA
	@GetMapping("/movies/genre/drama")
	public ResponseEntity<?> getDramaMovie() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String dramaMovies = apiService.getDramaMovie();
			responseContent.put("result", dramaMovies);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}

	@Operation(summary = "Obtencion de las peliculas mas populares")
	// Películas populares
	@GetMapping("/movies/popular")
	public ResponseEntity<?> getPopularMovies() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String popularMovies = apiService.getPopularMovies();
			responseContent.put("result", popularMovies);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}

	
	@Operation(summary = "Obtencion de las películas en cartelera")
	// Películas en cartelera
	@GetMapping("/movies/current")
	public ResponseEntity<?> getCurrentMovies() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String currentMovies = apiService.getCurrentMovies();
			responseContent.put("result", currentMovies);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}

	@Operation(summary = "Obtencion de las peliculas sin estrenar")
	// Películas próximas
	@GetMapping("/movies/upcoming")
	public ResponseEntity<?> getUpcomingMovies() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String upcomingMovies = apiService.getUpcomingMovies();
			responseContent.put("result", upcomingMovies);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}

	@Operation(summary = "Obtencion de las peliculas mejor valoradas")
	// Películas mejor valoradas
	@GetMapping("/movies/toprated")
	public ResponseEntity<?> getTopRatedMovies() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String topRatedMovies = apiService.getTopRatedMovies();
			responseContent.put("result", topRatedMovies);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}

	
	@Operation(summary = "Obtencion de las películas de un genero a traves del id del genero")
	// Filtrar Películas por genero
	@GetMapping("/movies/genre/{id_genre}/{page}")
	public ResponseEntity<?> getMoviesByGenre(@PathVariable int id_genre,@PathVariable int page) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String moviesByGenre = apiService.getMoviesByGenre(id_genre,page);
			responseContent.put("result", moviesByGenre);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}

	/*
	@Operation(summary = "Obtencion de una pelicula a traves de su id")
	@GetMapping("/movies/search/{id_movie}")
	public ResponseEntity<?> getMovieById(@PathVariable long id_movie) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String movieById = apiService.getMovieById(id_movie);
			responseContent.put("result", movieById);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}
	*/
	
	
	// Buscar Películas por ID
	@GetMapping("/movies/search/{movieId}")
	public ResponseEntity<?> getMovieById(@PathVariable Long movieId, @RequestHeader(value = "Authorization", required = false) String token) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String movie = apiService.getMovieById(movieId);
			ProductResponseDto movieDto = productDtoService.createProductResponseDto(movie, token, movieId, true);
			responseContent.put("result", movieDto);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}

//SERIES

	
	// LISTA de GENEROS de series
	@Operation(summary = "Obtencion de todos los generos de la categoria series")
	@GetMapping("/series/genrelist")
	public ResponseEntity<?> getSerieGenreList() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String serieGenreList = apiService.getSerieGenreList();
			responseContent.put("result", serieGenreList);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}

	@Operation(summary = "Obtencion de las series de origen español")
	// Series populares ESPAÑOLAS
	@GetMapping("/series/spanish/{page}")
	public ResponseEntity<?> getSpanishSerie(@PathVariable int page) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String spanishSerie = 	apiService.getSpanishSerie(page);;
			responseContent.put("result", spanishSerie);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}

	@Hidden
	// Series de ACCION
	@GetMapping("/series/genre/action")
	public ResponseEntity<?> getActionSerie() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String actionSerie = apiService.getActionSerie();
			responseContent.put("result", actionSerie);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}

	@Hidden
	// Series de DRAMA
	@GetMapping("/series/genre/drama")
	public ResponseEntity<?> getDramaSerie() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String dramaSerie = apiService.getDramaSerie();
			responseContent.put("result", dramaSerie);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response; 

	}

	@Operation(summary = "Obtencion de las peliculas populares")
	// Series populares
	@GetMapping("/series/popular")
	public ResponseEntity<?> getPopularSeries() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String popularSeries = apiService.getPopularSeries();
			responseContent.put("result", popularSeries);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response; 

	}

	@Operation(summary = "Obtencion de las series que se emiten hoy")
	// Series que se emiten hoy
	@GetMapping("/series/today")
	public ResponseEntity<?> getSeriesAiringToday() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String seriesAiringToday = apiService.getSeriesAiringToday();
			responseContent.put("result", seriesAiringToday);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response; 

	}

	 @Operation(summary = "Obtencion de las series en emision")
	// Series en emisión
	@GetMapping("/series/onair")
	public ResponseEntity<?> getSeriesOnAir() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String seriesOnAir = apiService.getSeriesOnAir();
			responseContent.put("result", seriesOnAir);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}

	@Operation(summary = "Obtencion de las series mejor valoradas")
	// Series mejor valoradas
	@GetMapping("/series/toprated")
	public ResponseEntity<?> getTopRatedSeries() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String topRatedSeries = apiService.getTopRatedSeries();
			responseContent.put("result", topRatedSeries);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response; 

	}

	@Operation(summary = "Obtencion de las series de un genero a traves de la id del genero")
	// Filtrar Series por genero
	@GetMapping("/series/genre/{id_genre}/{page}")
	public ResponseEntity<?> getSeriesByGenre(@PathVariable int id_genre,@PathVariable int page) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String seriesByGenre = apiService.getSeriesByGenre(id_genre,page);
			responseContent.put("result", seriesByGenre);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response; 

	}
	
	
	/*
	@Operation(summary = "Obtencion de una serie a traves de su id")
	// Buscar serie por ID
	@GetMapping("/series/search/{serieId}")
	public ResponseEntity<?> getSeriesById(@PathVariable long serieId) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String seriesById = apiService.getSeriesById(serieId);;
			responseContent.put("result", seriesById);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response; 

	}
	*/
	
	@GetMapping("/series/search/{serieId}")
	public ResponseEntity<?> getSeriesById(@PathVariable Long serieId, @RequestHeader(value = "Authorization", required = false) String token) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			String serie = apiService.getSeriesById(serieId);
			ProductResponseDto serieDto = productDtoService.createProductResponseDto(serie, token, serieId, false);
			responseContent.put("result", serieDto);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response; 

	}

	 
	@Operation(summary = "Obtencion de peliculas por palabra clave")
	// Buscar películas o series por palabra clave
	@GetMapping("/search")
	public ResponseEntity<?> searchMulti(@RequestParam String query) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			JsonNode multiSearch = apiService.multiSearch(query);
			responseContent.put("result", multiSearch);
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			responseContent.put("message", appException.getMessage());
			httpStatus = appException.getHttpStatus();
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
}
