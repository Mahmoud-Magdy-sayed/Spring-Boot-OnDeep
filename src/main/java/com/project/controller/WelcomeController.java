package com.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.configuration.BasicConfiguration;
import com.project.service.WelcomeService;

@RestController
public class WelcomeController {

	@Autowired
	private WelcomeService service;
	
	@Autowired
    private BasicConfiguration configuration;

	@RequestMapping("/welcome")
	public String welcome() {
		return service.retrieveWelcomeMessage();
	}

    @RequestMapping("/dynamic-configuration")
    public Map dynamicConfiguration() {
        // Not the best practice to use a map to store differnt types!
        Map map = new HashMap();
        map.put("message", configuration.getMessage());
        map.put("number", configuration.getNumber());
        map.put("key", configuration.isValue());
        return map;
    }
}
