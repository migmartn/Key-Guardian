package com.creators.AdminCont;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class Cifrado {
	
    private static final String ALGORITMO = "AES";
    private static final byte[] CLAVE = new byte[]{
        // 16 bytes para AES-128. Asegúrate de usar tu propia clave.
        'm', 'i', 'G', 'n', 'i', 'm', 'a', 'R', 'T', 'A', '1', 'B', '2', 'c', '3', 'l'
    };

    
    public static String cifrar(String datos ) throws Exception {
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
	
}
