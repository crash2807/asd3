/*
author: Piotr Jarzyński
S17041
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class s17041 {
	static Ciag P;
	static int liczbaelementow;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner skaner=new Scanner(new File(args[0]));
		Ciag F;
		int liczbaoperacji=skaner.nextInt();
		liczbaelementow=0;
		 P=new Ciag();
	     F=P;
		while(skaner.hasNextInt()) {
			P.wartosc=skaner.nextInt();
			if(skaner.hasNextInt()) {
			P.nastepny=new Ciag();
			P=P.nastepny;
			}
			liczbaelementow++;
		}
		skaner.close();
		P.nastepny=F;
		P=F;
		for(int i=0;i<liczbaoperacji;i++) {
			
			if(P.wartosc%2==0) {
				delete();
			}else {
				add();
				
			}
			
			
		}
		int i=0;
		 while(liczbaelementow>0) {
			 System.out.print(P.wartosc+" ");
			 P=P.nastepny; 
			 liczbaelementow--;
			 if(i==24) {
				 System.out.println();
				 i=0;
			 }
			 i++;
		 }
	

	}
	 static void add() {
	Ciag tmp;
	tmp=P.nastepny;
	P.nastepny=new Ciag();
	P.nastepny.wartosc=P.wartosc-1;
	P.nastepny.nastepny=tmp;
	liczbaelementow++;
	int przesuniecia=0;
	if(liczbaelementow!=0) 
		 przesuniecia=P.wartosc%liczbaelementow;

		while(przesuniecia>0) {
			P=P.nastepny;
			przesuniecia--;
		}
		
		
		
	}
	 static void delete(){
		Ciag tmp;
		tmp=P.nastepny;
		P.nastepny=P.nastepny.nastepny;
		liczbaelementow--;
		int przesuniecia=0;
		if(liczbaelementow!=0)
		 przesuniecia=tmp.wartosc%liczbaelementow;
		
		while(przesuniecia>0) {
			P=P.nastepny;
			przesuniecia--;
		}
		
	
	}


}
   class Ciag {
	   int wartosc;
	   Ciag nastepny;
	   
	    Ciag(){
	    	
	    	
	    }
	   
	   
   }
