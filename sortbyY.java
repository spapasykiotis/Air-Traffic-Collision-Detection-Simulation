import java.util.Comparator;

public class sortbyY implements Comparator<airplane>{
    @Override
    public int compare(airplane a, airplane b) {
        return (a.y - b.y);
    }
}
