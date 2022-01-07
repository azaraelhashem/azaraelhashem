package com.example.accessingdatamysql.controller;

import java.util.List;

import com.example.accessingdatamysql.Services.ISite_services;
import com.example.accessingdatamysql.atis.Entity.Site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;


@CrossOrigin(origins = "*")
@RestController
public class Site_controller {
    
    @Autowired
    private ISite_services site_service;
 
    @GetMapping(path = "/Sites/all")
    public @ResponseBody List<Site> show_Sites(@Parameter Pageable pageable){                  
        return (List<Site>)site_service.findAll(pageable);
    }
    @Operation(summary = "Get the list of Sites by its page")
    @GetMapping(path = "/Sites")
    public @ResponseBody Iterable<Site> atPage(@Parameter (description = "page number") int page){
        page = page*10;
        return site_service.sitesAtPage(page);
    }

    @GetMapping(path = "/Sites/filtered")
    public @ResponseBody Iterable<Site> findByCustomerName(@RequestParam String cus_name){       
        return site_service.sitesByCustomer(cus_name);
    }

}
