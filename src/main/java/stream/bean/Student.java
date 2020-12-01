package stream.bean;


import lombok.Data;

@Data
public class Student  {
  private Integer age;

  public Student(Builder builder) {
    this.age = builder.age;
  }

  public static class Builder{
    private Integer age;

    public Student build() {
      return new Student(this);
    }

    public  Builder withStuId(Integer age) {
      this.age = age;
      return this;
    }
  }
}
