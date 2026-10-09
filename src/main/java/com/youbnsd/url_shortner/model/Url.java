package com.youbnsd.url_shortner.model;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "urls") 
public class Url {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id ;
    @Column(nullable = false) 
    private String OriginalUrl ;

    @Column(nullable = false, unique = true)
    private String shortCode ;

    @Column(nullable = false) 
    private LocalDateTime createdAt ;

       // JPA requires a no-args constructor
    public Url() {}

    public Url(String originalUrl, String shortCode) {
        this.OriginalUrl = originalUrl ;
        this.shortCode = shortCode ;
        this.createdAt = LocalDateTime.now() ;
    }
         
    // Getters and Setters ;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return OriginalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        OriginalUrl = originalUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
      

}
