package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> c;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.c = c;
    }

    public T max() {
        return max(c);
    }

    private T max(Comparator<T> cpt) {
        if (isEmpty()) {
            return null;
        }

        T returnItem = get(0);
        for (int i = 0; i < size(); i++) {
            T t = get(i);
            if (cpt.compare(t, returnItem) > 0) {
                returnItem = t;
            }
        }

        return returnItem;
    }
}
