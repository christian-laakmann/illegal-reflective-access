package com.example.demo;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class DataService {

  private final MongoOperations template;

  public DataService(MongoOperations template) {
    this.template = template;
  }

  public void saveData() {
    Data d = new Data();
    d.setDescription("demo");

    template.save(d);
  }
}
