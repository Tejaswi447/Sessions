package session4_annotations;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import session1.*;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR,ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)//scope
@interface version {
    int value() default 1;
    String author();
}

@version(author = "Tejaswi" )
@ToString
@Getter
@Setter

public class Annotations extends Employee{

    public String getDepartment() {
        return department;
    }

    public void setDepartment( @NonNull String department) {
        this.department = department;
    }

    protected  String department;


    @SuppressWarnings("unused")
    public Annotations(){ }

    public Annotations(int id, String name, String salary, int age){
    super(id,name,salary,age);
    }

   @Override
   @SuppressWarnings("deprecation")
    public String details(){
        return String.format("%d %s %s %d #",this.id,this.name,this.salary,this.age);
    }
    @version(author = "Tejaswi" )
    public void display(){
        System.out.println("Custom annotations");
    }
}
