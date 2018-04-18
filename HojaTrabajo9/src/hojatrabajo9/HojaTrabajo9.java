/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//import java.lang.Object.structure5.*;

/**
 *
 * @author alber
 */
public class HojaTrabajo9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         File f;
        FileReader fr;
	BufferedReader br;
        try{
           f = new File("./freedict-eng-spa.dic");
           fr = new FileReader(f);
           br = new BufferedReader(fr);
           String linea;
           while((linea = br.readLine())!= null){
               
           }
           br.close();
           fr.close();
           f = new File("./texto.txt");
           fr = new FileReader(f);
           br = new BufferedReader(fr);
        }catch(Exception e){
            System.err.println("Se produjo un error");
        }
    }
    
}
