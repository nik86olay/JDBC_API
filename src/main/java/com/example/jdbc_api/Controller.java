package com.example.jdbc_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    WorkingDB workingDB;
    public Controller(WorkingDB workingDB) {
        this.workingDB = workingDB;
    }

    @GetMapping("/products/fetch-product")
    public List<String> profile(@RequestParam String name) {

            return workingDB.getProductName(name);
    }

}
