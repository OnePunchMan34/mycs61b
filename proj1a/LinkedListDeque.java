public class LinkedListDeque<T> {
    private class node {
        /**Your class should accept any generic type (not just integers).*/
        public T item;
        public node prev;
        public node next;

        public node(T i, node p, node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new node(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        node tmp = sentinel.next;
        sentinel.next = new node(item, sentinel, tmp);
        tmp.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        node tmp = sentinel.prev;
        sentinel.prev = new node(item, tmp, sentinel);
        tmp.next = sentinel.prev;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        node current  = sentinel.next;
        while (current != sentinel) {
            System.out.print(current.item + " ");
            current = current.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        node tmp = sentinel.next;
        sentinel.next = tmp.next;
        tmp.next.prev = sentinel;
        tmp.next = null;
        tmp.prev = null;
        size -= 1;
        return tmp.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        node tmp = sentinel.prev;
        sentinel.prev = tmp.prev;
        tmp.prev.next = sentinel;
        tmp.next = null;
        tmp.prev = null;
        size -= 1;
        return tmp.item;
    }

    public T get(int index) {
        if ((index + 1 > size) || (index < 0)) {
            return null;
        }
        node current = sentinel;
        while (index >= 0){
            current = current.next;
            index -= 1;
        }
        return current.item;
    }

    public T getRecursiveHelper(int index, node current) {
        if (index < 0) {
            return current.item;
        }
        return getRecursiveHelper(index-1, current.next);
    }

    public T getRecursive(int index) {
        if ((index + 1 > size) || (index < 0)) {
            return null;
        }
        return getRecursiveHelper(index, sentinel);
    }

}
