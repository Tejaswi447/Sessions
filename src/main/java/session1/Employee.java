package session1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Employee {
    protected int id;
    protected String name;
    protected String salary;
    protected int age;

    public Employee() {

    }

    public Employee(Integer id, String name, String salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", age=" + age +
                '}';
    }

    @SuppressWarnings("unused")
    public void greet() {
        System.out.println("hi, I am " + this.name + "and I am " + this.age + "old!");
    }

    @Deprecated
    @SuppressWarnings("deprication")
    public String details() {
        return String.format("%d %s %s %d", this.id, this.name, this.salary, this.age);
    }
}

@Target({ElementType.CONSTRUCTOR,ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)//scope
@interface version {
    int value() default 1;
    String author();
}
