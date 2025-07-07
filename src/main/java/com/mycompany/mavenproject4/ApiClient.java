package com.mycompany.mavenproject4;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ApiClient {
    private static final String BASE_URL_MAVENPROJECT4 = "http://localhost:8080/api/data";
    
    private static final ObjectMapper mapper = new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        public static List<Mavenproject4> getAllHistory() throws IOException {
        URL url = new URL(BASE_URL_MAVENPROJECT4);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (InputStream is = con.getInputStream()) {
            return mapper.readValue(is, new TypeReference<List<Mavenproject4>>() {});
        }
    }

}
