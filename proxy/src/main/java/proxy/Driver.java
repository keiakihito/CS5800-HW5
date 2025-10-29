package proxy;

import java.util.List;

public class Driver {

    public static void main(String[] args) {
        List<Song> catalog = List.of(
                new Song(1, "Africa", "Toto", "Toto IV", 295),
                new Song(2, "Birdland", "Weather Report", "Heavy Weather", 360),
                new Song(3, "Chicken", "Weather Report", "Live at Montreux", 420),
                new Song(4, "Hello", "Adele", "25", 295),
                new Song(5, "Believer", "Imagine Dragons", "Evolve", 204),
                new Song(6, "On Fire", "Switchfoot", "The Beautiful Letdown", 224));

        SongService proxy = new CachedSongServiceProxy(new RemoteSongService(catalog));

        System.out.println("=== Proxy Pattern Demo ===");
        System.out.println("Real service sleeps 1 second per call. Proxy hides that after the first lookup.\n");

        System.out.println("searchById first call (cache miss and pause ~1s): " + proxy.searchById(2));
        System.out.println("searchById second call (cached): " + proxy.searchById(2));
        System.out.println();

        System.out.println("searchByTitle first call (cache miss and pause ~1s): " + proxy.searchByTitle("Birdland"));
        System.out.println("searchByTitle second call (cached): " + proxy.searchByTitle("Birdland"));
        System.out.println();

        System.out.println("searchByAlbum first call (cache miss and pause ~1s): " + proxy.searchByAlbum("Heavy Weather"));
        System.out.println("searchByAlbum second call (cached): " + proxy.searchByAlbum("Heavy Weather"));
    }
}
/*
 
  Sample Run:
  ~/Dropbox/Academic/CalPolyPomona/2025/2025Fall/CS5800/HW/HW5/proxy main*
❯  mvn exec:java -Dexec.mainClass=proxy.Driver
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------------< com.calpoly:proxy >--------------------------
[INFO] Building Proxy Pattern - Music Streaming 1.0.0
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.6.1:java (default-cli) @ proxy ---
=== Proxy Pattern Demo ===
Real service sleeps 1 second per call. Proxy hides that after the first lookup.

... delay for 1 second ... : searchById first call (cache miss and pause ~1s): Song{_id=2, _title='Birdland', _artist='Weather Report', _album='Heavy Weather', _duration=360}
searchById second call (cached): Song{_id=2, _title='Birdland', _artist='Weather Report', _album='Heavy Weather', _duration=360}

... delay for 1 second ... : searchByTitle first call (cache miss and pause ~1s): [Song{_id=2, _title='Birdland', _artist='Weather Report', _album='Heavy Weather', _duration=360}]
searchByTitle second call (cached): [Song{_id=2, _title='Birdland', _artist='Weather Report', _album='Heavy Weather', _duration=360}]

... delay for 1 second ... : searchByAlbum first call (cache miss and pause ~1s): [Song{_id=2, _title='Birdland', _artist='Weather Report', _album='Heavy Weather', _duration=360}]
searchByAlbum second call (cached): [Song{_id=2, _title='Birdland', _artist='Weather Report', _album='Heavy Weather', _duration=360}]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.332 s
[INFO] Finished at: 2025-10-29T07:33:22-07:00
[INFO] ------------------------------------------------------------------------


 */