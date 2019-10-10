import java.util.ArrayList;
import java.util.HashSet;

public class Track {
    public String name;
    public Artist artist;
    public Beatmaker beatmaker;
    public String genre;
    public int time;
    public int date;
    public List<Artist> collaboration = new ArrayList<>();

    
    /** 
     * @param name
     * @param artist
     * @param genre
     * @param date
     * @return 
     */
    public Track(String name, Artist artist, String genre, int date, int time, Beatmaker beatmaker) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.date = date;
        this.time = time;
        this.beatmaker = beatmaker;
    }

    public void setCollaboration(List<Artist> artists) {
        this.collaboration.addAll(artists);
    }

    public List<Artist> getCollaboration(){
        return collaboration;
    }

    public void addCollaborator(Artist artist) {
        this.collaboration.add(artist);
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTime() {
        return ((time / 60) + ":" + (time % 60);
    }

    
    /** 
     * @param name
     * @return 
     */
    public Track(String name) {
        this.name = name;
    }


    
    /** 
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @return Artist
     */
    public Artist getArtist() {
        return artist;
    }

    
    /** 
     * @param artist
     */
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    
    /** 
     * @return int
     */
    public int getDate() {
        return date;
    }

    
    /** 
     * @param date
     */
    public void setDate(int date) {
        this.date = date;
    }

    
    /** 
     * @return String
     */
    public String getAllInfo() {
        return "Track " + name + " " + artist.name + " " + date + " " + genre;
    }

    
    /** 
     * @param artist
     * @return Track
     */
    public Track getTrackByArtist(Artist artist){
        if (this.artist.name.equals(artist.name)){
            return this;
        } else {
            return null;
        }
    }

    public Track getTrackByName(String name){
        if (this.name.equals(name)){
            return this;
        } else {
            return null;
        }
    }

    public Track isTimeOfTrackMoreThan(int time) {
        if (this.time >= time) {
            return this;
        } else {
            return null;
        }
    }

    
    /** 
     * @param date
     * @return Track
     */
    public Track getTrackByDate(int date){
        if (this.date == date){
            return this;
        } else {
            return null;
        }
    }

    
    /** 
     * @param genre
     * @return HashSet<Track>
     */
    public HashSet<Track> getTrackByGenre(Genre genre){
        HashSet <Track> trackList = new HashSet<>();
        if (this.genre.equals(genre.name)){
            trackList.add(this);
        } else {
            for (int i = 0; i < genre.subGenre.size(); i++) {
                trackList.addAll(getTrackByGenre(genre.subGenre.get(i)));
            }
        }
        trackList.remove(null);
        return trackList;
    }

    
    /** 
     * @param genre
     * @return HashSet<Artist>
     */
    public HashSet<Artist> getArtistByGenre(Genre genre){
        HashSet <Artist> artistList = new HashSet<>();
        if (this.genre.equals(genre.name)){
            artistList.add(this.artist);
        } else {
            for (int i = 0; i < genre.subGenre.size(); i++) {
                artistList.addAll(getArtistByGenre(genre.subGenre.get(i)));
            }
        }
        return artistList;
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return name;
    }
}
