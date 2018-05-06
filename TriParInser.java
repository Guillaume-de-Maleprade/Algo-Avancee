import java.util.Arrays;

public class TriParInser{

    static void insere(int[] t, int i) {
        if(i < t.length-1){
            if(t[i+1]<t[i]){ // Si t[i+1] < t[i], on échange les deux valeurs :
                int x = t[i];
                t[i]=t[i+1];
                t[i+1]=x;
                // Puis on appelle {@code insere()} sur la case suivante
                insere(t, i+1);
            }
        }
    }

    static void triInserAux(int[] t, int i) {
        // 0 <= i <= t.length
        // trie le sous tableau t [ i .. (t.length-1) ] dans l'ordre croissant
        if (i < t.length){
            triInserAux (t, i+1);
            insere(t, i);
        }
    }
    
    static void triInser (int[] t) {
        // trie t par ordre croissant
        triInserAux(t, 0);
    }

    public static void main(String[] args) {
        int[] tab = {1,2,4,7,5,3,10};
        System.out.println(Arrays.toString(tab));
        triInser(tab);
        System.out.println(Arrays.toString(tab));
    }
}