package APS2.ProgramerskaNaloga4;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class LBR {
    int[][] labirint;
    int n, m;

    public LBR(int[][] cells){
        this.labirint = cells;
        this.n = this.labirint.length;
        if (this.n == 0)
            this.m = -1;
        else
            this.m = this.labirint[0].length;

    }

    public void printPath(int from, int to){
        if (m == -1 || from > this.m*this.n || to > this.m*this.n){
            System.out.println("None");
            return;
        }
        int[] start = this.dekoder(from);
        int[] cilj = this.dekoder(to);
        ArrayList<String> poti = this.najdiPot(start[1], start[0], cilj[1], cilj[0], new HashSet<>());
        String najkr = this.najkrajsa(poti);
        izpisiPot(najkr, from);
    }

    public void izpisiPot(String pot, int stevilo){
        if (pot.equals("rip")){
            System.out.println("None");
            return;
        }
        System.out.println("Length "+ pot.length() +":");
        System.out.println(stevilo);
        for (int i = 0; i < pot.length(); i++){
            stevilo += scout(pot.charAt(i));
            System.out.println(stevilo);
        }
    }

    private int scout(char znak){
        switch (znak){
            case 'S':
                return -this.m;
            case 'J':
                return this.m;
            case 'Z':
                return -1;
            case 'V':
                return 1;
        }
        return 0;
    }

    public int[] dekoder(int tocka){
        int y, x;
        y = tocka/this.m;
        x = tocka%this.m;
        if (x == 0) {
            x = this.m;
            y -= 1;
        }
        return new int[] { y, x-1 };
    }

    public int vrniStevilo(int[] start){
        int stevilo;
        if (start[1] == m-1)
            stevilo = m*(start[0] + 1);
        else
            stevilo = m*start[0] + start[1] + 1;
        return stevilo;
    }

    public String najkrajsa(ArrayList<String> poti){
        int len = 2147483647;
        String trenutna = "";
        for (String i:poti){
            if (i.length() < len){
                len = i.length();
                trenutna = i;
            }
        }
        return trenutna;
    }

    public ArrayList<String> najdiPot(int x, int y, int x2, int y2, HashSet<Integer> tocke){
        if (x == x2 && y == y2){
            return new ArrayList<>(Collections.singletonList(""));
        }
        String smeri = "SVJZ";
        int[][] vrednosti = new int[][] { {y-1, y, y+1, y}, {x, x+1, x, x-1} };
        char smer;
        int x3, y3, poti;
        poti = 0;
        ArrayList<String> point, paths;
        paths = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            smer = smeri.charAt(i);
            x3 = vrednosti[1][i];
            y3 = vrednosti[0][i];
            if (0 <= x3 && x3 < this.m && 0 <= y3 && y3 < this.n && !tocke.contains(this.vrniStevilo(new int[] { y3, x3 })) && this.labirint[y3][x3] == 0){
                tocke.add(this.vrniStevilo(new int[] { y3, x3 }));
                point = this.najdiPot(x3, y3, x2, y2, tocke);
                tocke.remove(this.vrniStevilo(new int[] { y3, x3 }));
                for (String pot:point){
                    if (pot.equals("rip"))
                        continue;
                    paths.add(smer + pot);
                    poti++;
                }
            }
        }
        if (poti == 0)
            paths.add("rip");
        return paths;
    }
}
