import implementations.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList testlist = new ArrayList<>();
        testlist.add(1);
        testlist.add(2);
        testlist.add(3);
        testlist.add(4);
        testlist.add(4);
        testlist.add(4);
        System.out.println(testlist.get(0));
        System.out.println(testlist.get(1));
        testlist.add(0,9);
        System.out.println(testlist.get(0));
        System.out.println(testlist.get(1));
//        System.out.println(testlist.get(4));

    }
}
