package com.example.jdbc_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Component
public class WorkingDB {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private String scriptFileName = "request.sql";

    protected String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected List<String> getProductName(String name) {
        String readF = read(scriptFileName);
        System.out.println(readF);
        MapSqlParameterSource parameters = new MapSqlParameterSource("name", name);
        List<String> product = jdbcTemplate.queryForList(readF, parameters, String.class);
//        для отладки
        System.out.println(product);

        return product;
    }
}
