public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 3;
        nextLast = 4;
        size = 0;
    }

    private int onePlus(int index) {
        return ((index == items.length - 1) ? 0 : index + 1);
    }

    private int oneMinus(int index) {
        return ((index == 0) ? items.length - 1 : index - 1);
    }

    private void expand() {
        T[] a = (T[]) new Object[4 * size];
        System.arraycopy(items, 0, a, 0, nextLast);
        if (nextFirst < items.length - 1) {
            System.arraycopy(items, nextFirst + 1, a, nextLast + 3 * size, size - nextLast);
        }
        nextFirst = nextLast + 3 * size - 1;
        items = a;
        //nextLast = nextLast;
    }

    public void addFirst(T x) {
        if (nextFirst == nextLast) {
            expand();
        }
        items[nextFirst] = x;
        nextFirst = oneMinus(nextFirst);
        size += 1;
    }

    public void addLast(T x) {
        if (nextFirst == nextLast) {
            expand();
        }
        items[nextLast] = x;
        nextLast = onePlus(nextLast);
        size += 1;
    }

    private void shrink() {
        T[] a = (T[]) new Object[size + 2];
        if (nextFirst < nextLast) {
            System.arraycopy(items, nextFirst + 1, a, 1, size);
            items = a;
            nextFirst = 0;
            nextLast = size + 1;
        } else {
            //nextLast = nextLast;
            System.arraycopy(items, 0, a, 0, nextLast);
            System.arraycopy(items, onePlus(nextFirst), a, nextLast + 2, size - nextLast);
            items = a;
            nextFirst = nextLast + 1;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = onePlus(nextFirst);
        T tmp = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        double usage = ((double) size) / items.length;
        if ((items.length > 16) && (usage < 0.25)) {
            shrink();
        }
        return tmp;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = oneMinus(nextLast);
        T tmp = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        double usage = ((double) size) / items.length;
        if ((items.length > 16) && (usage < 0.25)) {
            shrink();
        }
        return tmp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int currentIndex = onePlus(nextFirst);
        while ((items[currentIndex] != null) && (currentIndex != nextLast)) {
            System.out.print(items[currentIndex] + " ");
            currentIndex = onePlus(currentIndex);
        }
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int pos;
        pos = nextFirst + index + 1;
        if (nextFirst >= nextLast) {
            if (pos > items.length - 1) {
                pos -= items.length;
            }
        }
        return items[pos];
    }
}


