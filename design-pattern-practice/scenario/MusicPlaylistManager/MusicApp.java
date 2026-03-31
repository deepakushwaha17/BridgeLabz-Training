package scenario.MusicPlaylistManager;

public class MusicApp {
    public static void main(String[] args) throws SongAlreadyExistsException {
        PlaylistManager manager = new PlaylistManager();

        Song s1 = new Song("Shape of You", "Ed Sheeran");
        Song s2 = new Song("Blinding Lights", "The Weeknd");
        Song s3 = new Song("Shape of You", "Ed Sheeran"); // Duplicate

        manager.addSong(s1);
        manager.addSong(s2);
        try {
            manager.addSong(s3); // Will throw exception
        } catch (SongAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        manager.showPlaylist();
        manager.playSong();
        manager.showHistory();
    }
}