import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        char x1 = 'a';
        char y1 = 'b';

        char x2 = 'a';
        char y2 = 'c';

        char x3 = 'a';
        char y3 = 'B';

        char x4 = '%';
        char y4 = '&';

        assertTrue(offByOne.equalChars(x1, y1));
        assertFalse(offByOne.equalChars(x2, y2));
        assertFalse(offByOne.equalChars(x3, y3));
        assertTrue(offByOne.equalChars(x4, y4));

    }
}
