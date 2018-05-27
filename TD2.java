public class TD2{
    static int puiss(int x, int n){
        if(n==0 || x==1){
            return 1;
        }
        if(x==0){
            return 0;
        }
        if(n==1){
            return x;
        }
        return x*puiss(x, n-1);
    }

    static int puissRapide(int x, int n){
        if(n==0 || x==1){
            return 1;
        }
        if(x==0){
            return 0;
        }
        if(n==1){
            return x;
        }
        return x*puiss(x, (n-1)/2)*puiss(x, (n-1)/2);
    }

    static int pivot(int[] t, int i, int j){
        if(i<=j){
            int p = t[j];
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(puiss(100,15));
        System.out.println(puissRapide(100,15));

        int[] tab = {1,3,2,9,8,5,7,4,6};

    }
}