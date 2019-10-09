public class Artist {
    public String name;

    
    /** 
     * @param name
     * @return 
     */
    public Artist(String name) {
        this.name = name;
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
     * @return String
     */
    @Override
    public String toString() {
        return name;
    }
}
