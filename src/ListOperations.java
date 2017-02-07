/**
 * Created by Dave on 2/7/17.
 */

import java.util.ArrayList;
import java.util.List;

public class ListOperations {

    public static void main(String[] args) {
        List <Integer> list1 = new ArrayList<>();
        List <Integer> list2 = new ArrayList<>();

        for(int i = 0; i < 15; i++) {
            int x =(int)(Math.random() * 10);
            list1.add(x);
            list2.add(i);
        }

        printList(list1);
        System.out.println();
        printList(list2);
        System.out.println();

        shrink(list1);
        printList(list1);
        System.out.println();

        List <Integer> intersection = new ArrayList<>();
        List <Integer> union = new ArrayList<>();

        intersection = intersect(list1, list2);
        union = union(list1, list2);

        printList(intersection);
        System.out.println();
        printList(union);
        System.out.println();
    }

    public static void printList(List <Integer> data) {
        for (int a: data) {
            System.out.print(a + " ");
        }
    }

    public static void shrink(List data) {
        for (int i = 0; i < data.size(); i++) {
            Object o = data.get(i);
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(j).equals(o)) {
                    data.remove(j);
                    j--;
                }
            }
        }
    }
    public static Object[] toArray(List data) {
        Object[] arr = new Object[data.size()];
        for (int i = 0; i < data.size(); i++) {
            arr[i] = data.get(i);
        }
        return arr;
    }
    public static <E> E[] toGenericArray(List<E> data) {
        E[] arr = (E[]) new Object[data.size()];
        for (int i = 0; i < data.size(); i++) {
            arr[i] = data.get(i);
        }
        return arr;
    }
    public static String toString(List data) {
        String display = "{";
        for (int i = 0; i < data.size(); i++) {
            display += data.get(i).toString() + " ";
        }
        display += "}";
        return display;
    }
    public static List clone(List data) {
        List clone = new ArrayList(data);
        return clone;
    }
    public static List skip(List data, int n) {
        List skipList = new ArrayList();
        for (int i = n - 1; i < data.size(); i += n) {
            skipList.add(data.get(i));
        }
        return skipList;
    }
    public static boolean contains(List data, Object target) {
        List temp = new ArrayList(data);
        return temp.contains(target);
    }
    public static List intersect(List data, List other) {
        List intersect = new ArrayList();
        shrink(data);
        shrink(other);
        for (int i = 0; i < data.size(); i++) {
            if (other.contains(data.get(i))) {
                intersect.add(data.get(i));
            }
        }
        return intersect;
    }
    public static List union(List data, List other) {
        List union = new ArrayList();
        union.addAll(data);
        union.addAll(other);
        shrink(union);
        return union;
    }
}

