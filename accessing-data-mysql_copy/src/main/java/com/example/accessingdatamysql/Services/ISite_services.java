package com.example.accessingdatamysql.Services;

import java.util.List;

import com.example.accessingdatamysql.atis.Entity.Site;

import org.springframework.data.domain.Pageable;

public interface ISite_services {
    
    List<Site> findAll(Pageable pageable);
    List<Site> sitesAtPage(int page);
    List<Site> sitesByCustomer(String customer_name);

}
