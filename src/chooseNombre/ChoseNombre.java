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

public class ChoseNombre  {

	private JFrame frame;
	private JTextField txtChoosenombre;
	private JTextField Jpalabra;
	private PalabrasAzar paZar;
	private ArrayList<String> palabrasElegidas;
	private String loQueSeVe;
	private JTextPane textPane;
	private JButton copiar;

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
		
		txtChoosenombre = new JTextField();
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
		Jpalabra.setEditable(false);
		Jpalabra.setFont(new Font("Serif", Font.BOLD, 24));
		Jpalabra.setHorizontalAlignment(SwingConstants.CENTER);
		Jpalabra.setText("");
		Jpalabra.setBounds(173, 69, 191, 50);
		frame.getContentPane().add(Jpalabra);
		Jpalabra.setColumns(10);
		
		JButton btnNewButton = new JButton("<html><p style='text-align:center'>Anterior</p><p style='text-align:center;font-size:7px' >O pulsa Flecha Izquierda</p></html>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jpalabra.setText(paZar.anteriorPalabra());
				frame.requestFocusInWindow();
			}
		});
		btnNewButton.setBackground(new Color(210, 105, 30));
		btnNewButton.setMargin(new Insets(0, 0, 5, 0));
		btnNewButton.setBounds(44, 68, 89, 57);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<html><p style='text-align:center'>Siguiente</p><p style='text-align:center;font-size:7px' >O pulsa Flecha Derecha</p></html>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jpalabra.setText(paZar.nuevaPalabra());
				frame.requestFocusInWindow();
			}
		});
		btnNewButton_1.setBackground(new Color(210, 105, 30));
		//btnNewButton_1.setText(); 
		btnNewButton_1.setMargin(new Insets(0, 0, 5, 0));
		btnNewButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_1.setBounds(405, 68, 89, 57);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<html><p style='text-align:center'>Elegir</p><p style='text-align:center;font-size:7px' >O pulsa Intro</p></html>");
		btnNewButton_2.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton_2.setBackground(new Color(0, 255, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				palabrasElegidas.add(paZar.getPalabraActual());
				}catch(Exception e1) {
				}
				
				
				if(palabrasElegidas.size()>0) {
					if(loQueSeVe==null) {
						loQueSeVe=textPane.getText();
					}
					if(palabrasElegidas.size()<2) {
						loQueSeVe=loQueSeVe+palabrasElegidas.get(palabrasElegidas.size()-1);
					}else {
						loQueSeVe=loQueSeVe+"  -  "+palabrasElegidas.get(palabrasElegidas.size()-1);
						
					}	
					
					textPane.setText(loQueSeVe);
					copiar.setVisible(true);
				}
				
				frame.requestFocusInWindow();
			}
		});
		btnNewButton_2.setBounds(228, 130, 89, 44);
		frame.getContentPane().add(btnNewButton_2);
		
		textPane = new JTextPane();
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
		copiar.setBounds(462, 164, 76, 23);
		copiar.setVisible(false);
		frame.getContentPane().add(copiar);
		
		
		
		//Invocamos el método, ahora si funcionara
        frame.setFocusable(true);
 
        //Eventos
 
        frame.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
                //Aqui no funcionara
            }
            public void keyPressed(KeyEvent e){
            	System.out.println(e.getKeyCode());
                if(e.getKeyCode()==10){
                    btnNewButton_2.doClick();//como si se estubiera pulsando el boton con un click
                    System.out.println(e.getKeyCode());
                }
                if(e.getKeyCode()==39){
                    btnNewButton_1.doClick();//como si se estubiera pulsando el boton con un click
                    System.out.println(e.getKeyCode());
                }
                if(e.getKeyCode()==37){
                    btnNewButton.doClick();//como si se estubiera pulsando el boton con un click
                    System.out.println(e.getKeyCode());
                }
                
                
                
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }
            public void keyReleased(KeyEvent e){
                //Aqui tambien puedes insertar el codigo
            }
        });
		
		
		
	}

	
}
