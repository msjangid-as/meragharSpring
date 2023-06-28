import java.util.*;

public class collectionn


{
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add("1");
        list.add("1");
        list.add("3");
        list.add("2");
        System.out.println("List :: "+list);

        Set set=new TreeSet();
        set.add("1");
        set.add("4");
        set.add("5");
        set.add("1");
        System.out.println("Set :: "+set);

    }
}
