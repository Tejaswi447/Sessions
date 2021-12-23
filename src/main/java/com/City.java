package com;
import session1.*;
import java.util.*;
public class City {
    private String Cityname;
    private List<Employee> employee=new ArrayList<>();

    public City(String Cityname, Employee...employee) {
        this.Cityname = Cityname;
        this.employee.addAll(Arrays.asList(employee));
    }

    public String getCityName() {
        return Cityname;
    }

    public void setCityName(String name) {
        this.Cityname = Cityname;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + Cityname + '\'' +
                ", employee=" + employee +
                '}';
    }
}
