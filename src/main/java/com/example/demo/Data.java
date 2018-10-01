package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "demo")
@TypeAlias("demo-data")
public class Data {

  @Id
  private String identifier;
  private String description;

  public String getIdentifier() {

    return identifier;
  }

  public void setIdentifier(String identifier) {

    this.identifier = identifier;
  }

  public String getDescription() {

    return description;
  }

  public void setDescription(String description) {

    this.description = description;
  }
}
