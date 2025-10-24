package flyweight;

public class CharacterStyle {
    private final Font _font;
    private final TextColor _color;
    private final int _size;

    public CharacterStyle(Font font, TextColor color, int size) {
        _font = font;
        _color = color;
        _size = size;
    }

    public Font getFont() {
        return _font;
    }

    public TextColor getColor() {
        return _color;
    }

    public int getSize() {
        return _size;
    }

    public String describe() {
        return String.format("%s, %s, %dpt", capitalize(_font), capitalize(_color), _size);
    }

    private String capitalize(Enum<?> value) {
        String lower = value.name().toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }
}
