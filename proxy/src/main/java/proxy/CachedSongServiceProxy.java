package proxy;

import java.util.List;

public class CachedSongServiceProxy implements SongService {
    @Override
    public Song searchById(Integer songID) {
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return null;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        return null;
    }
}
