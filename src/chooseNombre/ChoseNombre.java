package chooseNombre;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class ChoseNombre  {

	private JFrame frame;
	private JTextField txtChoosenombre;
	private JTextField Jpalabra;
	private PalabrasAzar paZar;
	private ArrayList<String> palabrasElegidas;
	private String loQueSeVe;
	private JTextPane textPane;
	private JButton copiar;
	private JScrollPane scrollPane;
	private JButton borrarAnterior;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoseNombre window = new ChoseNombre();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChoseNombre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		paZar = new PalabrasAzar();
		palabrasElegidas= new ArrayList<String>();
		frame = new JFrame();
		frame.setBounds(100, 100, 567, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("ChooseNombre 1.0 by Pablo98ad");
		
		txtChoosenombre = new JTextField();
		txtChoosenombre.setFocusable(false);
		txtChoosenombre.setBackground(new Color(0, 51, 255));
		txtChoosenombre.setDisabledTextColor(new Color(139, 0, 139));
		txtChoosenombre.setForeground(new Color(0, 255, 0));
		txtChoosenombre.setEditable(false);
		txtChoosenombre.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
		txtChoosenombre.setText("ChooseNombre");
		txtChoosenombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtChoosenombre.setBounds(10, 11, 528, 30);
		frame.getContentPane().add(txtChoosenombre);
		txtChoosenombre.setColumns(10);
		
		Jpalabra = new JTextField();
		Jpalabra.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.requestFocusInWindow();
			}
		});
		Jpalabra.setEditable(false);
		Jpalabra.setFont(new Font("Serif", Font.BOLD, 24));
		Jpalabra.setHorizontalAlignment(SwingConstants.CENTER);
		Jpalabra.setText("");
		Jpalabra.setBounds(173, 69, 191, 50);
		frame.getContentPane().add(Jpalabra);
		Jpalabra.setColumns(10);
		
		JButton btnAnterior = new JButton("<html><p style='text-align:center'>Anterior</p><p style='text-align:center;font-size:7px' >O pulsa Flecha Izquierda</p></html>");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jpalabra.setText(paZar.anteriorPalabra());
				frame.requestFocusInWindow();
			}
		});
		btnAnterior.setBackground(new Color(210, 105, 30));
		btnAnterior.setMargin(new Insets(0, 0, 5, 0));
		btnAnterior.setBounds(44, 68, 89, 57);
		frame.getContentPane().add(btnAnterior);
		
		JButton btnSiguiente = new JButton("<html><p style='text-align:center'>Siguiente</p><p style='text-align:center;font-size:7px' >O pulsa Flecha Derecha</p></html>");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jpalabra.setText(paZar.nuevaPalabra());
				frame.requestFocusInWindow();
			}
		});
		btnSiguiente.setBackground(new Color(210, 105, 30));
		//btnNewButton_1.setText(); 
		btnSiguiente.setMargin(new Insets(0, 0, 5, 0));
		btnSiguiente.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSiguiente.setBounds(405, 68, 89, 57);
		frame.getContentPane().add(btnSiguiente);
		
		JButton btnElegir = new JButton("<html><p style='text-align:center'>Elegir</p><p style='text-align:center;font-size:7px' >O pulsa Intro</p></html>");
		btnElegir.setMargin(new Insets(0, 0, 0, 0));
		btnElegir.setBackground(new Color(0, 255, 0));
		btnElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					palabrasElegidas.add(paZar.getPalabraActual());
				}catch(Exception e1) {
				}
				
				
				if(palabrasElegidas.size()>0) {//si no hay palabra seleccionada
					if(loQueSeVe==null) {//para que no se vea el null
						loQueSeVe=textPane.getText();
					}
					if(loQueSeVe.isEmpty()/*palabrasElegidas.size()==1*/) {//para que en la primera palabra no haya guion al principio
						loQueSeVe=loQueSeVe+palabrasElegidas.get(palabrasElegidas.size()-1);
						
					}else {
							loQueSeVe=loQueSeVe+"  -  "+palabrasElegidas.get(palabrasElegidas.size()-1);
					}	
					
					textPane.setText(loQueSeVe);
					borrarAnterior.setVisible(true);
					copiar.setVisible(true);
				}
				
				frame.requestFocusInWindow();
			}
		});
		btnElegir.setBounds(228, 130, 89, 44);
		frame.getContentPane().add(btnElegir);
		
		textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("Button.background"));
		textPane.setFocusable(false);
		textPane.setEditable(false);
		textPane.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 15));
		textPane.setBounds(10, 192, 528, 138);
		frame.getContentPane().add(textPane);
		
		
		copiar = new JButton("Copiar");
		copiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
				StringSelection ss = new StringSelection(loQueSeVe);
				cb.setContents(ss, ss);
				frame.requestFocusInWindow();
			}
			});
		copiar.setMargin(new Insets(0, 0, 0, 0));
		copiar.setBounds(465, 164, 76, 23);
		copiar.setVisible(false);
		frame.getContentPane().add(copiar);
		
		scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(10, 193, 528, 137);
		frame.getContentPane().add(scrollPane);
		
		borrarAnterior = new JButton("Borrar Anterior");
		borrarAnterior.setFont(new Font("Tahoma", Font.PLAIN, 11));
		borrarAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] palabras;
				
				if (loQueSeVe!=null) {
					if(loQueSeVe.indexOf('-')==-1) {//no hay guion y solo hay una palabra
						loQueSeVe="";
						borrarAnterior.setVisible(false);
						copiar.setVisible(false);
						
					}else {
						palabras=loQueSeVe.split("  -  ");

						
						loQueSeVe="";
						loQueSeVe=loQueSeVe+palabras[0];
						for (int i=1;i<palabras.length-1;i++) {
							loQueSeVe=loQueSeVe+"  -  "+palabras[i];
					}
				}
				}
				textPane.setText(loQueSeVe);
				
				frame.requestFocusInWindow();
			}
		});
		borrarAnterior.setMargin(new Insets(0, 0, 0, 0));
		borrarAnterior.setBounds(10, 164, 95, 23);
		frame.getContentPane().add(borrarAnterior);
		borrarAnterior.setVisible(false);
		
		frame.setFocusable(true);//para que nada mas abramos la aplicacion podamos pulsar teclas
		//eventos teclas
        frame.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
                
            }
            public void keyPressed(KeyEvent e){
            	//System.out.println(e.getKeyCode());
                if(e.getKeyCode()==10){
                    btnElegir.doClick();//como si se estubiera pulsando el boton con un click
                   
                }
                if(e.getKeyCode()==39){
                    btnSiguiente.doClick();//como si se estubiera pulsando el boton con un click
                   
                }
                if(e.getKeyCode()==37){
                    btnAnterior.doClick();//como si se estubiera pulsando el boton con un click
                   
                }
                if(e.getKeyCode()==8){
                	borrarAnterior.doClick();
                }
                
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }
            public void keyReleased(KeyEvent e){
                
            }
        });
		
		
		
	}
}
