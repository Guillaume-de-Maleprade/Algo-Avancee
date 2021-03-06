import java.util.Arrays;

public class Partiel17{
    public static String retourne(String s){
        if(s.length()<=1){
            return s;
        }else{
            return s.substring(
                s.length()-1
            ) + retourne(
                    s.substring(
                        0,
                        (s.length()-1)
                    )
                );
        }
    }

    public static int triAux(int[]t, int i){
        if(i>=t.length){
            return t.length;
        }
        /* if(i==t.length-1){
            if(t[i]==1){
                return t.length-1;
            }else{
                return t.length;
            }
        } */else{
            if(t[i]==1){
                int j = triAux(t,i+1)-1;
                if(t[j]==0){
                    t[j]=1;
                    t[i]=0;
                    return j;
                }
                return i;
            }else{
                return triAux(t,i+1);
            }
        }
    }


    public static void main(String[] args) {
        String a = new String("banane");
        System.out.println(retourne(a));
        int[] tab = {1,0,1,1,1,0,0};
        System.out.println(triAux(tab,2));
        System.out.println(Arrays.toString(tab));
    }
}