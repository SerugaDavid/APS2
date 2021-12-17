package APS2.podatkovneStruktureVaja;

public class Seznam {
    private Element head;
    private Seznam tail;

    public Seznam(Element head, Seznam tail){
        this.head = head;
        this.tail = tail;
    }

    public void insert(Element elt) {
        this.tail = new Seznam(this.head, this.tail);
        this.head = elt;
    }

    public Object find(Object key){
        if (this.head.getKey() == key)
            return this.head.getValue();
        if (this.tail != null)
            return this.tail.find(key);
        return null;
    }

    public void delete(Object key){
        if (this.tail != null && this.tail.getHead() == null) {
            if (this.head.getKey() == key) {
                this.head = this.tail.getHead();
                this.tail = this.tail.getTail();
            } else
                this.tail.delete(key);
        }
        if (this.head.getKey() == key){
            this.head = null;
        }
    }

    public int length(){
        if (this.head == null)
            return 0;
        if (this.tail == null)
            return 1;
        return 1 + this.tail.length();
    }

    public Seznam getTail() {
        return tail;
    }

    public Element getHead() {
        return head;
    }
}
