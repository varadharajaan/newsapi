package com.sapient.newsapi.sapientNewsApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NewsApiServiceImpl implements NewsApiService{

	
	@Autowired
	public RestTemplate restTemplate;
	
	@Override
	public String getNewApiValues(String queryValue) {
		
		String uri = "https://newsapi.org/v2/everything";
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
		        .queryParam("q", queryValue)
		        .queryParam("from", "2019-06-14")
		        .queryParam("sortBy", "publishedAt")
		        .queryParam("apiKey", "2d98f7a00dc74d4c9f01e8574f8a196f");
		     
		HttpEntity<?> entity = new HttpEntity<>(headers);
		System.out.println("final url-->"+ builder.toUriString());
		HttpEntity<String> response = restTemplate.exchange(
		        builder.toUriString(), 
		        HttpMethod.GET, 
		        entity, 
		        String.class);
		return response.getBody();
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
