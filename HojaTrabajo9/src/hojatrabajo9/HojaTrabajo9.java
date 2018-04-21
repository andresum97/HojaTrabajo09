/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
//import java.lang.Object.structure5.*;

/**
 *
 * @author Andres Urizar
 * @author Rodrrigo Morales
 */
public class HojaTrabajo9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> mensajeTraducido = new ArrayList<String>();
        boolean x = true;
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        SplayBST<String,String> arbol1 = null; 
        RedblackTree<String,String> arbol2 = null; 
        System.out.println("Bienvenido a nuestro diccionario");
        /*Toma de datos*/
        while(x){
        System.out.println("Escoja la forma de guardar el diccionario");
        System.out.println("1.Splay Tree\n 2.Red Black Tree");
        int op = sc.nextInt();
            switch (op) {   //Factory para Splay Tree o Red Black Tree
                case 1:
                    {
                        arbol1 = new SplayBST<>();
                        opcion = 1;
                        System.out.println("Ha elegido SplayTree"); 
                        x = false;
                        break;
                    }
                case 2:
                    {
                        arbol2 = new RedblackTree<>();
                        System.out.println("Ha elegido Red Black Tree");
                        opcion = 2;
                        x = false;
                        break;
                    }
                default:
                    System.out.println("Ha ingresado una opcion que no es valida");
                    break;
            }
        }      
        File f;
        FileReader fr;
	BufferedReader br;
        try{
           //====================Ingresar el diccionario======================
           f = new File("./freedict-eng-spa.txt");
           fr = new FileReader(f);
           br = new BufferedReader(fr);
           String linea;
           StringBuilder separador = new StringBuilder();
           String segunda = ""; //String para buscar el valor
           String llave = "";
           String valor = "";
           while((linea = br.readLine())!= null){
               separador.append(linea);
               separador.append(System.lineSeparator());
               linea += " ";
               for(int i=1;i<linea.length();i++){
                   String temp = linea.substring((i-1),i);  //Para verificar cada caracter de la linea
                   if(temp.equals("\t")){
                       llave = linea.substring(0,i-1).toUpperCase(); //Se obtiene la palabra en ingles
                       segunda = linea.substring(i,linea.length()).toUpperCase();
                       for(int j=1;j<segunda.length();j++){
                           String temp2 = segunda.substring((j-1),j);
                           if(temp2.equals(";")||temp2.equals(",")){
                               valor = segunda.substring(0,j-1).toUpperCase();
                               break;
                           }else{
                               valor = segunda;
                           }
                       }
                       //System.out.println(llave+","+valor); //Dependiendo de la opcion elegida ingresa el diccionario
                       if(opcion==1){
                           arbol1.put(llave, valor);
                           System.out.println(llave+","+valor+" INGRESADO"); 
                       }else{
                           arbol2.put(llave, valor);
                           System.out.println(llave+","+valor+" INGRESADO"); 
                       }       
                   }
               }
           }
           br.close();
           fr.close();
           //=============================Ingresar la oracion con archivo de texto==============
           f = new File("./texto.txt");
           fr = new FileReader(f);
           br = new BufferedReader(fr);
           String linea2;
           while((linea2= br.readLine())!= null){
               linea2 = linea2.replaceAll("[()]", ""); //Para quitar los parentesis de la linea
               System.out.println(linea2);
               String word = "";
               String s = "";
               for (int i=0; i<linea2.length();i++){
                  if ((!" ".equals(linea2.substring(i, i+1))) 
                          && (!".".equals(linea2.substring(i, i+1)))){
                    word = word + linea2.substring(i, i+1); 
                  } else {
                       if(opcion==1){
                           if (arbol1.contains(word.toUpperCase())){
                                s = arbol1.get(word.toUpperCase());
                                mensajeTraducido.add(s);
                           } else{
                               mensajeTraducido.add(word);
                           }
                       }else{
                        if (arbol2.contains(word.toUpperCase())){
                          s=  arbol2.get(word.toUpperCase());
                          mensajeTraducido.add(s);
                        }else {
                            mensajeTraducido.add(word);
                        }
                       }
                      
                      word ="";
                  }
               }
               
               linea2 ="";
           for (int i=0;i<mensajeTraducido.size();i++){
               linea2 = linea2 +" "+mensajeTraducido.get(i);
           }
               System.out.println(linea2);         
           }
           
           br.close();
           fr.close();
        }catch(Exception e){
            System.err.println("Se produjo un error");
        }
    }
    
}
