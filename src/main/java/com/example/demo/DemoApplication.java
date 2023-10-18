package com.example.demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
	SpringApplication app = new SpringApplication(DemoApplication.class);
			app.setDefaultProperties(Collections
   			.singletonMap("server.port", "8085"));

		app.run(args);
	// System.out.println("Session ID : " + DemoApplication.

	// LoginRequest("jasperadmin", "jasperadmin"));

	}
	public static String LoginRequest(String username, String password) {
			URL url = null;
			HttpURLConnection con = null;
			String jsessionId = "";
			String urlLink = "http://localhost:8081/jasperserver/j_spring_security_check?"+ "j_username=" + username+ "&j_password=" + password;
				
			try {

			url = new URL(urlLink);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			System.out.println("Login response code :" + con.getResponseCode());
			String session_id = con.toString() + "";
			int index1 = session_id.indexOf("=");
			int index2 = session_id.indexOf("?");
			jsessionId = session_id.substring(index1 + 1, index2);
			} 
			catch (IOException e) {
			e.printStackTrace();
			}
			return jsessionId;
}
}



