package util;

import java.util.ArrayList;
public class CustomStack<E> extends ArrayList<E>{
    public E pop() {
        E e = get(size() - 1);
        remove(size() - 1);
        return e;
    }

    public void push(E e) {
        add(e);
    }

    public E top(){
        return get(size() - 1);
    }
}
