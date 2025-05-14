import java.util.Random;

public class airplane{ //implements Comparable{
    
    Random r1 = new Random(); // Random object 
    int ID;
    
    //Coordinates
    int x;
    int y;
    int z;

    //  Constuctors
    public airplane(int x, int y, int z, int ID) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.ID = ID;
    }
    public airplane(int ID){
        x=r1.nextInt(5000);
        y=r1.nextInt(1500);
        z=r1.nextInt(100);
        this.ID=ID;
    }
    








    
////////////////Getters Setters//////////////    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
 /*   
 @Override
 public int compareTo(Object o) {
    return  (this.getX() < ((airplane) o).getX() ? -1 : (this.getX() == ((airplane) o).getX() ? 0 : 1));
}
 */   
 
}
