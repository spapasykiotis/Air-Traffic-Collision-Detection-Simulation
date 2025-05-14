
public class factorial {
     public  int cfactorial(int n) 
    { 
        if (n == 0) 
          return 1; 
          
        return n*cfactorial(n-1); 
    } 
}
