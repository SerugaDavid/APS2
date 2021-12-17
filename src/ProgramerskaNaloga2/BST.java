package APS2.ProgramerskaNaloga2;

public class BST {
    class Node {
        public Node levi, desni, stars;
        public int key, value;

        public Node (Node levi, Node desni, Node stars, int key, int value) {
            this.levi = levi;
            this.desni = desni;
            this.stars = stars;
            this.key = key;
            this.value = value;
        }
    }

    public Node koren;
    private boolean zamenjava;
    private int primerjave;

    public BST() {
        this.koren = null;
        this.zamenjava = false;
        this.primerjave = 0;
    }


    void insert(int key) {
        Node tmp = this.koren;
        if (tmp == null){
            this.koren = new Node(null, null, null, key, 1);
            return;
        }
        while (true){
            this.primerjave++;
            if (tmp.key == key){
                tmp.value++;
                return;
            }
            if (key < tmp.key) {
                if (tmp.levi == null){
                    tmp.levi = new Node(null, null, tmp, key, 1);
                    return;
                }
                tmp = tmp.levi;
            }
            else {
                if (tmp.desni == null){
                    tmp.desni = new Node(null, null, tmp, key, 1);
                    return;
                }
                tmp = tmp.desni;
            }
        }
    }

    boolean find(int key) {
        Node tmp = this.koren;
        while (true){
            if (tmp == null)
                return false;
            this.primerjave++;
            if (tmp.key == key)
                return true;
            if (key < tmp.key)
                tmp = tmp.levi;
            else
                tmp = tmp.desni;
        }
    }

    void delete(int key) {
        Node tmp = this.koren;
        boolean najden = false;
        boolean desni = false;
        while (true){
            if (tmp == null)
                break;
            this.primerjave++;
            if (tmp.key == key){
                najden = true;
                break;
            }
            if (key < tmp.key) {
                tmp = tmp.levi;
                desni = false;
            }
            else {
                tmp = tmp.desni;
                desni = true;
            }
        }
        if (!najden)
            return;
        if (tmp.value > 1){
            tmp.value--;
            return;
        }
        boolean[] ot = otroci(tmp);
        if (!(ot[0] || ot[1])){
            if (tmp.stars == null){
                this.koren = null;
                return;
            }
            if (desni)
                tmp.stars.desni = null;
            else
                tmp.stars.levi = null;
            return;
        }
        if (ot[0] && ot[1]){
            Node replacement;
            if (this.zamenjava){
                this.zamenjava = false;
                replacement = tmp.desni;
                if (replacement.levi == null){
                    replacement.levi = tmp.levi;
                    replacement.stars = tmp.stars;
                    if (tmp.stars == null){
                        this.koren = replacement;
                        return;
                    }
                    if (desni)
                        tmp.stars.desni = replacement;
                    else
                        tmp.stars.levi = replacement;
                    return;
                }
                while (replacement.levi != null)
                    replacement = replacement.levi;
                replacement.stars.levi = replacement.desni;
                if (replacement.desni != null)
                    replacement.desni.stars = replacement.stars;
                replacement.levi = tmp.levi;
                replacement.desni = tmp.desni;
            }
            else {
                this.zamenjava = true;
                replacement = tmp.levi;
                if (replacement.desni == null){
                    replacement.desni = tmp.desni;
                    replacement.stars = tmp.stars;
                    if (tmp.stars == null){
                        this.koren = replacement;
                        return;
                    }
                    if (desni)
                        tmp.stars.desni = replacement;
                    else
                        tmp.stars.levi = replacement;
                    return;
                }
                while (replacement.desni != null)
                    replacement = replacement.desni;
                replacement.stars.desni = replacement.levi;
                if (replacement.levi != null)
                    replacement.levi.stars = replacement.stars;
                replacement.desni = tmp.desni;
                replacement.levi = tmp.levi;
            }
            replacement.stars = tmp.stars;
            if (tmp.stars == null){
                this.koren = replacement;
                return;
            }
            if (desni)
                tmp.stars.desni = replacement;
            else
                tmp.stars.levi = replacement;

        }
        else {
            if (ot[0]){
                tmp.levi.stars = tmp.stars;
                if (tmp.stars == null){
                    this.koren = tmp.levi;
                    return;
                }
                if (desni)
                    tmp.stars.desni = tmp.levi;
                else
                    tmp.stars.levi = tmp.levi;
            }
            else {
                tmp.desni.stars = tmp.stars;
                if (tmp.stars == null){
                    this.koren = tmp.desni;
                    return;
                }
                if (desni)
                    tmp.stars.desni = tmp.desni;
                else
                    tmp.stars.levi = tmp.desni;
            }
        }
    }

    boolean[] otroci(Node node){
        boolean[] ot = new boolean[2];
        ot[0] = node.levi != null;
        ot[1] = node.desni != null;
        return ot;
    }

    void printInorder() {
        pIn(this.koren);
    }

    void pIn(Node node){
        if (node == null)
            return;
        pIn(node.levi);
        System.out.println(node.key);
        pIn(node.desni);
    }

    void printPreorder() {
        pPre(this.koren);
    }

    void pPre(Node node){
        if (node == null)
            return;
        System.out.println(node.key);
        pPre(node.levi);
        pPre(node.desni);
    }

    void printPostorder() {
        pPost(this.koren);
    }

    void pPost(Node node){
        if (node == null)
            return;
        pPost(node.levi);
        pPost(node.desni);
        System.out.println(node.key);
    }

    void printNodeComparisons() {
        System.out.println(this.primerjave);
    }

}
