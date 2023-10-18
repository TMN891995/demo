package com.example.demo;

import net.sf.jasperreports.data.http.RequestMethod;
import net.sf.jasperreports.engine.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.client.WebClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.jar.JarException;

@RestController
public class HelloController {

	@GetMapping("/api")
	public String index() throws FileNotFoundException, JarException {
	   // return "Greetings from Spring Boot!";
	  String url = "http://localhost:8081/jasperserver/rest_v2/login?j_username=jasperadmin&j_password=jasperadmin";

		WebClient.Builder builder = WebClient.builder();
		String response = builder
				.build()
				.get()
				.uri(url)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		// Document document = Jsoup.parse(response);
		// return document.html();
		return response;
}



}

