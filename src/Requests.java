import java.util.ArrayList;
import java.util.Arrays;

public class Requests {
        
        /** 
         * @param args
         */
        public static void main(String[] args) {
            Artist artist1 = new Artist("GONE.Fludd");
            Artist artist2 = new Artist("Oxxxymiron");
            Artist artist3 = new Artist("Twenty one pilots");
            Artist artist4 = new Artist("Pharaoh");
            Genre genre = new Genre("Hip-hop", new ArrayList<>(Arrays.asList(new Genre("Rap"), new Genre("Cloud rap"))));
            Genre genre1 = new Genre("Rock", new ArrayList<>(Arrays.asList(new Genre("Hard Rock"), new Genre("Metal"))));
            Track track1 = new Track("Накануне", artist2, "Rap", 2014);
            Track track2 = new Track("Переплетено", artist2, "Rap", 2014);
            Track track3 = new Track("Башня из слоновой кости", artist2, "Rap", 2014);
            Track track4 = new Track("Havana", new Artist("Camila Cabello"), "Pop", 2017);
            Track track5 = new Track("My Blood", artist3, "Pop-rock", 2018);
            Track track6 = new Track("Chlorine", artist3, "Pop-rock", 2018);
            Track track7 = new Track("Мой кайф", artist4, "Cloud rap", 2018);
            Track track8 = new Track("Не По Пути", artist4, "Cloud rap", 2018);
            Track track9 = new Track("Кукла колдуна", new Artist("Король и шут"), "Rock", 1999);
            Track track10 = new Track("Сахарный человек", artist1,"Rap", 2018);
            Track track11 = new Track("Банановый сок", artist1, "Rap", 2018);
            Track track12 = new Track("Суперчуитс", artist1, "Rap", 2018);
            Track track13 = new Track("Дай пять!", artist1, "Rap", 2018);
            Track track14 = new Track("Фреймдата", artist1, "Rap", 2018);   
            Track track15 = new Track("Пустота", artist1, "Rap", 2018);
            Track track16 = new Track("Вечный жид", artist2, "Rap", 2011);
            Track track17 = new Track("Восточный Мордор", artist2, "Rap", 2011);
            Track track18 = new Track("До сих пор MC", artist2, "Rap", 2011);
            Digest digest1 = new Digest("Горгород", new ArrayList<>(Arrays.asList(track1, track2, track3)));
            Digest digest2 = new Digest("Суперчуитс", new ArrayList<>(Arrays.asList(track10, track11, track12, track13, track14, track15)));
            Digest digest3 = new Digest(track4.name, new ArrayList<>(Arrays.asList(track4)));
            Digest digest4 = new Digest("Best tracks", new ArrayList<>(Arrays.asList(track5, track6, track7, track8, track9)));
            Catalog catalog = new Catalog();
            catalog.addGenre(genre);
            catalog.addGenre(genre1);
            catalog.addDigest(digest1);
            catalog.addDigest(digest2);
            catalog.addDigest(digest3);
            catalog.addDigest(digest4);
            System.out.println(catalog.getArtistsByGenre("Rap"));
            System.out.println(catalog.getArtistsByGenre("Cloud rap"));
            System.out.println(catalog.getArtistsByGenre(genre.name));
            System.out.println(catalog.getTracksByGenre(genre.name));
            System.out.println(catalog.getArtistsByGenre("Hip-hop"));
            System.out.println(catalog.getTracksByArtist(artist1));
            System.out.println(catalog.getTracksByDate(2018));
            System.out.println(catalog.getTracksByArtistAndDate(artist2, 2011));
            System.out.println(catalog.getTracksByDateAndGenre(genre1.name, 1999));
    }
}