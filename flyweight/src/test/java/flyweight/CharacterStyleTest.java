package flyweight;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CharacterStyleTest {

    @Test
    void storesIntrinsicState() {
        CharacterStyle style = new CharacterStyle(Font.CALIBRI, TextColor.BLUE, 14);

        assertAll(
                () -> assertEquals(Font.CALIBRI, style.getFont()),
                () -> assertEquals(TextColor.BLUE, style.getColor()),
                () -> assertEquals(14, style.getSize()));
    }

    @Test
    void describeReturnsReadableTuple() {
        CharacterStyle style = new CharacterStyle(Font.ARIAL, TextColor.RED, 12);

        assertEquals("Arial, Red, 12pt", style.describe());
    }
}
