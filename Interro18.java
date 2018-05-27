//import java.math.*;
public class Interro18{
    public static int aux(int[] t, int i){
        if(i==t.length){return 0;}
        if(t[i]!=0){return 0;}
        else{return 1 + aux(t, i+1);}
    }

    public static int nbConsec(int[]t, int i){
        if(i==t.length){return 0;}
        else{
            int x = aux(t ,i);
            int y = nbConsec(t, i+1);
            return Math.max(x, y);
        }
    }

    public static void main(String[] args) {
        int[] tab = {1,1,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0};
        System.out.println(nbConsec(tab, 8));
    }
}