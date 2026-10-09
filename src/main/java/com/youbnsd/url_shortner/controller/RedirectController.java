package com.youbnsd.url_shortner.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.youbnsd.url_shortner.model.Url;
import com.youbnsd.url_shortner.service.UrlService;

@RestController

public class RedirectController {
       
    private final UrlService urlService ;
    public RedirectController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {
        Url url = urlService.getByShortCode(shortCode);
        HttpHeaders headers = new HttpHeaders();
         headers.add(HttpHeaders.LOCATION, url.getOriginalUrl());
        return new ResponseEntity<>(headers, HttpStatus.FOUND); // 302        
                
    }

}
