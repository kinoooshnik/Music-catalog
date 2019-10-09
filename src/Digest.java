import java.util.ArrayList;
import java.util.HashSet;

public class Digest {
    public String name;
    public Type concept;
    public ArrayList<Track> tracks;

    enum Type {
        Single, Album, Mixtape
    }

    
    /** 
     * @param name
     * @param tracks
     * @return 
     */
    public Digest(String name, ArrayList<Track> tracks) {
        this.name = name;
        this.tracks = new ArrayList<>();
        this.tracks.addAll(tracks);
        this.setConcept();
    }

    public void setConcept() {
        HashSet<Artist> artistList = this.getArtists();
        if (this.tracks.size() == 1) {
            concept = Type.Single;
        } else if (artistList.size() > 1){
             concept = Type.Mixtape;
        } else {
            concept = Type.Album;
        }
    }

    
    /** 
     * @param tracks
     */
    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = new ArrayList<>();
        this.tracks.addAll(tracks);
        this.setConcept();
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @param track
     */
    public void addTrack(Track track) {
        this.tracks.add(track);
        this.setConcept();
    }

    
    /** 
     * @param artist
     * @return Digest
     */
    public Digest getDigestByArtist(Artist artist) {
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).artist.equals(artist)){
                return this;
            }
        }
        return null;
    }

    
    /** 
     * @return HashSet<Artist>
     */
    public HashSet<Artist> getArtists () {
        HashSet<Artist> artistList = new HashSet<>();
        for (int i = 0; i < this.tracks.size(); i++) {
            artistList.add(this.tracks.get(i).artist);
        }
        artistList.remove(null);
        return artistList;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Digest{" + name + ", tracks=" + tracks + '}';
    }
}
