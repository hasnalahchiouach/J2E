
public class EntNat {
private int nb ;

public EntNat(int nb)throws ErrConst {
	if(nb < 0) throw new ErrConst("inferieur a 0 ");
	this.nb = nb;
	
}

public int getNb() {
	return nb; 
}

public static int somme (int a , int b ) throws ErrSom {
	if(a+b<0) throw new ErrSom("addition superieure de la valeur maximum");
	return a+b;
}

public static int Difference (int a , int b ) throws ErrDiff{
	if(a-b<0 && a>b) throw new ErrDiff("difference sup de la valeur maximum");
	return a-b;
	
}

public static int Produit (int a , int b ) throws ErrProd{
	if(a*b<0) throw new ErrProd("produit supe de la valeur maximum");
	return a*b;
	
}
}