package com.example.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FeedBack {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  public Integer getId() {
    return id;
}
public void setId(Integer id) {
    this.id = id;
}
public String getFbType() {
    return fbType;
}
public void setFbType(String fbType) {
    this.fbType = fbType;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
public String getfName() {
    return fName;
}
public void setfName(String fName) {
    this.fName = fName;
}
public String getlName() {
    return lName;
}
public void setlName(String lName) {
    this.lName = lName;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
private String fbType;
  private String description;
  private String fName;
  private String lName;
  private String email;

}
