import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Playlist {

    private ArrayList<Song> songs;

    // Constructor to initialize an empty playlist
    public Playlist() {
        // Make sure to initialize the songs ArrayList
        songs = new ArrayList<>();
    }

    // Constructor that initializes a playlist from a file
    public Playlist(String filename) throws IOException {
        this(); // Initialize the songs ArrayList
        addSongs(filename); // Load songs from the file
    }

    // Get the number of songs
    public int getNumSongs() {
        return songs.size();
    }

    // Get a song by its index
    public Song getSong(int index) {
        if (index < 0 || index >= getNumSongs()) {
            return null;
        }
        return songs.get(index);
    }

    // Get all songs as an array
    public Song[] getSongs() {
        return songs.toArray(new Song[0]);
    }

    // Add a song at the end of the playlist
    public boolean addSong(Song song) {
        return addSong(getNumSongs(), song);
    }

    // Add a song at a specific index
    public boolean addSong(int index, Song song) {
        if (index < 0 || index > getNumSongs() || song == null) {
            return false;
        }
        songs.add(index, song);
        return true;
    }

    // Add all songs from another playlist
    public int addSongs(Playlist playlist) {
        if (playlist == null) {
            return 0; // Return 0 if the playlist reference is null
        }
        int count = 0;
        for (Song song : playlist.getSongs()) {
            if (addSong(song)) {
                count++;
            }
        }
        return count;
    }

    // Remove and return the last song in the playlist
    public Song removeSong() {
        return removeSong(getNumSongs() - 1);
    }

    // Remove and return a song at a specific index
    public Song removeSong(int index) {
        if (index < 0 || index >= getNumSongs()) {
            return null;
        }
        return songs.remove(index);
    }

    // Save the playlist to a file
    public void saveSongs(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(this.toString());
        }
    }

    // Read and add songs from a file
    public int addSongs(String filename) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                addSong(new Song(line));
                count++;
            }
        }
        return count;
    }

    // Return a string representation of the playlist (all songs separated by newlines)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Song song : songs) {
            sb.append(song.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    // Get the total time of all songs in the playlist as an array of ints (seconds, minutes, hours)
    public int[] getTotalTime() {
        int totalSeconds = 0;

        // Calculate total seconds for each song's time
        for (Song song : songs) {
            int[] time = song.getTime();
            if (time.length == 1) {
                totalSeconds += time[0]; // seconds only
            } else if (time.length == 2) {
                totalSeconds += time[1] * 60 + time[0]; // minutes and seconds
            } else if (time.length == 3) {
                totalSeconds += time[2] * 3600 + time[1] * 60 + time[0]; // hours, minutes, seconds
            }
        }

        // Convert total seconds into hours, minutes, and seconds
        int hours = totalSeconds / 3600;
        totalSeconds %= 3600;
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        if (hours > 0) {
            return new int[] {seconds, minutes, hours};
        } else if (minutes > 0) {
            return new int[] {seconds, minutes};
        } else {
            return new int[] {seconds};
        }
    }
}