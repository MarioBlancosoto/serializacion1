/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mblancosoto
 */
public class Serializacion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        
        Mclase mclase = new Mclase("Ola",-7,2.7E10);
        
        escribirOb(mclase,"/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/Serializacion1/serial.txt");
        
       mclase = leerObect("/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/Serializacion1/serial.txt");
        
        System.out.println(mclase.toString());
    }
    
    public static void escribirOb(Mclase mclase,String fichero){
        
        try {
            ObjectOutputStream ruta = new ObjectOutputStream(new FileOutputStream(fichero));
            
            ruta.writeObject(mclase);
            ruta.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializacion1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Serializacion1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static Mclase leerObect(String fichero){
        
      Mclase mcla = new Mclase();
        try {
            ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(fichero));
            
           mcla =(Mclase) lectura.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializacion1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Serializacion1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serializacion1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mcla;
    }
   
}
