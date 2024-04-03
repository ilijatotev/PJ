import java.util.Scanner;

import inflacija.Preskupo;
import turizam.Put;
import turizam.Zimovanje;
import turizam.Letovanje; //mogao sam i turizam.*

public class MainClass {

	public static void main(String[] args) {
		
		Agencija<Put> agencija = new Agencija<>();
		
		Scanner tastatura = new Scanner(System.in);
		System.out.println("broj putovanja agencije: ");
		int brojputovanja = Integer.parseInt(tastatura.nextLine());
		
		for(int i=0;i<brojputovanja;i++)
		{
			System.out.println("tip putovanja: ");
			String tipP = tastatura.nextLine();
			if (tipP.equals("z")) {
				System.out.println("ime putovanja: ");
				String dest = tastatura.nextLine();
				System.out.println("broj dana: ");
				int brd = Integer.parseInt(tastatura.nextLine());
				System.out.println("cena po danu: ");
				double cpd = Double.parseDouble(tastatura.nextLine());
				System.out.println("cena ski pasa po danu: ");
				double cpds = Double.parseDouble(tastatura.nextLine());
				agencija.dodajPut(new Zimovanje(dest,brd,cpd,cpds));
		}
			else 
		{
				System.out.println("ime putovanja: ");
				String dest = tastatura.nextLine();
				System.out.println("broj dana: ");
				int brd = Integer.parseInt(tastatura.nextLine());
				System.out.println("cena po danu: ");
				double cpd = Double.parseDouble(tastatura.nextLine());
				agencija.dodajPut(new Letovanje(dest,brd,cpd));
		}
		
		}

		try {agencija.uvediRed();}
		catch(Preskupo izuz) {System.out.println("Izbacen je izuzetak preskupo: " + izuz);}
	}
}
