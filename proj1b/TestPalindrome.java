import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        String word1 = "";
        String word2 = " ";
        String word3 = "a";
        String word4 = "ab";
        String word5 = "aba";
        String word6 = "abba";
        String word7 = "abcba";
        String word8 = "abdbb";

        assertTrue(palindrome.isPalindrome(word1));
        assertTrue(palindrome.isPalindrome(word2));
        assertTrue(palindrome.isPalindrome(word3));
        assertFalse(palindrome.isPalindrome(word4));
        assertTrue(palindrome.isPalindrome(word5));
        assertTrue(palindrome.isPalindrome(word6));
        assertTrue(palindrome.isPalindrome(word7));
        assertFalse(palindrome.isPalindrome(word8));

    }

    @Test
    public void testisPalindrome2() {
        String word1 = "";
        String word2 = " ";
        String word3 = "a";
        String word4 = "ab";
        String word5 = "aba";
        String word6 = "abba";
        String word7 = "abcba";
        String word8 = "abdab";
        CharacterComparator cc1 = new OffByOne();
        CharacterComparator cc2 = new OffByOne();
        CharacterComparator cc3 = new OffByOne();
        CharacterComparator cc4 = new OffByOne();
        CharacterComparator cc5 = new OffByOne();
        CharacterComparator cc6 = new OffByOne();
        CharacterComparator cc7 = new OffByOne();
        CharacterComparator cc8 = new OffByOne();

        assertTrue(palindrome.isPalindrome(word1, cc1));
        assertTrue(palindrome.isPalindrome(word2, cc2));
        assertTrue(palindrome.isPalindrome(word3, cc3));
        assertTrue(palindrome.isPalindrome(word4, cc4));
        assertFalse(palindrome.isPalindrome(word5, cc5));
        assertFalse(palindrome.isPalindrome(word6, cc6));
        assertFalse(palindrome.isPalindrome(word7, cc7));
        assertTrue(palindrome.isPalindrome(word8, cc8));

    }
}
