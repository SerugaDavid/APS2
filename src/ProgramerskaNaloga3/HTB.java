package APS2.ProgramerskaNaloga3;

public class HTB {
    private int m, p, c1, c2, sovpadanja;
    private Integer[] tabela;

    public HTB(int p, int m, int c1, int c2){
        this.p = p;
        this.m = m;
        this.c1 = c1;
        this.c2 = c2;
        this.tabela = new Integer[m];
        this.sovpadanja = 0;
    }

    int h(int k, int i){
        if (i == 0)
            return (k * this.p) % this.m;
        return (h(k, 0) + this.c1 * i + this.c2 * (i*i)) % this.m;
    }

    void insert(int key){
        int indeks = this.h(key, 0);
        int count = 0;
        boolean najden = true;
        while (m != 0 && this.tabela[indeks] != null && this.tabela[indeks] != key) {
            if (count == this.m){
                najden = false;
                break;
            }
            this.sovpadanja++;
            indeks = this.h(key, ++count);
        }
        if (!najden)
            resize(key);
        else
            this.tabela[indeks] = key;
    }

    void resize(int key){
        Integer[] tmp = this.tabela;
        this.m = 2 * this.m + 1;
        this.tabela = new Integer[this.m];
        for (Integer i:tmp){
            if (i != null)
                this.insert(i);
        }
        this.insert(key);
    }

    boolean find(int key){
        int indeks = this.findInd(key);
        return indeks >= 0;
    }

    int findInd(int key){
        if (m == 0)
            return -1;
        int indeks = this.h(key, 0);
        int count = 0;
        boolean najden = true;
        while (this.tabela[indeks] == null || this.tabela[indeks] != key){
            if (count == this.m)
                return -1;
            indeks = this.h(key, ++count);
        }
        return indeks;
    }

    void delete(int key){
        int indeks = this.findInd(key);
        if (indeks >= 0)
            this.tabela[indeks] = null;
    }

    void printKeys(){
        for(int i = 0; i < this.m; i++){
            if (this.tabela[i] != null)
                System.out.println(i + ": " + this.tabela[i].toString());
        }
    }

    void printCollisions(){
        System.out.println(this.sovpadanja);
    }
}