package turizam;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.FileNotFoundException; secam se da smo na vezbama spominjali ali kapiram da mi ne treba kad pravim novi fajl u koji treba da upisem nesto

public class Zimovanje implements Put, Comparable<Put> {
	private String destinacija;
	private int brDana;
	private double cenaPD;
	private double cenaSPD;
	
	public Zimovanje(String dest, int brd, double cpd, double cspd) 
	{
		this.destinacija=dest;
		this.brDana=brd;
		this.cenaPD=cpd;
		this.cenaSPD=cspd;
	}
	
	public double vratiCenu()  //ne znam da li da dodam exception ovde ili ne jer u tekstu pise racuna se da zimovanje nece da bude krace od 2 dana
	{
		return (brDana*cenaPD)+(cenaSPD*(brDana-2)); //ne kapiram da li treba ukupna cena -2 dana ili samo ski pas se dva dana dobija gratis
	}

	public void upisiObjekat() throws IOException
	{	
		try (FileWriter f = new FileWriter(Double.toString(this.vratiCenu()) + ".txt")) {
			BufferedWriter b = new BufferedWriter(f);
			b.write(destinacija.split(" ")[0]);
			b.close();
		} catch (IOException izuz) {System.out.println("Output izuzetak se pojavio" + izuz);}
	}
	
	public void upisiUBin() throws IOException{
		FileOutputStream fos = new FileOutputStream("ekskluziva.bin");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		
		dos.writeDouble(this.vratiCenu());		
		dos.close();
	}
	
	public int compareTo(Put put1)
	{
		return Double.compare(this.vratiCenu(), put1.vratiCenu());	
	}
	
}
