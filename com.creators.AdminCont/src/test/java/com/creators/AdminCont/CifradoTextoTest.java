package com.creators.AdminCont;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;
import java.security.NoSuchProviderException;
import java.util.Base64;

public class CifradoTextoTest {

    private static final String ALGORITMO = "AES";
    private static final byte[] CLAVE = new byte[]{
        // 16 bytes para AES-128. Asegúrate de usar tu propia clave.
        'm', 'i', 'G', 'n', 'i', 'm', 'a', 'R', 'T', 'A', '1', 'B', '2', 'c', '3', 'l'
    };

    public static String cifrar(String datos) throws Exception {
        Key key = new SecretKeySpec(CLAVE, ALGORITMO);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] datosCifrados = cipher.doFinal(datos.getBytes());
        return Base64.getEncoder().encodeToString(datosCifrados);
    }

    public static String descifrar(String datosCifrados) throws Exception {
        Key key = new SecretKeySpec(CLAVE, ALGORITMO);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] datosDecodificados = Base64.getDecoder().decode(datosCifrados);
        byte[] datosDescifrados = cipher.doFinal(datosDecodificados);
        return new String(datosDescifrados);
    }

    public static void main(String[] args) throws Exception {
        String nombreArchivo = "miArchivoCifrado.txt";
        String textoParaEscribir = "Este es el contenido del archivo.\n¡Hola, mundo!";
        System.out.println(textoParaEscribir);
        try {
            // Cifrar y escribir en el archivo
            String textoCifrado = cifrar(textoParaEscribir);
            System.out.println(textoCifrado);
            try (FileWriter escritor = new FileWriter(nombreArchivo)) {
                escritor.write(textoCifrado);
            }

            // Leer y descifrar contenido del archivo
            StringBuilder contenidoCifrado = new StringBuilder();
            
            try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    contenidoCifrado.append(linea);
                }
            }
            String textoDescifrado = descifrar(contenidoCifrado.toString());
            System.out.println("Texto descifrado: " + textoDescifrado);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (java.security.InvalidKeyException | java.security.NoSuchAlgorithmException
                | NoSuchProviderException | javax.crypto.BadPaddingException
                | javax.crypto.IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        }
}