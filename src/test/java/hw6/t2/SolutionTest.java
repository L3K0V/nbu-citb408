package hw6.t2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void parseTextToSentences() {
        final String text = "Somewhat unexpectedly, when you create a String object, you are creating a string that cannot be changed. That is, once a String object has been created, you cannot change the characters that comprise that string. At first, this may seem to be a serious restriction. However, such is not the case. For example, what if you want to assign an int value to a byte variable? This conversion will not be performed automatically, because a byte is smaller than an int.";
        assertEquals(6,text.split("([.!?])").length);
    }

    @Test
    public void getSentenceFirstWord() {
        final String text = " That is, once a String object has been created, you cannot change the characters that comprise that string.".trim();
        assertEquals("That", Arrays.stream(text.split("([^\\w\\'\\-])")).findFirst().orElse(""));
    }

    @Test
    public void sample0() {
        final String text = "Somewhat unexpectedly, when you create a String object, you are creating a string that cannot be changed. That is, once a String object has been created, you cannot change the characters that comprise that string. At first, this may seem to be a serious restriction. However, such is not the case. For example, what if you want to assign an int value to a byte variable? This conversion will not be performed automatically, because a byte is smaller than an int.";
        assertEquals("SOMEWHAT_THAT_AT_HOWEVER_FOR_THIS", Result.firstWords(text));
    }
}
