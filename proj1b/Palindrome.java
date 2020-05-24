public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        if (word == null) {
            return null;
        }
        Deque<Character> wordDeque = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i += 1) {
            char c = word.charAt(i);
            wordDeque.addLast(c);
        }
        return wordDeque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> wDeque = wordToDeque(word);
        if (wDeque == null){
            return true;
        }
        while (wDeque.size() > 1) {
            char first = wDeque.removeFirst();
            char last = wDeque.removeLast();
            if (first != last) {
                return false;
            }
        }
        return true;

    }

    public boolean isPalindrome( String word, CharacterComparator cc) {
        Deque<Character> wDeque = wordToDeque(word);
        if (wDeque == null) {
            return true;
        }
        while (wDeque.size() > 1) {
            char first = wDeque.removeFirst();
            char last = wDeque.removeLast();
            if (!cc.equalChars(first, last)) {
                return false;
            }
        }
        return true;
    }



}
