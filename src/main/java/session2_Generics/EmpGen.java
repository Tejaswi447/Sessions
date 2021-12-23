package session2_Generics;
import java.util.*;
public class EmpGen<T> {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean add(List<T> list, List<T> list1){
        list.addAll(list1);
        for(T value:list){
            System.out.println(value);
        }
        return true;


    }
}
