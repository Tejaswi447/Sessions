package session2_Generics;

import java.util.ArrayList;

import java.util.*;
public class EmployeeGenerics<T> {
    public static void main(String[]args){
        EmpGen<String> gen=new EmpGen<>();

        List<String> string=new ArrayList<>();
        string.add("hi");
        string.add("hello");
        string.add("bye");
        gen.setList(string);
        System.out.println(gen.getList());
        List<String> string2=new ArrayList<>();
        string2.add("sindhu");
        string2.add("teju");
        string2.add("aruna");
        gen.add(string,string2);



        }
    }

