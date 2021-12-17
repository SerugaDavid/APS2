package APS2.ProgramerskaNaloga1;

import sun.rmi.runtime.Log;

public class Test {
    public static void main(String[] args) {
        //test1();
        //test2();
        //tabelaRand();
        //testFind();
        //testInsert();
        testDiscord();
    }

    public static void testDiscord(){
        Seznam s = null;
        int[] testiranje = {59, 75, 65, 1, 8, 31, 4, 62, 35, 76, 3, 16, 88, 54, 73, 99, 52, 97, 19, 48, 13, 36, 12, 56, 11, 50, 10, 77, 28, 34, 64, 15, 2, 42, 71};
        for(int i = 0; i < testiranje.length; i++) {
            s = Seznam.insert(s, new Elt(testiranje[i]));
        }
        Seznam.printElementKeys(s);
        System.out.println("----------------------------------------------------------");
        Seznam.printElementKeyComparisons(s);

        for(int i = 10; i <= 20; i++) {
            s = Seznam.delete(s, i);
        }

        System.out.println("----------------------------------------------------------");
        Seznam.printElementKeys(s);
        System.out.println("----------------------------------------------------------");
        Seznam.printElementKeyComparisons(s);

        int[] najdi = {16, 73, 36, 28, 42, 19, 99, 10, 52, 13, 48, 97, 3, 1, 35, 62, 77, 2, 4, 54, 71, 12, 65, 15, 56, 8, 50, 34, 75, 11, 59, 31, 88, 76, 64};

        for (int i = 0; i < najdi.length; i++) {
            Seznam.find(s, najdi[i]);
        }

        System.out.println("----------------------------------------------------------");
        Seznam.printElementKeyComparisons(s);
        System.out.println("----------------------------------------------------------");
    }

    public static void testFind(){
        System.out.println();
        System.out.println("Tese Find: ");
        Seznam s = new Seznam(new Elt(2), new Seznam(new Elt(4), new Seznam(new Elt(6), new Seznam(new Elt(8), null))));
        for (int i = 2; i < 10; i+=2){
            Elt tmp = Seznam.find(s, i);
            System.out.println(tmp);
        }
        System.out.println();
        for (int i = 1; i < 10; i+=2){
            Elt tmp = Seznam.find(s, i);
            System.out.println(tmp);
        }
        System.out.println();
        s = new Seznam(new Elt(2), new Seznam(null, new Seznam(new Elt(6), new Seznam(new Elt(8), null))));
        for (int i = 2; i < 10; i+=2){
            Elt tmp = Seznam.find(s, i);
            System.out.println(tmp);
        }
        System.out.println();
        for (int i = 1; i < 10; i+=2){
            Elt tmp = Seznam.find(s, i);
            System.out.println(tmp);
        }
        System.out.println();
    }

    public static void testInsert(){
        System.out.println();
        System.out.println("Test Insert");
        Seznam s = null;
        for (int i = 0; i < 10; i++){
            s = Seznam.insert(s, new Elt(i));
        }
        Seznam.printElementKeys(s);
        System.out.println();
        for (int i = 0; i < 10; i++){
            s = Seznam.insert(s, new Elt(i));
        }
        Seznam.printElementKeys(s);
        System.out.println();
        for (int i = 0; i < 10; i++){
            if (i%2 == 0)
                s = Seznam.insert(s, null);
            else
                s = Seznam.insert(s, new Elt(i*10));
        }
        Seznam.printElementKeys(s);
        System.out.println();
    }

    public static void testDelete(){

    }

    public static void tabelaRand(){
        int[] nekaTabela = new int[5000000];
        for (int i = 0; i < nekaTabela.length; i++){
            nekaTabela[i] = 3*i;
        }
        long cas1 = System.nanoTime();
        for (int i = 0; i < nekaTabela.length; i++){
            System.out.println(nekaTabela[i]);
        }
        cas1 = System.nanoTime() - cas1;
        long cas2 = System.nanoTime();
        for (int i:nekaTabela){
            System.out.println(i);
        }
        cas2 = System.nanoTime() - cas2;
        System.out.println();

        System.out.println("Prva zanka:  "+cas1);
        System.out.println("Druga zanka: "+cas2);
        System.out.println("Razmerje: "+Double.toString((double)cas1/(double)cas2));
    }

