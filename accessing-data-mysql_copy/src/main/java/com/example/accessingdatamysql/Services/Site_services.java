package com.example.accessingdatamysql.Services;

import java.util.List;

import com.example.accessingdatamysql.atis.Entity.Site;
import com.example.accessingdatamysql.atis.Repository.Site_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class Site_services implements ISite_services {
    
    @Autowired
    private Site_repo site_repo;

    @Override
    public List<Site> findAll(Pageable pageable){
        var sites = site_repo.all(pageable);
        return sites;
    }

    @Override
    public List<Site> sitesAtPage(int page){
        var sites = (List<Site>) site_repo.AtPage(page);
        return sites;
    }

    @Override
    public List<Site> sitesByCustomer(String customer_name){
        var sites = (List<Site>) site_repo.findByCustomer_name(customer_name);
        return sites;
    }
}
