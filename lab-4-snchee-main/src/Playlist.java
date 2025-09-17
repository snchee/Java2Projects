import java.util.Arrays;

public class Playlist {
	private Song[] songs;
	private int numSongs;
	private static final int MIN_CAPACITY = 3;
	
	//constructor
	public Playlist() {
		this(MIN_CAPACITY);
	}
	
	//constructor w/ capacity
	public Playlist(int capacity) {
		if (capacity < MIN_CAPACITY) {
			capacity = MIN_CAPACITY;
		}
		songs = new Song[capacity];
		numSongs = 0;
	}
	
	//return the capacity of the songs array
	public int getCapacity() {
		return songs.length;
	}
	
	//return the number of songs in the playlist
	public int getNumSongs() {
		return numSongs;
	}
	
	//get a song by index
	public Song getSong(int index) {
		if (index < 0 || index >= numSongs) {
			return null;
		}
		return songs[index];
	}
	
	//return a copy of the current songs
	public Song[] getSongs() {
		return Arrays.copyOf(songs, numSongs);
	}
	
	//add a song to the first empty spot in the array
	public boolean addSong(Song song) {
		if (numSongs >= songs.length || song == null) {
			return false; //array is full
		}
		songs[numSongs] = song;
		numSongs++;
		return true;
	}
	
	//add a song at a specific index
	public boolean addSong(int index, Song song) {
		if (numSongs >= songs.length || song == null || index < 0 || index > numSongs) {
			return false;
		}
		//shift elements to the right
		for (int i = numSongs; i > index; i--) {
			songs[i] = songs[i - 1];
		}
		songs[index] = song;
		numSongs++;
		return true;
	}
	
	//add songs from another playlist
	public int addSongs(Playlist playlist) {
		if (playlist == null) {
			return 0;
		}
		int addedSongs = 0;
		int availableCapacity = songs.length - numSongs;
		int numSongsToAdd = Math.min(playlist.getNumSongs(), availableCapacity);
		for (int i = 0; i < numSongsToAdd; i++) {
			if (numSongs < songs.length) {
				songs[numSongs] = playlist.getSong(i);
				numSongs++;
				addedSongs++;
			} else {
				break;
			}
		}
		return addedSongs;
	}
	
	//remove and return the last song
	public Song removeSong() {
		if (numSongs == 0) {
			return null;
		}
		Song removedSong = songs[numSongs - 1];
		songs[numSongs - 1] = null;
		numSongs--;
		return removedSong;
	}
	
	//remove a song at a certain index
	public Song removeSong(int index) {
		if (index < 0 || index >= numSongs) {
			return null;
		}
		Song removedSong = songs[index];
		//shift elements to the left
		for (int i = index; i < numSongs - 1; i++) {
			songs[i] = songs[i + 1];
		}
		songs[numSongs - 1] = null;
		numSongs--;
		return removedSong;
	}

}
