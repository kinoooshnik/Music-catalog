import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Catalog {
    public ArrayList<Digest> catalog;
    public List<Genre> genres;

    
    /** 
     * @param catalog
     * @return 
     */
    public Catalog(ArrayList<Digest> catalog) {
        this.catalog = new ArrayList<>();
        this.catalog.addAll(catalog);
        this.genres = new ArrayList<>();
    }

    
    /** 
     * @return 
     */
    public Catalog() {
        catalog = new ArrayList<>();
        genres = new ArrayList<>();
    }

    
    /** 
     * @return ArrayList<Digest>
     */
    public ArrayList<Digest> getCatalog() {
        return catalog;
    }

    
    /** 
     * @param catalog
     */
    public void setCatalog(ArrayList<Digest> catalog) {
        this.catalog = catalog;
    }

    
    /** 
     * @param digest
     */
    public void addDigest(Digest digest){
        catalog.add(digest);
    }

    
    /** 
     * @param genre
     */
    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    
    /** 
     * @param genres
     */
    public void addGenres(List<Genre> genres) {
        this.genres.addAll(genres);
    }

    
    /** 
     * @param artist
     * @return HashSet<Track>
     */
    public HashSet<Track> getTracksByArtist(Artist artist){
        HashSet <Track> trackList = new HashSet<>();
        for (int i = 0; i < catalog.size(); i++) {
            for (int j = 0; j < catalog.get(i).tracks.size(); j++) {
                trackList.add(catalog.get(i).tracks.get(j).getTrackByArtist(artist));
            }
        }
        trackList.remove(null);
        return trackList;
    }

    public HashSet<Track> getTracksByTime(int time){
        HashSet <Track> trackList = new HashSet<>();
        for (int i = 0; i < catalog.size(); i++) {
            for (int j = 0; j < catalog.get(i).tracks.size(); j++) {
                trackList.add(catalog.get(i).tracks.get(j).isTimeOfTrackMoreThan(time);
            }
        }
        trackList.remove(null);
        return trackList;
    }

    
    /** 
     * @param date
     * @return HashSet<Track>
     */
    public HashSet<Track> getTracksByDate(int date){
        HashSet <Track> trackList = new HashSet<>();
        for (int i = 0; i < catalog.size(); i++) {
            for (int j = 0; j < catalog.get(i).tracks.size(); j++) {
                trackList.add(catalog.get(i).tracks.get(j).getTrackByDate(date));
            }
        }
        trackList.remove(null);
        return trackList;
    }

    
    /** 
     * @param genreName
     * @return HashSet<Track>
     */
    public HashSet<Track> getTracksByGenre(String genreName){
        Genre genre = this.findGenre(genreName);
        HashSet <Track> trackList = new HashSet<>();
        for (int i = 0; i < catalog.size(); i++) {
            for (int j = 0; j < catalog.get(i).tracks.size(); j++) {
                trackList.addAll(catalog.get(i).tracks.get(j).getTrackByGenre(genre));
            }
        }
        trackList.remove(null);
        return trackList;
    }

    
    /** 
     * @param digest
     * @return HashSet<Artist>
     */
    public HashSet<Artist> getArtistsByDigest (Digest digest) {
        HashSet<Artist> artistList = new HashSet<>();
        if (digest.concept.equals("Album") || digest.concept.equals("Single")){
            artistList.add(digest.tracks.get(0).artist);
            return artistList;
        }
        for (int i = 0; i < digest.tracks.size(); i++) {
            artistList.add(digest.tracks.get(i).artist);
        }
        artistList.remove(null);
        return artistList;
    }

    
    /** 
     * @param genreName
     * @return HashSet<Artist>
     */
    public HashSet<Artist> getArtistsByGenre (String genreName) {
        Genre genre = this.findGenre(genreName);
        HashSet<Artist> artistList = new HashSet<>();
        for (int i = 0; i < catalog.size(); i++) {
            for (int j = 0; j < catalog.get(i).tracks.size(); j++)
            {
                artistList.addAll(catalog.get(i).tracks.get(j).getArtistByGenre(genre));
            }
        }
        artistList.remove(null);
        return artistList;
    }

    
    /** 
     * @param artist
     * @return HashSet<Digest>
     */
    public HashSet<Digest> getDigestByArtist (Artist artist) {
        HashSet<Digest> digestList = new HashSet<>();
        for (int i = 0; i < catalog.size(); i++) {
            for (int j = 0; j < catalog.get(i).tracks.size(); j++)
            {
                if (catalog.get(i).tracks.get(j).artist.equals(artist)) {
                    digestList.add(catalog.get(i));
                }
            }
        }
        digestList.remove(null);
        return digestList;
    }

    
    /** 
     * @param track
     * @return HashSet<Digest>
     */
    public HashSet<Digest> getDigestByTrack (Track track) {
        HashSet<Digest> digestList = new HashSet<>();
        for (int i = 0; i < catalog.size(); i++) {
            for (int j = 0; j < catalog.get(i).tracks.size(); j++)
            {
                if (catalog.get(i).tracks.get(j).equals(track)) {
                    digestList.add(catalog.get(i));
                }
            }
        }
        digestList.remove(null);
        return digestList;
    }

    
    /** 
     * @param genre
     * @param date
     * @return HashSet<Track>
     */
    public HashSet<Track> getTracksByDateAndGenre (String genre, int date) {
        HashSet<Track> trackList = new HashSet<>();
        trackList.addAll(this.getTracksByDate(date));
        trackList.retainAll(this.getTracksByGenre(genre));
        return trackList;
    }

    
    /** 
     * @param artist
     * @param genre
     * @return HashSet<Track>
     */
    public HashSet<Track> getTracksByArtistAndGenre (Artist artist, String genre) {
        HashSet<Track> trackList = new HashSet<>();
        trackList.addAll(this.getTracksByGenre(genre));
        trackList.retainAll(this.getTracksByArtist(artist));
        return trackList;
    }

    
    /** 
     * @param artist
     * @param date
     * @return HashSet<Track>
     */
    public HashSet<Track> getTracksByArtistAndDate (Artist artist, int date) {
        HashSet<Track> trackList = new HashSet<>();
        trackList.addAll(this.getTracksByDate(date));
        trackList.retainAll(this.getTracksByArtist(artist));
        return trackList;
    }


    
    /** 
     * @param genre
     * @return Genre
     */
    public Genre findGenre(String genre) {
        for (int i = 0; i < genres.size(); i++) {
             if (genres.get(i).findGenres(genre) != null){
                 return genres.get(i).findGenres(genre);
             }
        }
        return null;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Catalog{" + catalog + '}';
    }
}
