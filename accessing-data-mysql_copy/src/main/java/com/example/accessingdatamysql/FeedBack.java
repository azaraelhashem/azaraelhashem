package com.example.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FeedBack {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  private String fbType;
  private String description;
  private String fName;
  private String lName;
  private String email;
}
