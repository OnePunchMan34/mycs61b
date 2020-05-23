import static org.junit.Assert.*;
import org.junit.Test;

public class FilkTest {
    @Test
    public void testisSameNumber() {
        Flik c1 = new Flik();
        int a1 = 128;
        int b1 = 128;
        boolean expected1 = true;

        Flik c2 = new Flik();
        int a2 = 4;
        int b2 = 6;
        boolean expected2 = false;

        assertTrue(c1.isSameNumber(a1,b1));
        assertFalse(c2.isSameNumber(a2,b2));

    }
}
