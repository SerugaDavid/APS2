package APS2.ProgramerskaNaloga1;

public class Seznam {
    public Elt elt;
    public Seznam rep;
    public static int primerjave = 0;

    public Seznam(Elt elt, Seznam rep){
        this.elt = elt;
        this.rep = rep;
    }
    static Seznam insert(Seznam s, Elt e){
        if (e == null)
            return new Seznam(null, s);
        Elt tmp = find(s, e.key);
        if (tmp == null)
            return new Seznam(e, s);
        tmp.data = e.data;
        return s;
    }
    static Elt find(Seznam s, int key){
        if (s == null)
            return null;
        primerjave++;
        if (s.elt != null && s.elt.key == key)
            return s.elt;
        return find(s.rep, key);
    }
    static Seznam delete(Seznam s, int key){
        if (s == null)
            return null;
        primerjave++;
        if (s.elt != null && s.elt.key == key)
            return s.rep;
        return new Seznam(s.elt, delete(s.rep, key));
    }
    static void printElementKeys(Seznam s){
        while (s != null){
            System.out.println(s.elt);
            s = s.rep;
        }
    }
    static void printElementKeyComparisons(Seznam s){
        if (s != null)
            System.out.println(primerjave);
    }
}
