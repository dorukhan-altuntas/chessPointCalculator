//Dorukhan Altuntas
//Not: Koddaki degisken isimlerini ve aciklamalari bilerek Turkce sekilde yaptim soru Turkce oldugu icin.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		String inputFile=args[0]; // Kullanicidan okur  ( Kullanimi Command Line'dan: javac Main.java (Enter) java Main board1.txt )
	    File file = new File(inputFile);
	//    File file = new File("8.satiri kaldirip burayi acarsaniz buraya dosya path'ini vererek calistirabilirsiniz");
	    Scanner sc = new Scanner(file);
	    Tas[][] chessboard = new Tas[8][8];  //Tahtayi tanimladim double array 8x8
	    
	    
	    int i=0;
	    int j=0;
	    while (sc.hasNext()) {      // Dosyayi bosluklara bakarak okudum
	    	
	    	String tas=sc.next();
		    char type=tas.charAt(0);       //tas tipi
		    char c=tas.charAt(1);
		    String color=c+"";             //tas rengi
		    
		  
		    if(type=='p') {                            //Harfe göre obje olusturdum.
		    	Tas p1=new Tas("piyon",color,1);
		    	  chessboard[i][j] =p1;      
		    }
		    else if(type=='a') {
		    	Tas a1=new Tas("at",color,3);
		    	chessboard[i][j] =a1;
		    }
		    
	        else if(type=='f') {
	        	Tas f1=new Tas("fil",color,3);
	        	chessboard[i][j] =f1;
		    }
		    
	        else if(type=='k') {
	        	Tas k1=new Tas("kale",color,5);
	        	chessboard[i][j] =k1;
		    }
		    
	        else if(type=='v') {
	        	Tas v1=new Tas("vezir",color,9);
	        	chessboard[i][j] =v1;
		    }
		    
	        else if(type=='s') {
	        	Tas s1=new Tas("sah",color,100);
	        	chessboard[i][j] =s1;
		    }
	        else {
	        	Tas bos=new Tas("","",0);
	        	chessboard[i][j] =bos;
	        }
		    
		  
		    
	    	j++;
	    	if(j==8) {                   //Dongu kontrolunu saglamak adina 
	    		j=0;
	    		i++;
	    	}
	    }
	    
       
	    
	    for (int loop1 = 0; loop1 < chessboard.length; loop1++) {
	    	 
           
            for (int loop2 = 0; loop2 < chessboard[loop1].length; loop2++) {            //Tum array i dolasirken piyon, at ve vezir icin isgal edilen kisimlari ayarladim
               // System.out.print(chessboard[loop1][loop2] + " ");
	    
            	if(chessboard[loop1][loop2].getType().equalsIgnoreCase("piyon") ) { //Tip piyonsa
            		
            		if(chessboard[loop1][loop2].getColor().equalsIgnoreCase("b")) { // beyazsa
            			if(loop2-1>=0 && chessboard[loop1-1][loop2-1].getColor().equalsIgnoreCase("s")) { //sol capraz kontrolu (isgal tasi siyahsa)
            				chessboard[loop1-1][loop2-1].setIsgal(true);
            			}
            			 if(loop2+1<=7 && chessboard[loop1-1][loop2+1].getColor().equalsIgnoreCase("s")) { //sag capraz kontrolu (isgal tasi siyahsa)
            				 chessboard[loop1-1][loop2+1].setIsgal(true);
            			 }
            		}
            		else if(chessboard[loop1][loop2].getColor().equalsIgnoreCase("s")) { //siyahsa
            			if(loop2-1>=0 && chessboard[loop1+1][loop2-1].getColor().equalsIgnoreCase("b")) { //sol capraz kontrolu (isgal tasi beyazsa)
            				chessboard[loop1+1][loop2-1].setIsgal(true);
            			}
            			 if(loop2+1<=7 && chessboard[loop1+1][loop2+1].getColor().equalsIgnoreCase("b")) {//sag capraz kontrolu (isgal tasi beyazsa)
            				 chessboard[loop1+1][loop2+1].setIsgal(true);
            			 }
            		}
            		
            	}
            	
            	else if(chessboard[loop1][loop2].getType().equalsIgnoreCase("at")) { //Atsa
            		
            		if(chessboard[loop1][loop2].getColor().equalsIgnoreCase("b")) { //Rengi beyazsa
            			if(loop1-1>=0 && loop2-2>=0 && chessboard[loop1-1][loop2-2].getColor().equalsIgnoreCase("s")) { // Burada tek tek atin hareketi olan 8 durumu kontrol ettim.
            				chessboard[loop1-1][loop2-2].setIsgal(true);
            			}
                        if(loop1-1>=0 && loop2+2<=7 && chessboard[loop1-1][loop2+2].getColor().equalsIgnoreCase("s")) {
                        	chessboard[loop1-1][loop2+2].setIsgal(true);
                        }
                        if(loop1+1<=7 && loop2-2>=0 && chessboard[loop1+1][loop2-2].getColor().equalsIgnoreCase("s")) {
                        	chessboard[loop1+1][loop2-2].setIsgal(true);
                        }
                        if(loop1+1<=7 && loop2+2<=7 && chessboard[loop1+1][loop2+2].getColor().equalsIgnoreCase("s")) {
                        	chessboard[loop1+1][loop2+2].setIsgal(true);
                        }
                        if(loop1-2 >=0 && loop2-1>=0 && chessboard[loop1-2][loop2-1].getColor().equalsIgnoreCase("s")) {
                        	chessboard[loop1-2][loop2-1].setIsgal(true);
                        }
                        if(loop1-2>=0 && loop2+1<=7 && chessboard[loop1-2][loop2+1].getColor().equalsIgnoreCase("s")) {
                        	chessboard[loop1-2][loop2+1].setIsgal(true);
                        }
                        if(loop1+2<=7 && loop2-1>=0 && chessboard[loop1+2][loop2-1].getColor().equalsIgnoreCase("s")) {
                        	chessboard[loop1+2][loop2-1].setIsgal(true);
                        }
                        if(loop1+2<=7 && loop2+1<=7 && chessboard[loop1+2][loop2+1].getColor().equalsIgnoreCase("s")) {
                        	chessboard[loop1+2][loop2+1].setIsgal(true);
                        }
            			
            		}
            		
            		else if(chessboard[loop1][loop2].getColor().equalsIgnoreCase("s")) { //Aynisini siyah renk olan at icin de baktim.
            			if(loop1-1>=0 && loop2-2>=0 && chessboard[loop1-1][loop2-2].getColor().equalsIgnoreCase("b")) {
            				chessboard[loop1-1][loop2-2].setIsgal(true);
            			}
                        if(loop1-1>=0 && loop2+2<=7 && chessboard[loop1-1][loop2+2].getColor().equalsIgnoreCase("b")) {
                        	chessboard[loop1-1][loop2+2].setIsgal(true);
                        }
                        if(loop1+1<=7 && loop2-2>=0 && chessboard[loop1+1][loop2-2].getColor().equalsIgnoreCase("b")) {
                        	chessboard[loop1+1][loop2-2].setIsgal(true);
                        }
                        if(loop1+1<=7 && loop2+2<=7 && chessboard[loop1+1][loop2+2].getColor().equalsIgnoreCase("b")) {
                        	chessboard[loop1+1][loop2+2].setIsgal(true);
                        }
                        if(loop1-2 >=0 && loop2-1>=0 && chessboard[loop1-2][loop2-1].getColor().equalsIgnoreCase("b")) {
                        	chessboard[loop1-2][loop2-1].setIsgal(true);
                        }
                        if(loop1-2>=0 && loop2+1<=7 && chessboard[loop1-2][loop2+1].getColor().equalsIgnoreCase("b")) {
                        	chessboard[loop1-2][loop2+1].setIsgal(true);
                        }
                        if(loop1+2<=7 && loop2-1>=0 && chessboard[loop1+2][loop2-1].getColor().equalsIgnoreCase("b")) {
                        	chessboard[loop1+2][loop2-1].setIsgal(true);
                        }
                        if(loop1+2<=7 && loop2+1<=7 && chessboard[loop1+2][loop2+1].getColor().equalsIgnoreCase("b")) {
                        	chessboard[loop1+2][loop2+1].setIsgal(true);
                        }
            			
            		}
            		
            	}
            	else if(chessboard[loop1][loop2].getType().equalsIgnoreCase("vezir")) { //Vezirse
            		if(chessboard[loop1][loop2].getColor().equalsIgnoreCase("b")) { //beyazsa
            			int k=loop1;
            			int sayac=1;
            			while(k-1>=0 && chessboard[loop1-sayac][loop2].getType().equalsIgnoreCase("")) { // Bu while ve alttaki if vezirin yukari yonde hareketini kontrol ediyor.Bosken gidiyor
            				k--;                                                                        //Tas gelirse veya tahta biterse durar.
            				sayac++;
            			}
            			if(k-1>=0 && chessboard[loop1-sayac][loop2].getColor().equalsIgnoreCase("s")) {
            				chessboard[loop1-sayac][loop2].setIsgal(true);
            			}
            			
            			k=loop1;
            			sayac=1;
            			while(k+1<=7 && chessboard[loop1+sayac][loop2].getType().equalsIgnoreCase("")) { // Vezirin asagi gittigi durum
            				k++;
            				sayac++;
            			}
            			if(k+1<=7 && chessboard[loop1+sayac][loop2].getColor().equalsIgnoreCase("s")) {
            				chessboard[loop1+sayac][loop2].setIsgal(true);
            			}
            			
            			k=loop2;
            			sayac=1;
            			while(k-1>=0 && chessboard[loop1][loop2-sayac].getType().equalsIgnoreCase("")) { // Bu while ve alttaki if vezirin sol yonde hareketini kontrol ediyor.
            				k--;
            				sayac++;
            			}
            			if(k-1>=0 && chessboard[loop1][loop2-sayac].getColor().equalsIgnoreCase("s")) {
            				chessboard[loop1][loop2-sayac].setIsgal(true);
            			}
            			
            			k=loop2;
            			sayac=1;
            			while(k+1<=7 && chessboard[loop1][loop2+sayac].getType().equalsIgnoreCase("")) { // Vezirin saga gittigi durum
            				k++;
            				sayac++;
            			}
            			if(k+1<=7 && chessboard[loop1][loop2+sayac].getColor().equalsIgnoreCase("s")) {
            				chessboard[loop1][loop2+sayac].setIsgal(true);
            			}
            			
            			int capraz1=loop1;
            			int capraz2=loop2;
            			sayac=1;
            			while(capraz1-1>=0 && capraz2-1>=0 && chessboard[loop1-sayac][loop2-sayac].getType().equalsIgnoreCase("") ) { // Bu ve altindaki vezirin yukari ve sol capraz
            				capraz1--;
            				capraz2--;
            				sayac++;
            			}
            			if((capraz1-1>=0 && capraz2-1>=0 && chessboard[loop1-sayac][loop2-sayac].getColor().equalsIgnoreCase("s"))) {
            				chessboard[loop1-sayac][loop2-sayac].setIsgal(true);
            			}
            			
            			
            			
            			 capraz1=loop1;
            			 capraz2=loop2;
            			sayac=1;
            			while(capraz1-1>=0 && capraz2+1<=7 && chessboard[loop1-sayac][loop2+sayac].getType().equalsIgnoreCase("") ) { // Bu ve altindaki vezirin yukari ve sag capraz
            				capraz1--;
            				capraz2++;
            				sayac++;
            			}
            			if((capraz1-1>=0 && capraz2+1<=7 && chessboard[loop1-sayac][loop2+sayac].getColor().equalsIgnoreCase("s"))) {
            				chessboard[loop1-sayac][loop2+sayac].setIsgal(true);
            			}
            			
            			
            			capraz1=loop1;
           			 capraz2=loop2;
           			sayac=1;
           			while(capraz1+1<=7 && capraz2-1>=0 && chessboard[loop1+sayac][loop2-sayac].getType().equalsIgnoreCase("") ) { // Bu ve altindaki vezirin asagi ve sol capraz
        				capraz1++;
        				capraz2--;
        				sayac++;
        			}
        			if((capraz1+1<=7 && capraz2-1>=0 && chessboard[loop1+sayac][loop2-sayac].getColor().equalsIgnoreCase("s"))) {
        				chessboard[loop1+sayac][loop2-sayac].setIsgal(true);
        			}
        			
        			 capraz1=loop1;
        			 capraz2=loop2;
        			sayac=1;
        			while(capraz1+1<=7 && capraz2+1<=7 && chessboard[loop1+sayac][loop2+sayac].getType().equalsIgnoreCase("") ) { // Bu ve altindaki vezirin asagi ve sag capraz
        				capraz1++;
        				capraz2++;
        				sayac++;
        			}
        			if((capraz1+1<=7 && capraz2+1<=7 && chessboard[loop1+sayac][loop2+sayac].getColor().equalsIgnoreCase("s"))) {
        				chessboard[loop1+sayac][loop2+sayac].setIsgal(true);
        			}
            			
            		}
            		
            		
            		
            	}
            	         	
            	
            }
            
	    }
	    
	    double siyahPuan=0; //Puan hesaplama kismi
	    double beyazPuan=0;
	    for (int loop1 = 0; loop1 < chessboard.length; loop1++) {
	    	
	    	for (int loop2 = 0; loop2 < chessboard[loop1].length; loop2++) {  
            	if(chessboard[loop1][loop2].getColor().equalsIgnoreCase("b")) { //Beyazlar icin baktim.
            		if(chessboard[loop1][loop2].isIsgal()==true) {             //Isgallik durumu kontrolu
       
            			beyazPuan=beyazPuan+(double)chessboard[loop1][loop2].getValue()/2;  //Isgalse yarisini aldim.
            		}
            		else if(chessboard[loop1][loop2].isIsgal()==false) {
            			beyazPuan=beyazPuan+chessboard[loop1][loop2].getValue();
            		}
            	}
            	else if(chessboard[loop1][loop2].getColor().equalsIgnoreCase("s")) { //Siyah Puan kontrol
            		if(chessboard[loop1][loop2].isIsgal()==true) { //Isgal Kontrol
            		
            			siyahPuan=siyahPuan+(double)chessboard[loop1][loop2].getValue()/2;
            		}
            		else if(chessboard[loop1][loop2].isIsgal()==false) {
            			siyahPuan=siyahPuan+chessboard[loop1][loop2].getValue();
            		}
            	}
            		
            }
            }
	 
	if(beyazPuan%1==0) { //Bunu yapmam sebebim sonu 0 ile bitiyorsa direk int olarak yazmak. Soruda cevaplar o sekildeydi. Ornek 100.0 yerine 100 yazsin istedim.
		 System.out.println("Beyaz:"+(int)beyazPuan);
	}
	else {
		  System.out.println("Beyaz:"+beyazPuan);
	}
	
	if(siyahPuan%1==0) {
		 System.out.println("Siyah:"+(int)siyahPuan);
	}
	else {
		  System.out.println("Siyah:"+siyahPuan);
	}

	sc.close();
	
	}
	
}
