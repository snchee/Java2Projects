import java.util.Arrays;

public class Song {
    private String title;
    private String artist;
    private int[] time;

    private static final String INFO_DELIMITER = "; ";
    private static final String TIME_DELIMITER = ":";
    private static final int IDX_TITLE = 0;
    private static final int IDX_ARTIST = 1;
    private static final int IDX_TIME = 2;

    // Constructor that takes title, artist, and time
    public Song(String title, String artist, int[] time) {
        this.title = title;
        this.artist = artist;
        this.time = Arrays.copyOf(time, time.length);
    }

    // Constructor that parses the song information from a string
    public Song(String info) {
        String[] parts = info.split(INFO_DELIMITER);
        this.title = parts[IDX_TITLE];
        this.artist = parts[IDX_ARTIST];
        this.time = parseTime(parts[IDX_TIME]);
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int[] getTime() {
        return Arrays.copyOf(time, time.length);
    }

    // Converts the song back to a string in the same format it was parsed
    @Override
    public String toString() {
        return title + INFO_DELIMITER + artist + INFO_DELIMITER + formatTime();
    }

    // Helper method to parse the time string into an array of ints
    private int[] parseTime(String timeStr) {
        String[] timeParts = timeStr.split(TIME_DELIMITER);
        int[] timeArr = new int[timeParts.length];
        for (int i = 0; i < timeParts.length; i++) {
            timeArr[i] = Integer.parseInt(timeParts[timeParts.length - 1 - i]); // reverse order
        }
        return timeArr;
    }

    // Helper method to format the time array back into a string
    private String formatTime() {
        if (time.length == 1) {
            // Seconds only
            return String.format("%d", time[0]);
        } else if (time.length == 2) {
            // Minutes and seconds
            return String.format("%d:%02d", time[1], time[0]);
        } else {
            // Hours, minutes, and seconds
            return String.format("%d:%02d:%02d", time[2], time[1], time[0]);
        }
    }
}