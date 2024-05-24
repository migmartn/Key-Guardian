package com.creators.AdminCont;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvGenera {
	public static void main(String[] args) {
        // Datos a almacenar en el archivo CSV
        String usuario = "usuario123";
        String contrasena = "contraseña123";

        // Ruta del archivo CSV
        String filePath = "credenciales.csv";

        // Llamar al método para escribir en el archivo CSV
        escribirCSV(filePath, usuario, contrasena);
    }

    public static void escribirCSV(String filePath, String usuario, String contrasena) {
        File archivo = new File(filePath);

        try {
            // Crear un FileWriter y BufferedWriter para escribir en el archivo
            FileWriter fw = new FileWriter(archivo, true); // El parámetro 'true' indica que se agregará al final del archivo existente
            BufferedWriter bw = new BufferedWriter(fw);

            // Escribir los datos en el archivo
            bw.write(usuario + "," + contrasena);
            bw.newLine(); // Nueva línea

            // Cerrar BufferedWriter
            bw.close();

            System.out.println("Datos agregados correctamente al archivo CSV.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
