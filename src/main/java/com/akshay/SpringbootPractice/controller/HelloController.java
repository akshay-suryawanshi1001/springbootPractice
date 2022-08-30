package com.akshay.SpringbootPractice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${welcome.message.config}")   //this is how u use value from app.prop
	private String myMessage;
	
	@RequestMapping(value = "/", method = RequestMethod.GET )
	public String hello() {
		return "welcome akshay ";
	}
}