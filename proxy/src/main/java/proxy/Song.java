package proxy;

import java.util.Objects;

public class Song {
    private final Integer _id;
    private final String _title;
    private final String _artist;
    private final String _album;
    private final int _duration;

    public Song(Integer id, String title, String artist, String album, int duration) {
        this._id = id;
        this._title = title;
        this._artist = artist;
        this._album = album;
        this._duration = duration;
    }

    public Integer getId() {
        return _id;
    }

    public String getTitle() {
        return _title;
    }

    public String getArtist() {
        return _artist;
    }

    public String getAlbum() {
        return _album;
    }

    public int getDuration() {
        return _duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Song)) {
            return false;
        }
        Song song = (Song) o;
        return _duration == song._duration
                && Objects.equals(_id, song._id)
                && Objects.equals(_title, song._title)
                && Objects.equals(_artist, song._artist)
                && Objects.equals(_album, song._album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _title, _artist, _album, _duration);
    }

    @Override
    public String toString() {
        return "Song{"
                + "_id=" + _id
                + ", _title='" + _title + '\''
                + ", _artist='" + _artist + '\''
                + ", _album='" + _album + '\''
                + ", _duration=" + _duration
                + '}';
    }
}
