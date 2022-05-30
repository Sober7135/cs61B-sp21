package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private final Comparator<T> c;

    public MaxArrayDeque(Comparator<T> c) {
        this.c = c;
    }

    public T max() {
        return max(c);
    }

    public T max(Comparator<T> cpt) {
        if (this.isEmpty()) {
            return null;
        }

        T returnItem = this.get(0);
        for (int i = 0; i < this.size(); i++) {
            T t = this.get(i);
            if (cpt.compare(t, returnItem) > 0) {
                returnItem = t;
            }
        }

        return returnItem;
    }
}
