import java.util.Comparator;

public class sortbyX implements Comparator<airplane>  {

    @Override
    public int compare(airplane a, airplane b) {
        return (a.x - b.x);
    }
    
}
