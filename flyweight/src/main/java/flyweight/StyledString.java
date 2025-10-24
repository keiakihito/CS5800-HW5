package flyweight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StyledString {
    private final List<StyledCharacter> glyphs = new ArrayList<>();
    private final CharacterStyleFactory factory = CharacterStyleFactory.getInstance();

    public void append(char character, int fontIndex, int colorIndex, int sizeIndex) {
        CharacterStyle style = factory.getStyle(fontIndex, colorIndex, sizeIndex);
        glyphs.add(new StyledCharacter(character, style));
    }

    public int size() {
        return glyphs.size();
    }

    public StyledCharacter getStyledCharacter(int index) {
        return glyphs.get(index);
    }

    public List<String> printStyles() {
        List<String> result = new ArrayList<>();
        for (StyledCharacter glyph : glyphs) {
            result.add(glyph.describe());
        }
        return Collections.unmodifiableList(result);
    }
}
