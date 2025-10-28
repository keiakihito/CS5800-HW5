package proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class SongTest {

    @Test
    void storesProvidedMetadata() {
        Song song = new Song(1, "Africa", "Toto", "Toto IV", 295);

        assertEquals(1, song.getId());
        assertEquals("Africa", song.getTitle());
        assertEquals("Toto", song.getArtist());
        assertEquals("Toto IV", song.getAlbum());
        assertEquals(295, song.getDuration());
    }

    @Test
    void equalityBasedOnAllFields() {
        Song song1 = new Song(2, "Birdland", "Weather Report", "Heavy Weather", 204);
        Song song2 = new Song(2, "Birdland", "Weather Report", "Heavy Weather", 204);
        Song different = new Song(3, "Chicken", "Weather Report", "Live at Montreux", 187);

        assertEquals(song1, song2);
        assertEquals(song1.hashCode(), song2.hashCode());
        assertNotEquals(song1, different);
    }
}
