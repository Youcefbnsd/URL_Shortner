package com.youbnsd.url_shortner.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youbnsd.url_shortner.model.Url ;
public interface UrlRepository extends JpaRepository<Url, Long> {

  Optional<Url> findByShortCode(String shortCode);

}
