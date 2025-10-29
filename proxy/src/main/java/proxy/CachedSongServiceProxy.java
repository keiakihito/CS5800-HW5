package proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// We mock the cached web service like spotify or apple music. 
// The CachedSongServiceProxy class is a proxy class that caches the results of the SongService.
// While accesing the real song sercice caude delays, the cached web service will return the results from the cache.
public class CachedSongServiceProxy implements SongService {

    private final SongService _delegate;
    private final Map<Integer, Song> _idCache = new HashMap<>();
    private final Map<String, List<Song>> _titleCache = new HashMap<>();
    private final Map<String, List<Song>> _albumCache = new HashMap<>();

    public CachedSongServiceProxy(SongService delegate) {
        this._delegate = delegate;
    }

    @Override
    public Song searchById(Integer songID) {
        if (_idCache.containsKey(songID)) {
            return _idCache.get(songID);
        }
        Song result = _delegate.searchById(songID);
        _idCache.put(songID, result);
        return result;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (_titleCache.containsKey(title)) {
            return _titleCache.get(title);
        }
        List<Song> result = _delegate.searchByTitle(title);
        _titleCache.put(title, result);
        return result;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (_albumCache.containsKey(album)) {
            return _albumCache.get(album);
        }
        List<Song> result = _delegate.searchByAlbum(album);
        _albumCache.put(album, result);
        return result;
    }
}
