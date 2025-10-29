package proxy;

import java.util.List;

public class CachedSongServiceProxy implements SongService {

    private final SongService delegate;

    public CachedSongServiceProxy(SongService delegate) {
        this.delegate = delegate;
    }

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
