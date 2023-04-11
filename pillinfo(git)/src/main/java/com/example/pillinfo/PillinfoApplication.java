package com.example.pillinfo;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
@SpringBootApplication
public class PillinfoApplication {
	public static void main(String[] args) {
		SpringApplication.run(PillinfoApplication.class, args);
	}

}