    public static void test2(){
        Seznam s = null;
        System.out.println(Seznam.find(s, 5));
    }

    public static void test1(){
        Seznam s = null;
        s = Seznam.insert(s,new Elt(5));
        s = Seznam.insert(s,new Elt(3));
        s = Seznam.insert(s,new Elt(2));
        s = Seznam.insert(s,new Elt(4));
        s = Seznam.insert(s,new Elt(8));
        s = Seznam.insert(s,new Elt(5));
        s = Seznam.insert(s,new Elt(3));
        s = Seznam.insert(s,new Elt(7));
        s = Seznam.insert(s,new Elt(4));
        s = Seznam.insert(s,new Elt(1));
        s = Seznam.insert(s,new Elt(6));
        System.out.println("Elementi:");
        Seznam.printElementKeys(s);
        System.out.println("Število primerjav:");
        Seznam.printElementKeyComparisons(s);

        s = Seznam.delete(s, 1);
        s = Seznam.delete(s, 8);
        s = Seznam.delete(s, 2);
        System.out.println("Elementi:");
        Seznam.printElementKeys(s);
        System.out.println("Število primerjav:");
        Seznam.printElementKeyComparisons(s);

        s = Seznam.delete(s, 3);
        s = Seznam.delete(s, 7);
        System.out.println("Elementi:");
        Seznam.printElementKeys(s);
        System.out.println("Število primerjav:");
        Seznam.printElementKeyComparisons(s);

        s = Seznam.insert(s,new Elt(2));
        s = Seznam.insert(s,new Elt(4));
        s = Seznam.insert(s,new Elt(8));
        s = Seznam.insert(s,new Elt(5));
        s = Seznam.insert(s,new Elt(3));
        s = Seznam.insert(s,new Elt(7));
        System.out.println("Elementi:");
        Seznam.printElementKeys(s);
        System.out.println("Število primerjav:");
        Seznam.printElementKeyComparisons(s);

        System.out.println("Find: ");
        StringBuilder niz;
        for (int i = 0; i <= 10; i++){
            niz = new StringBuilder();
            niz.append(i).append(": ");
            Elt tmp = Seznam.find(s, i);
            if (tmp == null)
                niz.append("null");
            else
                niz.append(tmp.key);
            System.out.println(niz.toString());
        }
        System.out.println("Število primerjav:");
        Seznam.printElementKeyComparisons(s);

        for (int i = 0; i < 10; i++){
            s = Seznam.delete(s, i);
            Seznam.printElementKeys(s);
            System.out.println();
        }
        System.out.println("Število primerjav:");
        Seznam.printElementKeyComparisons(s);

        s = Seznam.insert(s,new Elt(2));
        s = Seznam.insert(s,new Elt(4));
        s = Seznam.insert(s,new Elt(8));
        s = Seznam.insert(s,new Elt(5));
        s = Seznam.insert(s,new Elt(3));
        s = Seznam.insert(s,new Elt(7));
        System.out.println("Elementi:");
        Seznam.printElementKeys(s);
        System.out.println("Število primerjav:");
        Seznam.printElementKeyComparisons(s);

        for (int i = 0; i < 10; i++){
            s = Seznam.delete(s, i);
            Seznam.printElementKeys(s);
            System.out.println();
        }
        System.out.println("Število primerjav:");
        Seznam.printElementKeyComparisons(s);

        for (int i = 0; i < 10; i++){
            System.out.println(Seznam.find(s, i).key);
        }
        System.out.println("Število primerjav:");
        Seznam.printElementKeyComparisons(s);
    }
}
