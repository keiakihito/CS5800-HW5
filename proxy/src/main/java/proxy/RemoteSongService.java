package proxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// We mock the remote song service like spotify or apple music. 
// The RemoteSongService class is a real subject class that implements the SongService interface.
// When the CachedSongServiceProxy class could not find the results in the cache, 
// it will delegate the call to the RemoteSongService to get the results with Proxy Pattern.
public class RemoteSongService implements SongService {

    private final List<Song> _songs;

    public RemoteSongService(List<Song> songs) {
        // When the class is given a null list, it will be converted to an empty list as a special object
        // The idea comes from clean code by Uncle Bob 
        this._songs = songs == null ? Collections.emptyList() : new ArrayList<>(songs);
    }

    @Override
    public Song searchById(Integer songID) {
        delay();
        if (songID == null) {
            return null;
        }
        for (Song song : _songs) {
            if (Objects.equals(song.getId(), songID)) {
                return song;
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        delay();
        if (title == null || title.isEmpty()) {
            // Same concept from the constructor initialization.
            return Collections.emptyList();
        }
        String query = title.toLowerCase();
        List<Song> results = new ArrayList<>();
        for (Song song : _songs) {
            if (song.getTitle().toLowerCase().contains(query)) {
                results.add(song);
            }
        }
        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        delay();
        if (album == null || album.isEmpty()) {
            // Same concept from the constructor initialization.
            return Collections.emptyList();
        }
        String query = album.toLowerCase();
        List<Song> results = new ArrayList<>();
        for (Song song : _songs) {
            if (song.getAlbum().toLowerCase().contains(query)) {
                results.add(song);
            }
        }
        return results;
    }

    private void delay() {
        try {
            Thread.sleep(1000);
            System.out.print("... delay for 1 second ... : ");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
