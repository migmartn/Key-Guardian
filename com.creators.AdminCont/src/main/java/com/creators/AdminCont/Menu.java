package com.creators.AdminCont;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField contraGene;
	private JTextField usuarioGuard;
	private JTextField contraGuard;
	public String password;
	public String userInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\workspaceEclipce\\com.creators.AdminCont\\Logo.png"));
		setTitle("KEY GUARDIAN");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 59, 256, 502);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Generador de contraseñas");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(27, 21, 192, 17);
		panel.add(lblNewLabel_3);
		
		JComboBox tamano = new JComboBox();
		tamano.setModel(new DefaultComboBoxModel(new String[] {"8 Caracteres", "12 Caracteres", "16 Caracteres"}));
		tamano.setBackground(new Color(255, 255, 255));
		tamano.setBounds(71, 49, 118, 22);
		panel.add(tamano);
		
		JComboBox caracter = new JComboBox();
		caracter.setModel(new DefaultComboBoxModel(new String[] {"Aleatoria", "Seleccionar caracters"}));
		caracter.setBackground(new Color(255, 255, 255));
		caracter.setBounds(71, 83, 118, 22);
		panel.add(caracter);
		
		JButton generar = new JButton("Generar");
		
		
		
		generar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String tamanoO = (String) tamano.getSelectedItem();
				 String caracterO = (String) caracter.getSelectedItem();
				 
				 
				 if(tamanoO ==  "8 Caracteres" && caracterO == "Aleatoria") {
					 password = generatePassword(8);
					 contraGene.setText(""+password);
				 }
				 if(tamanoO ==  "12 Caracteres" && caracterO == "Aleatoria") {
					 password = generatePassword(12);
					 contraGene.setText(""+password);
				 }
				 if(tamanoO ==  "16 Caracteres" && caracterO == "Aleatoria") {
					 password = generatePassword(16);
					 contraGene.setText(""+password);
				 }
				 
				 
				 //============================================================
				 
				 
				 
				 if(tamanoO ==  "8 Caracteres" && caracterO == "Seleccionar caracters") {
					 SwingUtilities.invokeLater(() -> {
				            // Creamos un JTextField con límite de caracteres
				            JTextField textField = new JTextField(8);

				            // Mostramos el diálogo de entrada personalizado
				            int result = JOptionPane.showConfirmDialog(null, textField, "Ingrese hasta 8 caracteres:",
				                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

				            if (result == JOptionPane.OK_OPTION) {
				                 userInput = textField.getText();
				                 password = generatePasswordIngreso(8);
								 contraGene.setText(""+password);
				            }
					 });
					 
				 }
				 if(tamanoO ==  "12 Caracteres" && caracterO == "Seleccionar caracters") {
					 SwingUtilities.invokeLater(() -> {
				            // Creamos un JTextField con límite de caracteres
				            JTextField textField = new JTextField(12);

				            // Mostramos el diálogo de entrada personalizado
				            int result = JOptionPane.showConfirmDialog(null, textField, "Ingrese hasta 12 caracteres:",
				                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

				            if (result == JOptionPane.OK_OPTION) {
				                 userInput = textField.getText();
				                 password = generatePasswordIngreso(12);
								 contraGene.setText(""+password);
				            }
					 });
				 }
				 if(tamanoO ==  "16 Caracteres" && caracterO == "Seleccionar caracters") {
					 SwingUtilities.invokeLater(() -> {
				            // Creamos un JTextField con límite de caracteres
				            JTextField textField = new JTextField(16);

				            // Mostramos el diálogo de entrada personalizado
				            int result = JOptionPane.showConfirmDialog(null, textField, "Ingrese hasta 16 caracteres:",
				                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

				            if (result == JOptionPane.OK_OPTION) {
				                 userInput = textField.getText();
				                 password = generatePasswordIngreso(16);
								 contraGene.setText(""+password);
				            }
					 });
					 //====
					 
				 }
			}
		});
		generar.setBackground(new Color(255, 255, 255));
		generar.setBounds(81, 116, 89, 23);
		panel.add(generar);
		
		JLabel lblNewLabel_4 = new JLabel("Contraseña generada: ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(64, 153, 136, 14);
		panel.add(lblNewLabel_4);
		
		contraGene = new JTextField();
		contraGene.setBackground(new Color(255, 255, 255));
		contraGene.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		contraGene.setForeground(new Color(0, 0, 0));
		contraGene.setHorizontalAlignment(SwingConstants.CENTER);
		contraGene.setEditable(false);
		contraGene.setBounds(46, 178, 173, 20);
		panel.add(contraGene);
		contraGene.setColumns(10);
		
		JButton qrboton = new JButton("");
		qrboton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qrboton();
			}
		});
		qrboton.setBackground(new Color(255, 255, 255));
		qrboton.setIcon(new ImageIcon("D:\\workspaceEclipce\\com.creators.AdminCont\\qrcode_scan_icon_136286.png"));
		qrboton.setBounds(71, 209, 36, 35);
		panel.add(qrboton);
		
		JButton copiar = new JButton("");
		copiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Copiar();
			}
		});
		copiar.setBackground(new Color(255, 255, 255));
		copiar.setIcon(new ImageIcon("D:\\workspaceEclipce\\com.creators.AdminCont\\copy.png"));
		copiar.setBounds(136, 209, 36, 35);
		panel.add(copiar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(263, 59, 256, 502);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setIcon(new ImageIcon("D:\\workspaceEclipce\\com.creators.AdminCont\\CENT.png"));
		lblNewLabel_8.setBounds(10, 11, 236, 288);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("AGREGAR CUENTA NUEVA");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(39, 321, 185, 14);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_5_1 = new JLabel("________________________________________");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setBounds(0, 296, 256, 14);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_10 = new JLabel("USUARIO: ");
		lblNewLabel_10.setBounds(39, 372, 89, 14);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("CONTRASEÑA: ");
		lblNewLabel_11.setBounds(39, 397, 89, 14);
		panel_1.add(lblNewLabel_11);
		
		JButton guardar = new JButton("REGISTRAR");
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = usuarioGuard.getText();
		        String contrasena = contraGuard.getText();

		        // Ruta del archivo CSV
		        String filePath = "credenciales.csv";
		        
		        // Llamar al método para escribir en el archivo CSV
		        escribirCSV(filePath, usuario, contrasena);
			}
		});
		guardar.setBackground(new Color(255, 255, 255));
		guardar.setBounds(80, 443, 102, 23);
		panel_1.add(guardar);
		
		usuarioGuard = new JTextField();
		usuarioGuard.setBounds(130, 369, 86, 20);
		panel_1.add(usuarioGuard);
		usuarioGuard.setColumns(10);
		
		contraGuard = new JTextField();
		contraGuard.setBounds(130, 394, 86, 20);
		panel_1.add(contraGuard);
		contraGuard.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(526, 59, 256, 502);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setBounds(10, 49, 236, 442);
		panel_2.add(textArea);
		
		JLabel lblNewLabel_6 = new JLabel("USUARIO");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6.setBounds(10, 15, 65, 14);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("CONTRASEÑA");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_7.setBounds(66, 15, 103, 14);
		panel_2.add(lblNewLabel_7);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(0, 0, 782, 56);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton exportar = new JButton("EXPORTAR");
		exportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content = textArea.getText();
                saveTextToCSV(content);		
				}
		});
		
		panel_3.add(exportar);
		
		exportar.setBackground(new Color(255, 255, 255));
		exportar.setBounds(609, 22, 103, 23);
		panel_3.add(exportar);
		
		JLabel lblNewLabel = new JLabel("KEY GUARDIAN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(323, 22, 150, 19);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\workspaceEclipce\\com.creators.AdminCont\\banner.png"));
		lblNewLabel_1.setBounds(288, 11, 40, 45);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\workspaceEclipce\\com.creators.AdminCont\\banner.png"));
		lblNewLabel_2.setBounds(460, 11, 40, 45);
		panel_3.add(lblNewLabel_2);
		
	
	// Leer y mostrar el contenido del archivo CSV en el JTextArea
    leerCSV("credenciales.csv", textArea);
    
    JButton btnNewButton = new JButton("Actualizar\r\n");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
	        String filePath = "credenciales.csv";
	        textArea.setText("");
	        leerCSV(filePath, textArea);
    	}
    });
    btnNewButton.setBackground(new Color(255, 255, 255));
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
    btnNewButton.setBounds(161, 11, 85, 23);
    panel_2.add(btnNewButton);
}

	protected void saveTextToCSV(String text) {
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar archivo CSV");
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile() + ".csv"))) {
                writer.write(text);
                JOptionPane.showMessageDialog(null, "Archivo guardado exitosamente.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + ex.getMessage());
            }
        }
		
	}

	
