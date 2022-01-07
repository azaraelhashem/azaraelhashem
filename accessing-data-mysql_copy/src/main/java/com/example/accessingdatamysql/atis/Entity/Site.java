package com.example.accessingdatamysql.atis.Entity;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "sites_site")
public class Site {
    
    @Id
    private Integer id;
    private String customer_name;
    private String site_id;
    private String site_name;
    private String address;
    private Date date_activated;
    private Boolean is_active;
    private String status;

}
