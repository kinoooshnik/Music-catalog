import java.util.ArrayList;

public class Genre {
    public String name;
    public ArrayList<Genre> subGenre;


    
    /** 
     * @param genre
     * @return 
     */
    public Genre(String genre) {
        name = genre;
        subGenre = new ArrayList<>();
    }

    
    /** 
     * @param genre
     * @param list
     * @return 
     */
    public Genre(String genre, ArrayList<Genre> list){
        name = genre;
        subGenre = new ArrayList<>();
        subGenre.addAll(list);
        checkErorr(new ArrayList<>());
    }

    
    /** 
     * @return 
     */
    public Genre() {
        subGenre = new ArrayList<>();
    }

    
    /** 
     * @param list
     */
    public void addSubGenre(Genre list){
        subGenre.add(list);
        checkErorr(new ArrayList<>());
    }

    
    /** 
     * @param genres
     */
    public void checkErorr(ArrayList<Genre> genres) {
        if (genres.contains(this)){
            System.out.println("Нарушена консистентность класса Genre");
            System.exit(0);
        } else {
            genres.add(this);
            for (int i = 0; i < this.subGenre.size(); i++) {
                this.subGenre.get(i).checkErorr(genres);
                genres.add(this.subGenre.get(i));
            }
        }
    }

    
    /** 
     * @param genre
     * @return Genre
     */
    public Genre findGenres(String genre) {
        if (this.name.equals(genre)){
            return this;
        } else {
            for (int i = 0; i < this.subGenre.size(); i++){
                if (this.subGenre.get(i).name.equals(genre)) {
                     return this.subGenre.get(i);
                } else {
                    if (this.subGenre.get(i).findGenres(genre) != null)
                    {
                        return this.subGenre.get(i).findGenres(genre);
                    }
                }
            }
        }
        return null;
    }
}
