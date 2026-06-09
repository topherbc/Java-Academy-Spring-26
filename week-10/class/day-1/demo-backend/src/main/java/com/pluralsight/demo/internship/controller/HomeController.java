package com.pluralsight.demo.internship.controller;

import com.pluralsight.demo.internship.model.Candidate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class HomeController {

    @GetMapping
    public ResponseEntity<String> getHome(@RequestParam String v) {
        return ResponseEntity.ok("Hello World " + v);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> getHomeUnique(@PathVariable String name) {
        return ResponseEntity.ok("Hello " + name);
    }


}
