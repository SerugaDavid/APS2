package APS2.podatkovneStruktureVaja;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Seznam nek = new Seznam(new Element(0, 9), null);
        for (int i = 1; i < 10; i++){
            nek.insert(new Element(i, 9-i));
        }
        Random rn = new Random();
        for (int i = 0; i < 100; i++){
            int indeks = rn.nextInt(20);
            System.out.println("Indeks: "+indeks+" Vrednost: "+nek.find(indeks));
        }
        for (int i = 0; i < nek.length(); i++){
            System.out.println(nek.find(i));
            nek.delete(i);
        }
    }
}
