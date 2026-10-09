package com.youbnsd.url_shortner.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import com.youbnsd.url_shortner.model.Url;
import com.youbnsd.url_shortner.repository.UrlRepository;

@Service 

public class UrlService {
     
    private final UrlRepository urlRepository; 
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6;
    private final SecureRandom random = new SecureRandom();

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Url createShortUrl(String originalUrl) {
        String shortCode = generateUniqueCode();
        Url url = new Url(originalUrl, shortCode);
        return urlRepository.save(url);
    }

   public Url getByShortCode(String shortCode) {
        return urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found: " + shortCode));
    }

    private String generateUniqueCode() {
        String code;
        do {
            code = generateRandomCode();
        } while (urlRepository.findByShortCode(code).isPresent());
        return code;
    }

    private String generateRandomCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }
}

