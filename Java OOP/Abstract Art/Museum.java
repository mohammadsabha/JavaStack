import java.util.*;

public class Museum {
    public static void main(String[] args) {
        Painting painting1 = new Painting("Starry Night", "Vincent van Gogh", "A painting of a starry night sky");
        Painting painting2 = new Painting("Mona Lisa", "Leonardo da Vinci", "A portrait of a woman with a mysterious smile");
        Painting painting3 = new Painting("The Persistence of Memory", "Salvador Dali", "A surrealist painting of melting clocks");
        Sculpture sculpture1 = new Sculpture("David", "Michelangelo", "A marble sculpture of a man");
        Sculpture sculpture2 = new Sculpture("The Thinker", "Auguste Rodin", "A bronze sculpture of a man deep in thought");
        //System.out.println(painting1.viewArt());
        //System.out.println(sculpture1.viewArt());
        ArrayList<Art> museum = new ArrayList<Art>();
        museum.add(painting1);
        museum.add(painting2);
        museum.add(painting3);
        museum.add(sculpture1);
        museum.add(sculpture2);

        Collections.shuffle(museum);

        for (Art artwork : museum) {
            artwork.viewArt();
        }
    }

}