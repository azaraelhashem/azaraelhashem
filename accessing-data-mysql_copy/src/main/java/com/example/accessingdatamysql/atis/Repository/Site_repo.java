package com.example.accessingdatamysql.atis.Repository;

import java.util.List;

import com.example.accessingdatamysql.atis.Entity.Site;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface Site_repo extends CrudRepository <Site, Integer> {
  
    @Query(value = 
    "SELECT "+
    "s.id,"+
    "c.name AS customer_name,"+
    "s.site_id,"+
    "s.name AS site_name,"+
    "s.address,"+
    "s.date_activated,"+
    "s.is_active,"+
    "s.status "+
    "FROM sites_site s,customers_customer c "+
    "WHERE s.customer_id = c.id ", nativeQuery = true)
    List<Site> all(Pageable pageable);

    @Query(value = 
    "SELECT "+
    "s.id,"+
    "c.name AS customer_name,"+
    "s.site_id,"+
    "s.name AS site_name,"+
    "s.address,"+
    "s.date_activated,"+
    "s.is_active,"+
    "s.status "+
    "FROM sites_site s,customers_customer c "+
    "WHERE s.customer_id = c.id "+
    "ORDER BY s.id "+
    "OFFSET ?1 ROWS FETCH NEXT 10 ROWS ONLY;", nativeQuery = true)
    List<Site> AtPage(int startingRow);

    @Query(value = 
    "SELECT "+
    "s.id,"+
    "c.name AS customer_name,"+
    "s.site_id,"+
    "s.name AS site_name,"+
    "s.address,"+
    "s.date_activated,"+
    "s.is_active,"+
    "s.status "+
    "FROM sites_site s,customers_customer c "+
    "WHERE s.customer_id = c.id "+
    //filter//
    "AND c.name ILIKE %?1% "+
    "ORDER BY s.id "+
    "OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;", nativeQuery = true)
    List<Site> findByCustomer_name(String customer_name);
}
