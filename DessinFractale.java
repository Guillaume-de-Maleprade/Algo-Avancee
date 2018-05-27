import javax.lang.model.util.ElementScanner6;

class DessinFractale{
    private final Turtle bob;
    
    private final static int LARGEUR = 1600;
	private final static int HAUTEUR = 1200;
	private final double inc = 4;
    //taille de la fenetre graphique

    public DessinFractale(){
		bob  = new Turtle();
		Turtle.setCanvasSize(LARGEUR,HAUTEUR);//à appeler APRES création de la tortue
    }

    public DessinFractale(int v){
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

	/**
	 * @param r rayon du cercle
	 * @param xc abscisse du centre
	 * @param yc ordonnée du centre
	 */
	public void circle(double r, double xc, double yc){
		bob.up();
		bob.setPosition(xc, yc+r);
		bob.down();
		for(double d = xc; d < r+xc; d+=inc){
			double x = d;
			double temp = r*r-(x-xc)*(x-xc);
			double y = Math.sqrt(temp)+yc;
			bob.setPosition(x, y);
		}
		for(double d = r+xc; d > xc; d-=inc){
			double x = d;
			double temp = r*r-(x-xc)*(x-xc);
			double y = -Math.sqrt(temp)+yc;
			bob.setPosition(x, y);
		}
		for(double d = xc; d > -r+xc; d-=inc){
			double x = d;
			double temp = r*r-(x-xc)*(x-xc);
			double y = -Math.sqrt(temp)+yc;
			bob.setPosition(x, y);
		}
		for(double d = -r+xc; d < xc; d+=inc){
			double x = d;
			double temp = r*r-(x-xc)*(x-xc);
			double y = Math.sqrt(temp)+yc;
			bob.setPosition(x, y);
		}
		bob.up();
		bob.setPosition(xc, yc);
		bob.down();
	}

	public void rosace(double r, double xc, double yc, int n){
		//if(n==0){
			circle(r, xc, yc);
		//}
		if(n>0){
			double x = bob.getX();
			double y = bob.getY();
			double pr = 0.5*r;
			double decXd = x + 1.5*r;
			double decXg = x - 1.5*r;
			double decYh = y + 1.5*r;
			double decYb = y - 1.5*r;
			//circle(r, xc, yc);
			
			rosace(pr, decXd, y, n-1);
			rosace(pr, decXg, y, n-1);
			rosace(pr, x, decYh, n-1);
			rosace(pr, x, decYb, n-1);
		}
	}
	
	public void vonKoch(double l, int n){
		if(n==0){
			bob.forward(l);
		}
		if(n>0){
			vonKoch(l/3,n-1);
			bob.left(60);
			vonKoch(l/3,n-1);
			bob.right(120);
			vonKoch(l/3,n-1);
			bob.left(60);
			vonKoch(l/3,n-1);
		}

	}


    public void carre(double l){
		bob.forward(l);
		bob.left(90);
		bob.forward(l);
		bob.left(90);
		bob.forward(l);
		bob.left(90);
		bob.forward(l);
		bob.left(90);
	}
	
	public void flocon(double l, int n){
		long angle = 120;
		bob.speed(1);
		bob.right(angle);
		vonKoch(l, n);
		bob.right(angle);
		vonKoch(l, n);
		bob.right(angle);
		vonKoch(l, n);
	}

	public void arbre(double l, double a, int n){
		bob.forward(l);
		if(n>0){
			double x = bob.getX();
			double y = bob.getY();
			bob.left(a);

			arbre(l/2, a, n-1);
			bob.up();
			bob.setPosition(x, y);
			bob.down();

			bob.right(a);

			arbre(l/2, a, n-1);
			bob.up();
			bob.setPosition(x, y);
			bob.down();

			bob.right(a);

			arbre(l/2, a, n-1);
			bob.up();
			bob.setPosition(x, y);
			bob.down();

			bob.left(a);

		}
	}

	public void triforceAux(double x, double y, double l, int n){
		if(n==1){
			bob.up();
			bob.setPosition(x, y, 0);
			bob.down();
			bob.forward(l);
			bob.left(120);
			bob.forward(l);
			bob.left(120);
			bob.forward(l);
		}
		if(n>1){
			double tempX = x+(l/4);
			double tempY = y+(l/2)*Math.sin(Math.toRadians(60));
			triforceAux(x,y,l/2,n-1);
			triforceAux(x+l/2,y,l/2,n-1);
			triforceAux(tempX,tempY,l/2,n-1);
		}
	}

	public void triforce(double l, int n){
		double x = -l/2;
		double y = (-l/2)*Math.sin(Math.toRadians(60));
		triforceAux(x, y, l, n);
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

	/*public void dragonAuxA(double l, int n){
 		bob.forward(l);
		if(n>0){
			double x = bob.getX();
			double y = bob.getY();
			dragonAuxB(l, n-1);
			bob.up();
			bob.setPosition(x, y);
			bob.down();
			bob.right(90);
			dragonAuxB(l, n-1);
			
		}
	}
	public void dragonAuxB(double l, int n){
		bob.forward(l);
		if(n>1){
				dragonAuxA(l, n-1);
				bob.left(90);
				dragonAuxA(l, n-1);
			
		}
	}
	public void dragon(double l, int n){
		dragonAuxA(l, n);
		dragonAuxB(l, n);
	} */


    public static void main(String[] args){
		long dist = 600;
		DessinFractale d = new DessinFractale(15);
		//d.carre(90);
		//d.vonKoch(dist, 0);
		//d.vonKoch(dist, 1);
		d.reset();
		//d.carre(60);
		//d.vonKoch(dist, 2);
		//d.flocon(dist, 6);
		//d.bob.left(90);
		//d.triforce(800,6);
		//d.circle(50,150,25);
		//d.frac(50, 0, 0, 15, 0.8, 5);
		//		d.dragon(50, 2);
		d.tourGigogne(50, 4);
		System.out.println(d.hauteurTG(50, 4));
		System.out.println(d.longueurTG(50, 4));
		d.bob.hide();
    }
    
}