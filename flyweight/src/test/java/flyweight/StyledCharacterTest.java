package flyweight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class StyledCharacterTest {

    @Test
    void keepsReferenceToCharAndStyle() {
        CharacterStyle style = new CharacterStyle(Font.VERDANA, TextColor.BLACK, 16);
        StyledCharacter styled = new StyledCharacter('o', style);

        assertEquals('o', styled.getCharacter());
        assertSame(style, styled.getStyle());
    }

    @Test
    void describePrintsCharWithStyleTuple() {
        CharacterStyle style = new CharacterStyle(Font.ARIAL, TextColor.RED, 12);
        StyledCharacter styled = new StyledCharacter('H', style);

        assertEquals("H -> Arial, Red, 12pt", styled.describe());
    }
}
