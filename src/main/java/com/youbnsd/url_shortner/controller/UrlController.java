package com.youbnsd.url_shortner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youbnsd.url_shortner.model.Url;
import com.youbnsd.url_shortner.service.UrlService;

@RestController
@RequestMapping("/api/urls")
public class UrlController {
          
    private final UrlService urlService;
    
     public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public ResponseEntity<Url> createShortUrl(@RequestBody CreateUrlRequest request) {
        Url created = urlService.createShortUrl(request.originalUrl());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Url> getUrlInfo(@PathVariable String shortCode) {
        Url url = urlService.getByShortCode(shortCode);
        return ResponseEntity.ok(url);
    }

    // DTO for the request body — keep it separate from the entity
    public record CreateUrlRequest(String originalUrl) {}

}
