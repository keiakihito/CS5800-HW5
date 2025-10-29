package proxy;

import java.util.Collections;
import java.util.List;

public class RemoteSongService implements SongService {

    private final List<Song> songs;

    public RemoteSongService(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public Song searchById(Integer songID) {
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return Collections.emptyList();
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        return Collections.emptyList();
    }
}
