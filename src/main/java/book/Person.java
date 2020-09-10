package book;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

  @JsonProperty(value = "name")
  private String name;

  public Person() {
  }

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
