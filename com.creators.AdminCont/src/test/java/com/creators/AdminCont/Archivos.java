package com.creators.AdminCont;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Archivos {

	public static void main(String[] args) {
		String usuario = null, contrsena = null;
		Scanner scanner = new Scanner(System.in);

		System.out.println("usuario");
		usuario = scanner.nextLine();
		System.out.println("contrasena");
		contrsena = scanner.nextLine();
		
		
		//-------------------------------------------------------------------------
        FileWriter writer = null;
        try {
            writer = new FileWriter("datos.txt");
            
			writer.write(usuario);
			writer.write(",");
			writer.write(contrsena);
            System.out.println("Se escribió correctamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Ocurrió un error al cerrar el archivo.");
                e.printStackTrace();
            }

	}
        
        //-------------------------------------------------------------------
        
        

	}
}
