public class LinkedListDeque<T> {
    private class Node {
        /**Your class should accept any generic type (not just integers).*/
        private T item;
        private Node prev;
        private Node next;

        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node tmp = sentinel.next;
        sentinel.next = new Node(item, sentinel, tmp);
        tmp.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        Node tmp = sentinel.prev;
        sentinel.prev = new Node(item, tmp, sentinel);
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
        Node current  = sentinel.next;
        while (current != sentinel) {
            System.out.print(current.item + " ");
            current = current.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node tmp = sentinel.next;
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
        Node tmp = sentinel.prev;
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
        Node current = sentinel;
        while (index >= 0) {
            current = current.next;
            index -= 1;
        }
        return current.item;
    }

    private T getRecursiveHelper(int index, Node current) {
        if (index < 0) {
            return current.item;
        }
        return getRecursiveHelper(index - 1, current.next);
    }

    public T getRecursive(int index) {
        if ((index + 1 > size) || (index < 0)) {
            return null;
        }
        return getRecursiveHelper(index, sentinel);
    }

}
