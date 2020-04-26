package com.mymovies.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DiscoverService implements IDiscoverService {

	@Value("${resource.api.url.base}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;

	private static final Logger LOGGER = LoggerFactory.getLogger(DiscoverService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getAPI_Discover(String page_number) {

		String discover = null;

		String url = BASE_URL+API_KEY+Language+"&sort_by=popularity.desc&include_adult=false&include_video=false&year=2019&page=";
				
		try {
			discover = restTemplate.getForObject(url+page_number, String.class);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Service: getAPI_Discover: " + e);
		}

		return discover;

	}

}