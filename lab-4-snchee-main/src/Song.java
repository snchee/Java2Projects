import java.util.Arrays;

public class Song {
	private String title;
	private String artist;
	private int[] time;
	
	//constructor
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist = artist;
		//copy of time array
		this.time = Arrays.copyOf(time, time.length);
	}
	
	//getters
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int[] getTime () {
		//return a copy for immutability
		return Arrays.copyOf(time,  time.length);
	}

}
