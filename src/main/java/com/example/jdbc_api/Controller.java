package com.example.jdbc_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    WorkingDB workingDB;

    @GetMapping("/products/fetch-product")
    public List<String> Profile(@RequestParam String name) {

            return workingDB.getProductName(name);
    }

}
