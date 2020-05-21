public class LinkedListDeque<T> {
    private class node {
        /**Your class should accept any generic type (not just integers).*/
        public T item;
        public node prev;
        public node next;

        public node(T i, node p, node n){
            item = i;
            prev = p;
            next = n;
        }
    }

    private node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new node(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item){
        node head = sentinel.next;
        sentinel.next = new node(item,sentinel,head);
        if (head != null){
            head.prev = sentinel.next;
        }else{
            sentinel.prev = sentinel.next;
            sentinel.next.next = sentinel;
        }
        size += 1;
    }

    public void addLast(T item){
        node tail = sentinel.prev;
        sentinel.prev = new node(item,tail,sentinel);
        if (tail!=null){
            tail.next = sentinel.prev;
        }else{
            sentinel.next = sentinel.prev;
            sentinel.prev.prev = sentinel;
        }
        size += 1;
    }

    public boolean isEmpty(){
        return sentinel.next == sentinel;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        node scan = sentinel.next;
        while (scan != sentinel){
            System.out.print(scan.item + " ");
            scan = scan.next;
        }
    }

    public T removeFirst(){
        node head = sentinel.next;
        if (head == sentinel){
            return null;
        }else{
            sentinel.next = head.next;
            if (head.next != sentinel){
                sentinel = head.next.prev;
            }else{
                sentinel.prev = sentinel;
            }
            head.prev = null;
            head.next = null;
        }
        size -= 1;
        return head.item;
    }

    public T removeLast(){
        node tail = sentinel.prev;
        if (tail == sentinel){
            return null;
        }else{
            sentinel.prev = tail.prev;
            if (tail.next != sentinel){
                sentinel = tail.prev.next;
            }else{
                sentinel.next = sentinel;
            }
            tail.prev = null;
            tail.next = null;
        }
        return tail.item;
    }

    public T get(int index){
        node scan = sentinel;
        if (index < 0){
            return null;
        }else{
            while (index >= 0){
                if (scan.next == null){
                    return null;
                }else{
                    scan = scan.next;
                    index -= 1;
                }
            }
            return scan.item;
        }
    }

}
