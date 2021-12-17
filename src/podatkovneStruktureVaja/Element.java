package APS2.podatkovneStruktureVaja;

public class Element {
    private Object key;
    private Object value;

    public Element(Object key, Object value){
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
