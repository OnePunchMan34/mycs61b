public class ArrayDequeTest {
    public static void main(String[] args){
        ArrayDeque<Integer> t = new ArrayDeque();
        t.addFirst(0);
        t.removeLast();     
        t.addFirst(2);
        t.removeFirst();    
        t.addFirst(4);
        t.removeLast() ;    
        t.addLast(6);
        t.addLast(7);
        t.addFirst(8);
        t.addLast(9);
        t.get(3);      
        t.addLast(11);
        t.addLast(12);
        t.addFirst(13);
        t.removeFirst();    
        t.addLast(15);
        t.get(2);
        t.addLast(17);
        t.removeLast();     
        t.removeLast();   
        t.removeFirst(); 
    }
}
