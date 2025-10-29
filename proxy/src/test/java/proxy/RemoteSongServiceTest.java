package proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RemoteSongServiceTest {

    private Song song1;
    private Song song2;
    private Song song3;
    private RemoteSongService service;

    @BeforeEach
    void setUp() {
        song1 = new Song(1, "Africa", "Toto", "Toto IV", 295);
        song2 = new Song(2, "Birdland", "Weather Report", "Heavy Weather", 204);
        song3 = new Song(3, "Chicken", "Weather Report", "Live at Montreux", 187);
        service = new RemoteSongService(List.of(song1, song2, song3));
    }

    @Test
    void searchByIdReturnsSongAfterDelay() {
        long start = System.nanoTime();
        Song result = service.searchById(1);
        long elapsedMillis = Duration.ofNanos(System.nanoTime() - start).toMillis();

        assertTrue(elapsedMillis >= 1000, "expected artificial delay of at least 1 second");
        assertEquals(song1, result);
    }

    @Test
    void searchByIdReturnsNullWhenMissing() {
        assertNull(service.searchById(99));
    }

    @Test
    void searchByTitleReturnsMatchingSongsIgnoringCase() {
        List<Song> result = service.searchByTitle("Birdland");

        assertEquals(List.of(song2), result);
    }

    @Test
    void searchByAlbumReturnsAllSongsInAlbum() {
        List<Song> result = service.searchByAlbum("Heavy Weather");

        assertEquals(List.of(song2), result);
    }
}
