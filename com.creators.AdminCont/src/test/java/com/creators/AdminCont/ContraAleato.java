package com.creators.AdminCont;

import java.security.SecureRandom;

public class ContraAleato {

    // Caracteres que se pueden usar para generar la contraseña
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";

    public static void main(String[] args) {
        // Generar una contraseña de longitud 10
        String password = generatePassword(10);
        System.out.println("Contraseña generada: " + password);
    }

    public static String generatePassword(int length) {
        StringBuilder sb = new StringBuilder(length);
        SecureRandom random = new SecureRandom();
        // Iterar para la longitud deseada
        for (int i = 0; i < length; i++) {
            // Generar un índice aleatorio para seleccionar un carácter del conjunto de caracteres disponibles
            int randomIndex = random.nextInt(CHARACTERS.length());
            // Añadir el carácter correspondiente al StringBuilder
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
}
