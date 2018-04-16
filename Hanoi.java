/**
 * @author Guillaume de Maleprade
 */
public class Hanoi{

    /**
     * @param n number of disks
     * @param i starting tower in {1,2,3}
     * @param j ending tower in {1,2,3}
     * @return shows the list of movements to resolve a 3-tower Hanoi game of {@code n} disks from tower {@code i} to tower {@code j}
     */
    public static void resoudreAux(int n, int i, int j){
        int k = 6-i-j;
        if(n==0){
            System.out.println("Rien à faire... Hanoi vide");
        }
        if(n==1){
            System.out.println(i+"->"+(i+j));
        }
        if(n==2){
            System.out.println(i+"->"+k);
            System.out.println(i+"->"+j);
            System.out.println(k+"->"+j);
        }
        if(n==3){
            System.out.println(i+"->"+j);
            System.out.println(i+"->"+k);
            System.out.println(j+"->"+k);
            System.out.println(i+"->"+j);
            System.out.println(k+"->"+i);
            System.out.println(k+"->"+j);
            System.out.println(i+"->"+j);
        }
        if(n>3){
            resoudreAux(n-1,i,k);
            System.out.println(i+"->"+j);
            resoudreAux(n-1,k,j);
        }
    }

    /**
     * @param n number of disks
     * @return shows the list of movements to resolve a 3-tower Hanoi game of {@code n} disks from tower 1 to tower 3
     * @return the number of movements to move {@code n} disks
     */
    public static void resoudre(int n){
        resoudreAux(n,1,3);
        System.out.println("Il faut "+ nbCoups(n)+" coups pour résoudre un hanoi à " + n + " disques !");
    }

    /**
     * @param n number of disks
     * @return the number of movements to move {@code n} disks
     */
    public static int nbCoups(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else if(n==2){
            return 3;
        }else if(n==3){
            return 7;
        }else{
            return 2*nbCoups(n-1)+1;
        }
        // = 2^n - 1
    }

    public static void main(String[] args) {
        resoudre(5);
    }

}
