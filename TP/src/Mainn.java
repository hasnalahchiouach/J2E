
public class Mainn {

	public Mainn() {

	}

	public static void main(String[] args) {		

		try {
				EntNat a1;
				try {
					a1 = new EntNat(4);
					
					System.out.println("la somme :"+a1.somme(6,5));
					System.out.println("Difference :"+a1.Difference(10,9));
					System.out.println("produit :"+a1.Produit(6,5));
					
					System.out.println(a1.somme(Integer.MAX_VALUE+1,5));
					System.out.println(a1.Difference(Integer.MAX_VALUE+8,7));
					System.out.println(a1.Produit(Integer.MAX_VALUE+1,9));
					
					
				} catch (ErrConst e) {
					System.out.println(e.getMessage());				}
					
			} catch (ErrNat e) {
						System.out.println(e.getMessage());
					}
				
				
			
	}

}
