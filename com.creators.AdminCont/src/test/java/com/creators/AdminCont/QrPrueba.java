package com.creators.AdminCont;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrPrueba {
	public static void main(String[] args) {
        String text = "Hola mundo txt"; // Texto o enlace que quieres codificar en el código QR
        int width = 300; // Ancho del código QR
        int height = 300; // Alto del código QR
        // Configuración del código QR
        try {
            // Configuración del formato y la corrección de errores
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.L);

            // Generar el código QR
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

            // Conversión del BitMatrix a una BufferedImage
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }

            // Mostrar la imagen del código QR usando JOptionPane
            JOptionPane.showMessageDialog(null, new ImageIcon(bufferedImage), "Código QR", JOptionPane.PLAIN_MESSAGE);

            // Borra la referencia a la imagen después de cerrar la ventana
            bufferedImage = null;

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
