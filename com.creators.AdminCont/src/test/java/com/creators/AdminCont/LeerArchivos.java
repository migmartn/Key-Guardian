package com.creators.AdminCont;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeerArchivos {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String rutaArchivo = "usuario.txt"; // Ajusta la ruta del archivo según sea necesario

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] valores = linea.split(","); // Cambia el delimitador si es necesario

                if (valores.length == 2) {
                   String valor1 = valores[0].trim(); // Elimina espacios en blanco alrededor del valor
                    String  valor2 = valores[1].trim(); // Elimina espacios en blanco alrededor del valor

                    System.out.println("Valor 1: " + valor1);
                    System.out.println("Valor 2: " + valor2);
                     
                    System.out.println("contrasena");
                    String contrasena = scanner.nextLine();
                    System.out.println("usuario");
                    String usuariov = scanner.nextLine();
                    
                    //------login
                    if(contrasena.equals(valor2) && usuariov.equals(valor1)) {
                    	System.out.print("ingreso");
                    }
                    else {
                    	System.out.print("no ingreso");
                    }
                } else {
                    System.err.println("La línea no contiene dos valores separados por coma.");
                }
                //----
            }
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + rutaArchivo);
            e.printStackTrace();
        }
        
        
        //--------------------------------------------
       
	}

}
