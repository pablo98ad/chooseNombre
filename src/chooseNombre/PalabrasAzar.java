package chooseNombre;

import java.util.ArrayList;

public class PalabrasAzar {
	
	private ArrayList<String> historialPalabras;
	private String palabraActual; 
	
	public PalabrasAzar() {
		this.historialPalabras= new ArrayList<String>();
	}
	
	public String getPalabraActual() throws Exception {
		String returr;
		if(this.palabraActual!=null) {
			returr=this.palabraActual;
			
		}else {
			throw new Exception();
		}
		return this.palabraActual;
	}
	
	public String nuevaPalabra() {
		String palabra= generadorNombresBasico();
		this.palabraActual=palabra;
		this.historialPalabras.add(palabra);
		
		return palabra;
	}
	
	public String anteriorPalabra() {
		String anteriorP = null;
		if(this.historialPalabras.size()>1) {
			anteriorP= this.historialPalabras.get(this.historialPalabras.size()-2);
			palabraActual=anteriorP;
			if(this.historialPalabras.size()>2) {
				this.historialPalabras.remove(this.historialPalabras.size()-1);
			}
		}else {
			//anteriorP="Error";
		}
		
		return anteriorP;
	}
	
	public boolean estaPalabraYa(String p) {
		boolean esta=false;
		p=p.toLowerCase();
		
		for (int i=0; i<this.historialPalabras.size();i++) {
			if(p.equals(this.historialPalabras.get(i))) {
				esta=true;
				
			}
			
		}
		
		
		return esta;
	}
	
	
	private static String generadorNombresBasico() {
		String [] consT= {"b","c","d","f","g","h","j","k","l","m","o","p","q",
				"r","s","t","v","w","x","y","z","ñ","ch","cr","fr","gr","tr","ll"};
		String [] vocT= {"a","e","i","o","u"};
		String[] palabra;
		String word="";
		int numAlc, numAlv,longPala,cualChar;
		
		longPala=(int)((Math.random()*4)+4);//
		palabra= new String[longPala];
			
		cualChar= (int)(Math.random()*2);//dejamos al 50 % de suerte si pone un caracter o vocal
		for (int i=0; i<longPala; i++) {//generamos la palabra
				
			if (cualChar==0) {
				if (i!=(longPala-1)) {//para que no incluya las palabras compuestas al final ejem cr
					numAlc= (int)(Math.random()*consT.length);
					palabra[i]= consT[numAlc];
					cualChar=1;
				}else {
					numAlc= (int)((Math.random()*(consT.length-6)));
					palabra[i]= consT[numAlc];
					cualChar=1;
				}
					
				}else {
					numAlv= (int)(Math.random()*vocT.length);
					palabra[i]= vocT[numAlv];
					cualChar=0;
				}
			
			}
		for (int i=0; i< palabra.length;i++) {
			word= word+palabra[i];
		}
		//word=word.toUpperCase();	//si lo queremos poner en mayusculas
		return word;
		
	}

}
