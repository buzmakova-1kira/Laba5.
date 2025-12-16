package processor;

import java.util.*;

public class ListProcessor {
    public static <T> List<T> createList(List<T> l1, List<T> l2) {
        List<T> result = new ArrayList<>();

        for (T element : l1) {
            if (!l2.contains(element) && !result.contains(element)) {
                result.add(element);
            }
        }

        for (T element : l2) {
            if (!l1.contains(element) && !result.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }


    public static <T> void printList(String name, List<T> list) {
        System.out.print(name + ": [");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}