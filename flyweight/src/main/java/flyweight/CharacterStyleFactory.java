package flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterStyleFactory {
    private static final CharacterStyleFactory INSTANCE = new CharacterStyleFactory();

    private static final Font[] FONTS = {Font.ARIAL, Font.CALIBRI, Font.VERDANA};
    private static final TextColor[] COLORS = {TextColor.RED, TextColor.BLUE, TextColor.BLACK};
    private static final int[] SIZES = {12, 14, 16};

    private final Map<String, CharacterStyle> pool = new HashMap<>();

    private CharacterStyleFactory() {
    }

    public static CharacterStyleFactory getInstance() {
        return INSTANCE;
    }

    public CharacterStyle getStyle(int fontIndex, int colorIndex, int sizeIndex) {
        Font font = FONTS[requireIndex(fontIndex, FONTS.length)];
        TextColor color = COLORS[requireIndex(colorIndex, COLORS.length)];
        int size = SIZES[requireIndex(sizeIndex, SIZES.length)];
        String key = font.name() + "-" + color.name() + "-" + size;
        return pool.computeIfAbsent(key, k -> new CharacterStyle(font, color, size));
    }

    private int requireIndex(int index, int length) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException("Index out of range: " + index);
        }
        return index;
    }
}
