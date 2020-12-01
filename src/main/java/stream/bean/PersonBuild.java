package stream.bean;


public class PersonBuild {
  private  String name;
  private   Integer age;

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public static  Builder builder() {
    return new PersonBuild.Builder();
  }

  public static class Builder {
    private String name;
    private Integer age;

    public PersonBuild build() {
      return new PersonBuild();
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
