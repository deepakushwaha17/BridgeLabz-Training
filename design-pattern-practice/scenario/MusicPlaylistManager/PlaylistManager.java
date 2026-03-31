package scenario.MusicPlaylistManager;

import java.util.*;

public class PlaylistManager {
    private LinkedList<Song> playlist = new LinkedList<>();
    private Stack<Song> history = new Stack<>();
    private Set<Song> songSet = new HashSet<>();

    public void addSong(Song song) throws SongAlreadyExistsException {
        if (songSet.contains(song)) {
            throw new SongAlreadyExistsException("Song already exists in playlist!");
        }
        playlist.add(song);
        songSet.add(song);
        System.out.println("Added: " + song);
    }

    public void playSong() {
        if (!playlist.isEmpty()) {
            Song song = playlist.removeFirst();
            history.push(song);
            System.out.println("Now playing: " + song);
        } else {
            System.out.println("Playlist is empty!");
        }
    }

    public void showPlaylist() {
        System.out.println("Playlist:");
        for (Song s : playlist) {
            System.out.println(s);
        }
    }

    public void showHistory() {
        System.out.println("Recently Played:");
        for (Song s : history) {
            System.out.println(s);
        }
    }
}
