import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> arrayList;

    public Stack() {
        arrayList = new ArrayList<>();
    }

    public void push(T elem) {
        arrayList.add(elem);
    }

    public void pop() {
        arrayList.remove(arrayList.size() - 1);
    }

    public T top() {
        return arrayList.get(arrayList.size() - 1);
    }
}
