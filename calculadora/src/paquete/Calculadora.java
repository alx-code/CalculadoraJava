package paquete;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Calculadora extends JFrame implements ActionListener{

	JTextField textfield;
	JButton uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,cero,suma,resta,multiplicar,dividir,raiz,fraccion,limpiar,borrar_ultimo,punto,igual;
	JPanel contenido;
	Double num1, num2, result;
	static int op=0, op2=0, op3;
	
	public Calculadora()
	{
		super.setTitle("Calculadora Java");		//Titulo de mi JFrame
		setSize(245,320);		//Tamaño de mi JFrame
		setLocationRelativeTo(null);	//Le indico que se inicie en el centro de la pantalla
		textfield = new JTextField("0");
		textfield.setBounds(10, 20, 222, 40); //determino el tamaño y lugar de mi textfield
		textfield.setHorizontalAlignment(textfield.RIGHT); //le inidico que orientacion tendra el texto
		Font fuente=new Font("Dialog", Font.BOLD, 36); 	//Tamaño y tipo de fuente
		textfield.setFont (fuente) ;	//Asigno la fuente
		textfield.addKeyListener(new KeyAdapter() //Verfico lo que se esta escribiendo en el
		{
			   public void keyTyped(KeyEvent e)
			   {
			      char caracter = e.getKeyChar(); //Variable para capturar primero lo que se captura

			      // Verificar si la tecla pulsada no es un digito
			      if(((caracter < '0') || (caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/))
			      {
			         e.consume();  //Ignorar el evento de teclado
			      }
			   }
		});
		
		uno = new JButton("1"); 		//Asigno un valor al objeto del numero uno
		uno.setBounds(10, 172, 36, 36); //Posicion (coordenada x, coordenada y) y tamaño (weight,hight)
		uno.setMargin(new Insets(1,1,1,1)); //margenes para el contenido del botón
		uno.addActionListener(this);	//Le digo que este boton escuchara
		
		siete = new JButton("7");
		siete.setBounds(10, 80, 36, 36);
		siete.setMargin(new Insets(1,1,1,1));
		siete.addActionListener(this);
		
		ocho = new JButton("8");
		ocho.setBounds(56, 80, 36, 36);
		ocho.setMargin(new Insets(1,1,1,1));
		ocho.addActionListener(this);
		
		nueve = new JButton("9");
		nueve.setBounds(102, 80, 36, 36);
		nueve.setMargin(new Insets(1,1,1,1));
		nueve.addActionListener(this);
		
		suma = new JButton("+");
		suma.setBounds(148, 80, 36, 36);
		suma.setMargin(new Insets(1,1,1,1));
		suma.addActionListener(this);
		
		raiz = new JButton("SQRT");
		raiz.setBounds(194, 80, 36, 36);
		raiz.setMargin(new Insets(1,1,1,1));
		raiz.addActionListener(this);
		
		cuatro = new JButton("4");
		cuatro.setBounds(10, 126, 36, 36);
		cuatro.setMargin(new Insets(1,1,1,1));
		cuatro.addActionListener(this);
		
		cinco = new JButton("5");
		cinco.setBounds(56, 126, 36, 36);
		cinco.setMargin(new Insets(1,1,1,1));
		cinco.addActionListener(this);
		
		seis = new JButton("6");
		seis.setBounds(102, 126, 36, 36);
		seis.setMargin(new Insets(1,1,1,1));
		seis.addActionListener(this);
		
		resta = new JButton("-");
		resta.setBounds(148, 126, 36, 36);
		resta.setMargin(new Insets(1,1,1,1));
		resta.addActionListener(this);
		
		fraccion = new JButton("1/x");
		fraccion.setBounds(194, 126, 36, 36);
		fraccion.setMargin(new Insets(1,1,1,1));
		fraccion.addActionListener(this);
		
		dos = new JButton("2");
		dos.setBounds(56, 172, 36, 36);
		dos.setMargin(new Insets(1,1,1,1));
		dos.addActionListener(this);
		
		tres = new JButton("3");
		tres.setBounds(102, 172, 36, 36);
		tres.setMargin(new Insets(1,1,1,1));
		tres.addActionListener(this);
		
		dividir = new JButton("/");
		dividir.setBounds(148, 172, 36, 36);
		dividir.setMargin(new Insets(1,1,1,1));
		dividir.addActionListener(this);
		
		multiplicar = new JButton("*");
		multiplicar.setBounds(194, 172, 36, 36);
		multiplicar.setMargin(new Insets(1,1,1,1));
		multiplicar.addActionListener(this);
		
		cero = new JButton("0");
		cero.setBounds(10, 219, 36, 36);
		cero.setMargin(new Insets(1,1,1,1));
		cero.addActionListener(this);
		
		punto = new JButton(".");
		punto.setBounds(56, 219, 36, 36);
		punto.setMargin(new Insets(1,1,1,1));
		punto.addActionListener(this);
		
		borrar_ultimo = new JButton("<-");
		borrar_ultimo.setBounds(102, 219, 36, 36);
		borrar_ultimo.setMargin(new Insets(1,1,1,1));
		borrar_ultimo.addActionListener(this);
		
		limpiar = new JButton("C");
		limpiar.setBounds(148, 219, 36, 36);
		limpiar.setMargin(new Insets(1,1,1,1));
		limpiar.addActionListener(this);
		
		igual = new JButton("=");
		igual.setBounds(194, 219, 36, 36);
		igual.setMargin(new Insets(1,1,1,1));
		igual.addActionListener(this);
		
		
		contenido = new JPanel(); //Creo el objeto JPanel para que a el se le asignen los botones
		setContentPane(contenido); //Le asigno el bojeto al Jpanel
		contenido.setLayout(null);	//Le indico que su layout sera null esto para poder maniobrar a mi gusto con los objetos
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Solo le hago saber que cuando se cierre se cierre el proceso
		
		contenido.add(textfield);	//Añado el textfield al contenido
		
		contenido.add(siete);
		contenido.add(ocho);
		contenido.add(nueve);
		contenido.add(suma);
		contenido.add(raiz);
		
		contenido.add(cuatro);
		contenido.add(cinco);
		contenido.add(seis);
		contenido.add(resta);
		contenido.add(fraccion);
		
		contenido.add(uno);
		contenido.add(dos);
		contenido.add(tres);
		contenido.add(dividir);
		contenido.add(multiplicar);
		
		contenido.add(cero);
		contenido.add(punto);
		contenido.add(borrar_ultimo);
		contenido.add(limpiar);
		contenido.add(igual);
		
		setResizable(false);	//Le digo que no se podra cambiar el tamaño del JFrame
		setVisible(true);		//Muestro todo el proyecto terminado
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == uno)
		{
			if(op == 0)
			{
				if(textfield.getText().equals("0"))
				{
					textfield.setText(e.getActionCommand());
				}
				else{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1))+e.getActionCommand());
				}
			}else{
				if(op2 == 0)
				{
					textfield.setText(e.getActionCommand());
					op2 = 1;
				}else if(op2 == 1)
				{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1)+e.getActionCommand()));
				}
			}	
		}
		if(e.getSource() == dos)
		{
			if(op == 0)
			{
				if(textfield.getText().equals("0"))
				{
					textfield.setText(e.getActionCommand());
				}
				else{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1))+e.getActionCommand());
				}
			}else{
				if(op2 == 0)
				{
					textfield.setText(e.getActionCommand());
					op2 = 1;
				}else if(op2 == 1)
				{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1)+e.getActionCommand()));
				}
			}			
		}
		if(e.getSource() == tres)
		{
			if(op == 0)
			{
				if(textfield.getText().equals("0"))
				{
					textfield.setText(e.getActionCommand());
				}
				else{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1))+e.getActionCommand());
				}
			}else{
				if(op2 == 0)
				{
					textfield.setText(e.getActionCommand());
					op2 = 1;
				}else if(op2 == 1)
				{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1)+e.getActionCommand()));
				}
			}	
		}
		if(e.getSource() == cuatro)
		{
			if(op == 0)
			{
				if(textfield.getText().equals("0"))
				{
					textfield.setText(e.getActionCommand());
				}
				else{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1))+e.getActionCommand());
				}
			}else{
				if(op2 == 0)
				{
					textfield.setText(e.getActionCommand());
					op2 = 1;
				}else if(op2 == 1)
				{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1)+e.getActionCommand()));
				}
			}	
		}
		if(e.getSource() == cinco)
		{
			if(op == 0)
			{
				if(textfield.getText().equals("0"))
				{
					textfield.setText(e.getActionCommand());
				}
				else{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1))+e.getActionCommand());
				}
			}else{
				if(op2 == 0)
				{
					textfield.setText(e.getActionCommand());
					op2 = 1;
				}else if(op2 == 1)
				{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1)+e.getActionCommand()));
				}
			}	
		}
		if(e.getSource() == seis)
		{
			if(op == 0)
			{
				if(textfield.getText().equals("0"))
				{
					textfield.setText(e.getActionCommand());
				}
				else{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1))+e.getActionCommand());
				}
			}else{
				if(op2 == 0)
				{
					textfield.setText(e.getActionCommand());
					op2 = 1;
				}else if(op2 == 1)
				{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1)+e.getActionCommand()));
				}
			}	
		}
		if(e.getSource() == siete)
		{
			if(op == 0)
			{
				if(textfield.getText().equals("0"))
				{
					textfield.setText(e.getActionCommand());
				}
				else{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1))+e.getActionCommand());
				}
			}else{
				if(op2 == 0)
				{
					textfield.setText(e.getActionCommand());
					op2 = 1;
				}else if(op2 == 1)
				{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1)+e.getActionCommand()));
				}
			}	
		}
		if(e.getSource() == ocho)
		{
			if(op == 0)
			{
				if(textfield.getText().equals("0"))
				{
					textfield.setText(e.getActionCommand());
				}
				else{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1))+e.getActionCommand());
				}
			}else{
				if(op2 == 0)
				{
					textfield.setText(e.getActionCommand());
					op2 = 1;
				}else if(op2 == 1)
				{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1)+e.getActionCommand()));
				}
			}	
		}
		if(e.getSource() == nueve)
		{
			if(op == 0)
			{
				if(textfield.getText().equals("0"))
				{
					textfield.setText(e.getActionCommand());
				}
				else{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1))+e.getActionCommand());
				}
			}else{
				if(op2 == 0)
				{
					textfield.setText(e.getActionCommand());
					op2 = 1;
				}else if(op2 == 1)
				{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1)+e.getActionCommand()));
				}
			}	
		}
		if(e.getSource() == cero)
		{
			if(op == 0)
			{
				if(textfield.getText().equals("0"))
				{
					textfield.setText(e.getActionCommand());
				}
				else{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1))+e.getActionCommand());
				}
			}else{
				if(op2 == 0)
				{
					textfield.setText(e.getActionCommand());
					op2 = 1;
				}else if(op2 == 1)
				{
					num1 = Double.parseDouble(textfield.getText());
					textfield.setText(String.valueOf(Math.round(num1)+e.getActionCommand()));
				}
			}	
		}
		if(e.getSource() == limpiar)
		{
			textfield.setText("0");
			op = 0;
			op2 = 0;
			num1 = 0.0;
			result = null;
		}
		if(e.getSource() == borrar_ultimo)
		{
			if(textfield.getText() == "")
			{
				textfield.setText("0");
			}else{
				String numero;
				numero = textfield.getText().substring(0, textfield.getText().length()-1);
				textfield.setText(numero);
			}
		}
		if(e.getSource() == suma)
		{
			if(textfield.getText().equals("0"))
			{
				JOptionPane.showMessageDialog(null, "Primero captura un numero","Falta Capturar", JOptionPane.WARNING_MESSAGE);
			}
			else{
				suma();
				op3 = 1;
			}
			
		}
		if(e.getSource() == resta)
		{
			if(textfield.getText().equals("0"))
			{
				JOptionPane.showMessageDialog(null, "Primero captura un numero","Falta Capturar", JOptionPane.WARNING_MESSAGE);
			}
			else{
				resta();
				op3 = 2;
			}
		}
		if(e.getSource() == multiplicar)
		{
			if(textfield.getText().equals("0"))
			{
				JOptionPane.showMessageDialog(null, "Primero captura un numero","Falta Capturar", JOptionPane.WARNING_MESSAGE);
			}
			else{
				multiplicar();
				op3 = 3;
			}
		}
		if(e.getSource() == dividir)
		{
			if(textfield.getText().equals("0"))
			{
				JOptionPane.showMessageDialog(null, "Primero captura un numero","Falta Capturar", JOptionPane.WARNING_MESSAGE);
			}
			else{
				dividir();
				op3 = 4;
			}
		}
		if(e.getSource() == raiz)
		{
			if(textfield.getText().equals("0"))
			{
				JOptionPane.showMessageDialog(null, "Primero captura un numero","Falta Capturar", JOptionPane.WARNING_MESSAGE);
			}
			else{
				raiz();
			}
		}
		if(e.getSource() == fraccion)
		{
			if(textfield.getText().equals("0"))
			{
				JOptionPane.showMessageDialog(null, "Primero captura un numero","Falta Capturar", JOptionPane.WARNING_MESSAGE);
			}
			else{
				fraccion();
			}
		}
		if(e.getSource() == igual)
		{
			if(op3 == 1)
			{
				suma();
			}else if(op3 == 2)
			{
				resta();
			}else if(op3 == 3)
			{
				multiplicar();
			}else if(op3 == 4)
			{
				dividir();
			}
			op = 0;
			op2 = 0;
			op3 = 0;
			num1 = 0.0;
			result = null;
		}
	}
	public  void resultf(Double result) {
		textfield.setText("");
		textfield.setText(String.valueOf(result));
		op2 = 0;
	}
	public void suma() {
		if(result == null)
		{
			result = Double.parseDouble(textfield.getText());
			resultf(result);
			op=1;
		}else{
			result = (Double.parseDouble(textfield.getText()) + result);
			resultf(result);
		}
	}
	public void resta() {
		if(result == null)
		{
			result = Double.parseDouble(textfield.getText());
			resultf(result);
			op=1;
		}else{
			result = result - (Double.parseDouble(textfield.getText()));
			resultf(result);
		}
	}
	public void multiplicar() {
		if(result == null)
		{
			result = Double.parseDouble(textfield.getText());
			resultf(result);
			op=1;
		}else{
			result = result * (Double.parseDouble(textfield.getText()));
			resultf(result);
		}
	}
	public void dividir() {
		if(result == null)
		{
			result = Double.parseDouble(textfield.getText());
			resultf(result);
			op=1;
		}else{
			result = result / (Double.parseDouble(textfield.getText()));
			resultf(result);
		}
	}
	public void fraccion() {
		if(result == null)
		{
			result = Double.parseDouble(textfield.getText());
			resultf(result);
			op=1;
		}else{
			result = (Double.parseDouble(textfield.getText()) / result);
			resultf(result);
		}
	}
	public void raiz() {
		if(result == null)
		{
			result = Double.parseDouble(textfield.getText());
			resultf(result);
			op=1;
		}else{
			result = (Double.parseDouble(textfield.getText()) / result);
			resultf(result);
		}
	}
	public static void main (String args[])
	{
		try
		{
			salir:
				for(javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels())
				{
					switch (info.getName())
					{
						case "GTK+":
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
						break salir;
						case "Windows":
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
						break salir;
						default:
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
						break;
					}
					
						
				}
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		@SuppressWarnings("unused")
		Calculadora formulario = new Calculadora();
	}
}
