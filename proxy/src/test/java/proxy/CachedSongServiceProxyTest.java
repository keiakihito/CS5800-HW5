package proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class CachedSongServiceProxyTest {

    private static class CountingSongService implements SongService {
        int byIdCalls = 0;
        int byTitleCalls = 0;
        int byAlbumCalls = 0;

        @Override
        public Song searchById(Integer songID) {
            byIdCalls++;
            return new Song(1, "Africa", "Toto", "Toto IV", 100);
        }

        @Override
        public List<Song> searchByTitle(String title) {
            byTitleCalls++;
            return List.of(new Song(2, "Birdland", "Weather Report", "Heavy Weather", 120));
        }

        @Override
        public List<Song> searchByAlbum(String album) {
            byAlbumCalls++;
            return List.of(new Song(3, "Chicken", "Weather Report", "Live at Montreux", 150));
        }
    }

    @Test
    void cachesResultsToAvoidRepeatedDelegateCalls() {
        CountingSongService real = new CountingSongService();
        CachedSongServiceProxy proxy = new CachedSongServiceProxy(real);

        proxy.searchById(1);
        proxy.searchById(1);
        assertEquals(1, real.byIdCalls);

        proxy.searchByTitle("Birdland");
        proxy.searchByTitle("Birdland");
        assertEquals(1, real.byTitleCalls);

        proxy.searchByAlbum("Heavy Weather");
        proxy.searchByAlbum("Heavy Weather");
        assertEquals(1, real.byAlbumCalls);
    }
}
