package APS2.ProgramerskaNaloga4;
import java.util.HashSet;
import java.util.Set;

public class GRPH {
    private int st_vozlisc;
    private Integer[][] povezave;

    public GRPH(int verticesCount){
        this.st_vozlisc = verticesCount;
        this.povezave = new Integer[verticesCount][verticesCount];
        for (int i = 0; i < verticesCount; i++)
            this.povezave[i][i] = 0;
    }

    public void addEdge(int from, int to, int cost){
        if (from < this.st_vozlisc && to < this.st_vozlisc)
            this.povezave[from][to] = cost;
    }

    public void printShortestDistsFrom(int from){
        System.out.println("V .. Cena");
        Integer cena;
        for(int i = 0; i < this.st_vozlisc; i++){
            cena = najkrajsa(from, i, new HashSet<>());
            if (cena == null)
                System.out.println(i + " .. None");
            else
                System.out.println(i + " .. " + cena.toString());
        }
    }

    public Integer najkrajsa(int from, int to, Set<Integer> tocke){
        if (from == to)
            return 0;
        if (tocke.contains(from))
            return null;
        tocke.add(from);
        int maks = 2147483647;
        int tmp;
        Integer najkr;
        for (int i = 0; i < this.st_vozlisc; i++){
            if (this.povezave[from][i] == null || from == i)
                continue;
            najkr = najkrajsa(i, to, tocke);
            if (najkr == null)
                continue;
            tmp = this.povezave[from][i] + najkr;
            if (tmp < maks)
                maks = tmp;
        }
        if (maks == 2147483647)
            return null;
        return maks;
    }
}