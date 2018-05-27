import javax.lang.model.util.ElementScanner6;

class DessinFP17{
    private final Turtle bob;
    
    private final static int LARGEUR = 1600;
	private final static int HAUTEUR = 1200;
	private final double inc = 4;
    //taille de la fenetre graphique

    public DessinFP17(){
		bob  = new Turtle();
		Turtle.setCanvasSize(LARGEUR,HAUTEUR);//à appeler APRES création de la tortue
    }

    public DessinFP17(int v){
		//attention, plus v est grand, plus bob va lentement !
		this();
		bob.speed(v);
    }


    public void reset(){
		bob.clear();
		bob.up();
		bob.setPosition(0,0);
		bob.setDirection(0);
		bob.down();
    }

    public void close(){
		bob.exit();
	}

	

	public void tourGigogne(double l, int n){
		if(n==0)
			bob.forward(l);
		else{
			bob.left(90);
			bob.forward(l);
			bob.right(90);
			bob.forward(l/4);
			tourGigogne(l/2, n-1);
			bob.forward(l/4);
			bob.right(90);
			bob.forward(l);
			bob.left(90);
		}
	}

	public double hauteurTG(double l, int n){
		if(n==0)
			return 0;
		if(n==1)
			return l;
		else
			return l + hauteurTG(l/2, n-1);
	}

	public double longueurTG(double l, int n){
		if(n==0)
			return l;
		else if (n==1)
			return 3*l;
		else
			return 2.5*l+longueurTG(l/2, n-1);
	}


    public static void main(String[] args){
		DessinFP17 d = new DessinFP17(15);
		d.reset();
		d.tourGigogne(50, 4);
		System.out.println(d.hauteurTG(50, 4));
		System.out.println(d.longueurTG(50, 4));
		d.bob.hide();
    }
    
}