package com.creators.AdminCont;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.awt.event.ActionEvent;

public class Log_in extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuarioT;
	private JPasswordField contrasenaT;
	public Cifrado c = new Cifrado();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log_in frame = new Log_in();
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
	public Log_in() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\workspaceEclipce\\com.creators.AdminCont\\CENT.png"));
		setTitle("KEY GUARDIAN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\workspaceEclipce\\com.creators.AdminCont\\Logo.png"));
		lblNewLabel.setBounds(169, 11, 100, 100);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO: ");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(102, 122, 110, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRASEÑA:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(102, 158, 137, 27);
		contentPane.add(lblNewLabel_2);
		
		usuarioT = new JTextField();
		usuarioT.setBounds(241, 122, 86, 20);
		contentPane.add(usuarioT);
		usuarioT.setColumns(10);
		
		contrasenaT = new JPasswordField();
		contrasenaT.setBounds(240, 164, 87, 20);
		contentPane.add(contrasenaT);
		
		JButton ingresar = new JButton("INGRESAR");
		ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cifrado C = new Cifrado();
				Menu b = new Menu();
				String valor1 = null;
				 String valor2 = null;
				 String valord1 = null;
				 String valord2 = null;
				 String linea = null;
				 
				  String archivo = "datos.txt"; // Reemplaza con la ruta de tu archivo

				  StringBuilder contenido = new StringBuilder();
			        
			        // Leer el archivo línea por línea
			        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			            
			            while ((linea = br.readLine()) != null) {
			                contenido.append(linea).append("\n");  // Agregar cada línea al StringBuilder
			            }
			        } catch (IOException l) {
			            l.printStackTrace();
			        }
			        
			        // Convertir el StringBuilder a una cadena
			        String textoArchivo = contenido.toString().trim();
			        
			        // Separar el contenido del archivo en líneas
			        String[] lineas = textoArchivo.split("\n");
			        
			        // Verificar si hay al menos dos líneas
			        if (lineas.length >= 2) {
			            valor1 = lineas[0];
			            valor2 = lineas[1];
			            
			            try {
							valord1 = C.descifrar(valor1.toString());
							valord2 = C.descifrar(valor2.toString());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			           
			            
			            // Imprimir los valores separados
			            System.out.println("Valor1: " + valord1);
			            System.out.println("Valor2: " + valord2);
			        } else {
			            System.out.println("El archivo no contiene el formato esperado (al menos dos líneas).");
			        }
		            
			        String usuaB = usuarioT.getText(), contB = contrasenaT.getText();
			        if(usuaB.equals(valord1)&& contB.equals(valord2)) {
			        	JOptionPane.showMessageDialog(null, "Ingreso con exito\n Bienvenido" );
			        	b.setVisible(true);
			        	setVisible(false);
			        }else {
			        	JOptionPane.showMessageDialog(null, "Error en Usuario o Contraseña" );
			        }
			    
		
			       
					
			 
			}
			
		});
		ingresar.setForeground(new Color(0, 0, 0));
		ingresar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		ingresar.setBackground(new Color(255, 255, 255));
		ingresar.setBounds(102, 208, 110, 23);
		contentPane.add(ingresar);
		
		JButton registrar = new JButton("REGISTRAR");
		registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cifrado a = new Cifrado();
				
				try {
					File archivo = new File("datos.txt");
		            if (archivo.exists()) {
		                JOptionPane.showMessageDialog(null, "El archivo ya existe. No se permite registrar más datos.");
		                return; // Salir del método si el archivo ya existe
		            }
		            // Cifrar y escribir en el archivo
					String usua = a.cifrar(usuarioT.getText());
					String contra = a.cifrar(contrasenaT.getText());
		            try (FileWriter escritor = new FileWriter(archivo)) {
		            	escritor.write(usua + "\n" + contra); 
		            	JOptionPane.showMessageDialog(null, "Registrado con exito" );// Escribe el usuario cifrado y una nueva línea
		            }} catch (IOException e1) {
		                e1.printStackTrace();
		            } catch (java.security.InvalidKeyException | java.security.NoSuchAlgorithmException
		                    | NoSuchProviderException | javax.crypto.BadPaddingException
		                    | javax.crypto.IllegalBlockSizeException e1) {
		                e1.printStackTrace();
		            } catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		
		
		registrar.setForeground(new Color(0, 0, 0));
		registrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		registrar.setBackground(new Color(255, 255, 255));
		registrar.setBounds(222, 208, 105, 23);
		contentPane.add(registrar);
	}

}
