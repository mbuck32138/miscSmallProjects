import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne obo = new OffByOne();


    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("abcdefgfedcba"));
        assertFalse(palindrome.isPalindrome("Racecar"));
        assertFalse(palindrome.isPalindrome("racecaR"));
        assertFalse(palindrome.isPalindrome("kl;aht;ahatijjt'ajlag[o'ag'lag'j"));
    }

    @Test
    public void testOboIsPalindrome() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertTrue(palindrome.isPalindrome("%*0M~3z2}N1+&", cc));
        assertFalse(palindrome.isPalindrome("Racecar", cc));
        assertFalse(palindrome.isPalindrome("racecaR", cc));
        assertFalse(palindrome.isPalindrome("kl;aht;ag'lag'j", cc));
    }

}
