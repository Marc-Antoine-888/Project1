package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    ArrayList<String> listLangages = new ArrayList<>(Arrays.asList("Php", "Java", "C#", "Ada"));

	    //1 Trier Arraylist
        Collections.sort(listLangages);
        System.out.println(listLangages);
        //2 Inverser Arraylist
        Collections.reverse(listLangages);
        System.out.println(listLangages);

        //3 Afficher index impairs
        ArrayList<Integer> listInt = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        displayIndexImpair(listInt);

        //4 copier ArrayList dans un autre
        ArrayList<String> listFrameworks = new ArrayList<>(Arrays.asList("String", ".NET", "JavaFX", "Laravel"));
        Collections.copy(listLangages, listFrameworks);
        System.out.println(listLangages);

        //5 Mélanger éléments d'un arrayList
        Collections.shuffle(listLangages);
        System.out.println(listLangages);

        //6 Sous-liste
        List<Integer> subListInt = listInt.subList(3, 5);

        // 7. ArrayList à partir int[]
        ArrayList<Integer> list = new ArrayList<>();
        int[] tab = {1,2,3,4,5,6,7,8,9};
        for (int elem: tab) {
            list.add(elem);
        }
        System.out.println(list);

        //8 Afficher entiers pairs
        System.out.println();
        displayPair(list);

        int m = Collections.max(list);
        System.out.println();
        System.out.println(m);

    }

    private static void displayPair(ArrayList<Integer> list) {
        for (Integer item: list) {
            if (item % 2 == 0) {
                System.out.print(item + " ");
            }
        }
    }

    private static void displayIndexImpair(ArrayList<Integer> listInt) {
        for (int i = 0; i<listInt.size(); i++) {
            if (i % 2 == 1) {
                System.out.print(listInt.get(i) + " ");
            }
        }
    }


}
