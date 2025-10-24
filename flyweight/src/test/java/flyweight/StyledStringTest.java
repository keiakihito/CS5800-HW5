package flyweight;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StyledStringTest {

    private StyledString styledString;
    private CharacterStyleFactory factory;

    @BeforeEach
    void setUp() {
        styledString = new StyledString();
        factory = CharacterStyleFactory.getInstance();
    }

    @Test
    void appendAddsCharactersWithStyles() {
        styledString.append('H', 0, 0, 0);
        styledString.append('i', 1, 1, 1);

        assertEquals(2, styledString.size());
        assertEquals("H -> Arial, Red, 12pt", styledString.printStyles().get(0));
        assertEquals("i -> Calibri, Blue, 14pt", styledString.printStyles().get(1));
    }

    @Test
    void reusesSameStyleInstancesViaFactory() {
        CharacterStyle first = factory.getStyle(0, 0, 0);
        styledString.append('o', 0, 0, 0);
        styledString.append('o', 0, 0, 0);

        assertEquals(first, styledString.getStyledCharacter(0).getStyle());
        assertEquals(first, styledString.getStyledCharacter(1).getStyle());
    }
}
