import java.lang.reflect.Array;
import java.util.Arrays;

public class TD1{
    //1
    /**
     * @param n integer
     * @return : return the factorial of the {@code n}
     */
    private static int factorielle(int n){
        if(n==1){
            return 1;
        }else{
            return factorielle(n-1)*n;
        }
    }

    //2
    /**
     * @param n integer
     * @return true if {@code n} is even, false if not
     */
    private static boolean pair(int n){
        if(n==0){
            return true;
        }else if(n==1){
            return false;
        }else{
            return pair(n-2);
        }
    }

    //3
    /**
     * @param n odd number
     * @return the sum of all the odd numbers from 1 to {@code n}
     */
    private static int sommeImpairs(int n){
        if(n==1){
            return 1;
        }else{
            return sommeImpairs(n-2)+n;
        }
    }

    //4
    /**
     * @param x integer
     * @param n integer
     * @return {@code x} to the power of {@code n}
     */
    private static int puiss(int x, int n){
        if(x==1||n==0){
            return 1;
        }else if(x==0){
            return 0;
        }else{
            return puiss(x, n-1)*x;
        }
    }

    //5.1
    /* private int nbOccAux(int x, int[] t, int i){

    } */

    //6
    /**
     * @param t array of characters
     * @return true if {@code t} is a palindrome, false if not
     */
    private static boolean estPalindrome(char[] t){
        if(t[0]!=t[t.length-1]){
            return false;
        }else if(t.length <= 1){
            return true;
        }else{
            return estPalindrome(Arrays.copyOfRange(t, 1, t.length-1));
        }  
    }

    //7
    /**
     * @param t array of integers
     * @return true if the integers in {@code t} are in ascending order, flase if not
     */
    private static boolean croissants(int[] t){
        if(t.length<=1){ // If the array is empty, or if there is only one integer, returns true
            return true;
        }
        if(t[t.length-1]>=t[t.length-2]){
            int[] petit = Arrays.copyOfRange(t, 0, t.length-2);
            return croissants(petit);
        }
        return false;
    }





    public static void main(String[] args) {
        //1
        System.out.println("4! = " + factorielle(4));

        //2
        System.out.println("9 est pair ? " + pair(9));
        System.out.println("140 est pair ? " + pair(140));

        //3
        System.out.println("Somme des impairs jusqu'à 15 : " + sommeImpairs(15));
        System.out.println("Somme des impairs jusqu'à 145 : " + sommeImpairs(145));

        //4
        System.out.println("3^3 = " + puiss(3,3));

        //6
        char [] tPal = {'a','b','c','b','a'};
        System.out.println(Arrays.toString(tPal) +" est Palindrome ? "+ estPalindrome(tPal));
        char [] tNoPal = {'a','b','c','d','a'};
        System.out.println(Arrays.toString(tNoPal) +" est Palindrome ? "+ estPalindrome(tNoPal));

        //7
        int[] ordre = {1,2,5,8,9};      // in order
        int[] vide = {};                // empty
        int[] desordre = {6,5,6,7};     // in disorder
        System.out.println(Arrays.toString(ordre) +" est dans l'ordre croissant ? "+ croissants(ordre));
        System.out.println(Arrays.toString(vide) +" est dans l'ordre croissant ? "+ croissants(vide));
        System.out.println(Arrays.toString(desordre) +" est dans l'ordre croissant ? "+ croissants(desordre));





    }



}