package flyweight;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class CharacterStyleFactoryTest {

    @Test
    void returnsSameInstanceForSameIndexes() {
        CharacterStyleFactory factory = CharacterStyleFactory.getInstance();

        CharacterStyle first = factory.getStyle(0, 0, 0);
        CharacterStyle second = factory.getStyle(0, 0, 0);

        assertSame(first, second);
    }

    @Test
    void mapsIndexesToExpectedValues() {
        CharacterStyleFactory factory = CharacterStyleFactory.getInstance();

        CharacterStyle style = factory.getStyle(1, 2, 0);

        // Font index 1 -> Calibri
        // Color index 2 -> Black
        // Size index 0 -> 12
        assertSame(Font.CALIBRI, style.getFont());
        assertSame(TextColor.BLACK, style.getColor());
        assertSame(12, style.getSize());
    }
}
