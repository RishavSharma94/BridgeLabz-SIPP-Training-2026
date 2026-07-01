import java.util.LinkedList;

public class MusicPlaylistRecommendationEngine {

    public static void main(String[] args) {

        PlaylistManager manager = new PlaylistManager();

        manager.playSong("Believer");
        manager.playSong("Shape of You");
        manager.playSong("Perfect");
        manager.playSong("Faded");
        manager.playSong("Senorita");
        manager.playSong("Memories");
        manager.playSong("Closer");
        manager.playSong("Havana");
        manager.playSong("Levitating");
        manager.playSong("Unstoppable");
        manager.playSong("Animals");

        System.out.println();

        manager.searchSong("Closer");
        manager.searchSong("Baby");

        System.out.println();

        manager.displayPlaylist();
    }
}

class PlaylistManager {

    LinkedList<String> playlist = new LinkedList<>();

    public void playSong(String song) {

        playlist.addFirst(song);

        if (playlist.size() > 10) {
            playlist.removeLast();
        }

        System.out.println(song + " Added to Recently Played.");
    }

    public void searchSong(String song) {

        if (playlist.contains(song)) {
            System.out.println(song + " Found in Recently Played.");
        } else {
            System.out.println(song + " Not Found.");
        }
    }

    public void displayPlaylist() {

        System.out.println("Recently Played Songs:");

        for (String song : playlist) {
            System.out.println(song);
        }
    }
}