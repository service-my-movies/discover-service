package com.mymovies.controller;

import com.mymovies.service.IDiscoverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiscoverController implements IDiscoverController {
	
	@Autowired
	private IDiscoverService discoverService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DiscoverController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/discover", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getAPI_Discover() {

		LOGGER.info("@Get Discover");

		String listOfMovies = null;

		try {
			listOfMovies = discoverService.getAPI_Discover();
		} catch (Exception e) {
			LOGGER.error("Unexpected Error: getAPI_Discover: " + e);
		}

		return listOfMovies;
	}

}
