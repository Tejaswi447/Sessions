package session4_annotations;
import java.lang.reflect.Method;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        Annotations employee = new Annotations(12, "teju", "10,000", 21);
        employee.setDepartment("abc");
        System.out.println(( employee).getDepartment());

        System.out.println(employee.toString().toUpperCase(Locale.ROOT));

        //Annotation[] annotations = employee.getClass().getAnnotations();
        //System.out.printf( "%d", annotations.length);


        Annotations obj = new Annotations();
        Method m = obj.getClass().getMethod("display");
        version custom = m.getAnnotation(version.class);
        System.out.println("value:" + custom.value());
        System.out.println("author:" + custom.author());
    }
}
