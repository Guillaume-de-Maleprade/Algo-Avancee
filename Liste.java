public class Liste{
    private int val;
    private Liste suiv;

    public Liste(){
        suiv = null;
    }
    public boolean estVide(){
        return suiv==null;
    }
    public String toString(){
        if(this.suiv.estVide()){
            return this.val +"";
        }else{
            return this.val +", "+this.suiv.toString();
        }
    }
    public int longueur(){
        if(this.estVide()){
            return 0;
        }else{
            return 1 + this.suiv.longueur();
        }
    }
    public boolean recherche(int x){
        if(this.estVide()){
            return false;
        }
        if(this.val==x){
            return true;
        }else{
            return this.suiv.recherche(x);
        }
    }
    public boolean croissant(){
        if(this.suiv.estVide()){
            return true;
        }
        if(this.val < this.suiv.val){
            return this.suiv.croissant();
        }else{
            return false;
        }
    }
    public void ajoutFin(int x){
        if(this.estVide()){
            this.val = x;
            this.suiv = new Liste();
        }else{
            this.suiv.ajoutFin(x);
        }
    }
    public void concat(Liste l){
        if(this.estVide()){
            this.val = l.val;
            this.suiv = l.suiv;
        }else{
            this.suiv.concat(l);
        }
    }
    public void ajoutTete(int x){
        Liste aux = new Liste();
        aux.val = val;
        aux.suiv = suiv;
        this.val = x;
        this.suiv = aux;
    }
    public void supprimeTete(){
        //sur liste non vide
        this.val = suiv.val;
        this.suiv = this.suiv.suiv;
    }
/*     public int get(int i){

    } */
    public void setVal(int x){
        this.val = x;
    }
    public Liste getSuiv(){
        return this.suiv;
    }
    public Liste copie(){
        if(this.estVide()){
            return new Liste();
        }else{
            Liste l = new Liste();
            l.val = this.val;
            l.suiv = this.suiv.copie();
            return l;
        }
    }
}
