package com.sapient.newsapi.sapientNewsApi.controller;

import java.util.logging.LogManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.newsapi.sapientNewsApi.service.NewsApiService;

@RestController
@RequestMapping("/newsApi/v2")
public class NewsApiController {
	
	@Autowired
	private NewsApiService newsApiService;
	
	private static final Logger logger = LoggerFactory.getLogger(NewsApiController.class);
	
	@GetMapping("/everything")
	public ResponseEntity<String> getNewsApiStreams(@RequestParam("q") final String queryValue) {
		
		String value = null;
		value = newsApiService.getNewApiValues(queryValue);
		return new ResponseEntity<>(value, HttpStatus.ACCEPTED);
		
	}

}