protected void leerCSV(String filePath, JTextArea textArea) {
    try {
        // Crear un BufferedReader para leer el archivo CSV
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String linea;

        // Leer el archivo línea por línea y agregar al JTextArea
        while ((linea = br.readLine()) != null) {
            textArea.append(linea + "\n");
        }

        // Cerrar BufferedReader
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
   
}

	protected void escribirCSV(String filePath, String usuario, String contrasena) {
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

            JOptionPane.showMessageDialog(null, "Agregado correctamente.\n Actualiza la vista");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registrar");
        }
		
	}

	protected void Copiar() {
		String texto = contraGene.getText();
        // Copiar el texto al portapapeles
        copiarAlPortapapeles(texto);
        
		
	}

	private void copiarAlPortapapeles(String texto) {
	        // Obtener el Toolkit del sistema
	        Toolkit toolkit = Toolkit.getDefaultToolkit();
	        // Obtener el Clipboard del sistema
	        Clipboard clipboard = toolkit.getSystemClipboard();
	        // Crear un StringSelection para el texto
	        StringSelection stringSelection = new StringSelection(texto);
	        // Limpiar el portapapeles y copiar el texto
	        clipboard.setContents(stringSelection, null);
	    
		
	}

	protected void qrboton() {
		String text = password; // Texto o enlace que quieres codificar en el código QR
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

        } catch (WriterException e1) {
            e1.printStackTrace();
        }
		
	}

	protected String generatePassword(int length) {
		final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
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
	protected String generatePasswordIngreso(int length) {
		final String CHARACTERS = userInput;
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
