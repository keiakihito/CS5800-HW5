package flyweight;

// The StyledCharacter class is a flyweight class.
// It means that this class is reuseable object (intrinsic state) to avoid duplicatoin.
// Once the object is created, it is cached in the CharacterStyleFactory with hashmap.
public class StyledCharacter {
    private final char _character;
    private final CharacterStyle _style;

    public StyledCharacter(char character, CharacterStyle style) {
        _character = character;
        _style = style;
    }

    public char getCharacter() {
        return _character;
    }

    public CharacterStyle getStyle() {
        return _style;
    }

    public String describe() {
        return _character + " -> " + _style.describe();
    }
}
