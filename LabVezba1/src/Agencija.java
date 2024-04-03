import java.util.ArrayList;
import java.io.*;
import java.util.Collections;

import inflacija.Preskupo;
import turizam.Put;

public class Agencija<T extends Put> {

	private ArrayList<T> putevi;
	
	public Agencija() {
		putevi = new ArrayList<>();
	}

	public void dodajPut(T put) {
		putevi.add(put);
	}
	
	public void uvediRed() throws Preskupo {
		if (putevi.isEmpty())
			{System.out.println("prazan niz puteva"); //ovde je bolje da se napravi jos jedan exception da baca
			return;
			}
		
		putevi.sort(null);
		T last=putevi.get(putevi.size()-1);
		if (last.vratiCenu()>2000)
			throw new Preskupo("Cena je prevelika, nema upisa");
		else
		{
		for (int i=0;i<putevi.size();i++)
		{
			try {
				putevi.get(i).upisiObjekat();
			} catch (IOException izuz) {
				System.out.println("Output izuzetak se pojavio" + izuz);
			}
		}
		try {
			last.upisiUBin();
		} catch (IOException izuz) {
			System.out.println("Output izuzetak se pojavio" + izuz);
		}
		
		}
	}
	


}
