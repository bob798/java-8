package stream.bean;

import lombok.Data;


public class Person {
  private final String name;
  private final  Integer age;

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public static  Builder builder() {
    return Person.Builder;
  }

  public static class Builder {
    private String name;
    private Integer age;

    public Person build() {
      return new Person(this);
    }
    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withAge(Integer age) {
      this.age = age;
      return this;
    }
  }
}
