public class MainListe{

    public static void main(String[] args) {
        Liste l1 = new Liste();
        Liste l2 = new Liste();
        Liste l3 = new Liste();

        l1.ajoutFin(1);
        l1.ajoutFin(5);
        l1.ajoutFin(6);

        System.out.println(l1);

        /* l2.ajoutFin(8); */
        l2.ajoutFin(2);
        l2.ajoutFin(3);
        System.out.println(l2);
        //l1.concat(l2);
        /* System.out.println("l1 + l2 = "+l1);
        l2.setVal(50);
        System.out.println(l1);
        l2.getSuiv().setVal(51);
        System.out.println(l1); */
        l3 = l1.copie();
        System.out.println(l3);
        l3.supprimeTete();
        System.out.println(l1);
        System.out.println(l3);

    }
}