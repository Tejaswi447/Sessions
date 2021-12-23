package session1;
import com.*;

import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Employee_Details {
    public static void main(String[] args) {


        Employee e1=new Employee(1, "Ram", "20000",55);
        Employee e2=new Employee(2, "John", "50000",23);
        Employee e3=new Employee(3, "Jack", "39200",55);
        Employee e4=new Employee(4, "Anu", "10000",21);
        Employee e5=new Employee(5, "Priya", "15000",23);
        Employee e6=new Employee(6, "Dravid", "87333",31);
        Employee e7=new Employee(7, "Joe", "33333",35);
        Employee e8=new Employee(8, "Poppy", "25000",24);
        Employee e9=new Employee(9, "Peter", "58000",43);
        Employee e10=new Employee(10, "Sarah", "60000",31);
        Employee e11=new Employee(11, "", "23444",21);

        City banglore=new City("Banglore",e1,e4,e7,e10);
        City chennai=new City("Chennai",e3,e5,e8);
        City hyderabad=new City("Hyderabad",e2,e6,e9);




        /* Five patterns to create streams-from collections,array,text fike,regular expression,string*/

        //1.Streams from array
        System.out.println("Streams from Array:");
        Employee[] employeeArray={e1,e2,e3,e4,e5};
        //one way
        long count=Stream.of(employeeArray).count();
        System.out.println("count="+count);
        //another way
        Arrays.stream(employeeArray).forEach(System.out::println);

        System.out.println("\nStreams from Regular Expression");
        //2.Streams from RegularExpression
        String sentence="Actions speak louder than words.";
        String[] words=sentence.split(" ");
        Stream<String> wordStream=Arrays.stream(words);
        long count1=wordStream.count();
        System.out.println("Number of words:"+count1);

        Pattern pattern=Pattern.compile(" ");
        long word2=pattern.splitAsStream(sentence).count();
        System.out.println("Number of words:"+word2);

        System.out.println("\nStreams from String");
        //3.Streams from string,splits sentences into characters
        String sentence1="Actions speak louder than words.";
        sentence1.chars()
                .mapToObj(codePoint->Character.toString((char) codePoint))
                .filter(letters->!letters.equals(" "))
                .distinct()
                .sorted()
                .forEach(System.out::println);



        List<Employee> employee=Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11);

         /*
        //creating streams
        //NOT ALLOWED TO PROCESS TWICE
        Stream<Employee> stream=employee.stream();
        Stream<String> nameStream = stream.map(e -> e.getEmp_name());
        Stream<String> filterNames = nameStream.filter(name -> name.isEmpty());
        long count = filterNames.count();
        System.out.println("Empty Names:"+count);

        Stream<Employee> stream2=employee.stream();
        Stream<String> nameStream2 = stream2.map(e -> e.getEmp_name());
        Stream<String> filterNames1 = nameStream2.filter(name -> !name.isEmpty());
        long count1 = filterNames1.count();
        System.out.println("Non Empty Names:"+count1);

         */

        //creating stream
        System.out.println("\nStreams");
        long countEmptyNames = employee.stream()
                .map(e -> e.getName())
                .filter(name -> !name.isEmpty())
                .count();
        System.out.println(" non Empty Names:"+countEmptyNames);

        long count5 = employee.stream()
                .map(e -> e.getAge())
                .filter(age -> age>25)
                .count();
        System.out.println("Count Above 25:"+count5);

        /*int average = employee
                .map(e -> e.getAge())
                .filter(age -> age>25)
                .average();
        System.out.println("Above 25:"+average);
        */





        //flat mapping-one to many enitites
        List<City> cities=Arrays.asList(banglore,chennai,hyderabad);
        long count3=cities.stream()
                .flatMap(city->city.getEmployee().stream())
                .count();
        System.out.println("Count number of cities:"+count3);

        cities.stream()
                .filter(x->x.getCityName().equalsIgnoreCase("banglore"))
                .flatMap(city->city.getEmployee().stream())
                .map(e->e.getName())
                .forEach(name->System.out.println(name));

        cities.stream()
                .flatMap(city->city.getEmployee().stream())
                .map(e->e.getAge())
                .filter(x->x<30)
                .forEach(name->System.out.println(name));

        /*employee.stream()
                .map(e-> e.getEmp_name())
                .flatMap(city->city.getCityName().stream().equalsIngoreCase("banglore"))
                .count()
          */














    }

}
