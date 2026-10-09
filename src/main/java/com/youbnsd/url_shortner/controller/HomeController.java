package com.youbnsd.url_shortner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class HomeController {
       @RequestMapping("/")
       public String index() {
            String view = getviewmethode();
          return view; 
        }
         private String getviewmethode() {
             return "index.html" ;
         }
    }
    // homecontroller ;