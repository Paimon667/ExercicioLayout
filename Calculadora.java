package ExerLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculadora extends JFrame {

	JTextField texto;
	JButton[] bot = new JButton[28];
	JPanel fundo;
	String[][] simbolos = { { "x!", "e^x", "Rz2", "7", "8", "9", "/" }, { "Rz3", "%", "x^2", "4", "5", "6", "*" },
			{ "x^3", "x^y", "Pi", "1", "2", "3", "-" }, { "C", "(", ")", "0", ".", "=", "+" } };
	int numA;
	int numB;
	int posiB;
	int op;
	int op2;
	String[] OpBasicas = { "+", "*", "-", "/", "x^y", "%"};
	String[] OpUnicas = { "x^2", "x^3", "x!", "Rz2", "Rz3", "e^x" };
	String[] Complemento = { "(", "C", ")", "Pi"};

	public Calculadora() {
		super("Calculadora");
		setLayout(new FlowLayout());
		ouvidorbot x = new ouvidorbot();

		texto = new JTextField(20);
		texto.setEditable(false);
		add(texto);

		fundo = new JPanel();
		fundo.setLayout(new GridLayout(4, 7));
		add(fundo);
		String[] nums = new String[10];
		for (int i = 0; i < 10; i++) {
			nums[i] = "" + i;
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				bot[i] = new JButton(simbolos[i][j]);
				bot[i].setBackground(Color.LIGHT_GRAY);
				bot[i].addActionListener(x);
				fundo.add(bot[i]);
			}
		}

	}

	public class ouvidorbot implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			for (int i = 0; i < 10; i++) {
				if (event.getActionCommand().equalsIgnoreCase("" + i)) {
					texto.setText(texto.getText() + event.getActionCommand());
				}
			}

			for (int j = 0; j < OpBasicas.length; j++) {
				if (event.getActionCommand().equalsIgnoreCase(OpBasicas[j])) {

					numA = Integer.parseInt(texto.getText());
					System.out.println(numA);
					texto.setText(texto.getText() + OpBasicas[j]);
					posiB = texto.getText().length();

					op = j;
				}
			}

			for (int k = 0; k < OpUnicas.length; k++) {
				if (event.getActionCommand().equalsIgnoreCase(OpUnicas[k])) {
					numA = Integer.parseInt(texto.getText());
					texto.setText(texto.getText() + OpUnicas[k]);
					op2 = k;
				}
			}
			
			for(int f = 0; f < Complemento.length; f++) {
				if(event.getActionCommand().equals(Complemento[f])) {
					int op3 = f;
						switch(op3) {
						case 0:
							texto.setText(texto.getText()+"(");
							JOptionPane.showMessageDialog(null, "Tecla meramente ilustrativa");
							break;
						case 1:
							texto.setText("");
						break;
						case 2:
							texto.setText(texto.getText()+")");
							JOptionPane.showMessageDialog(null, "Tecla meramente ilustrativa");
							break;
						case 3:
							texto.setText(""+3.14);
							break;
							
						}	
					
				}
			}
			
			for (int q = 0; q < OpUnicas.length; q++) {
				if (event.getActionCommand().equalsIgnoreCase(OpUnicas[q]))
					switch (op2) {
					case 0:
						texto.setText("" + numA * numA);
						break;

					case 1:
						texto.setText("" + numA * numA * numA);
						break;

					case 2:

						for (int l = numA - 1; l > 0; l--) {
							numA = numA * l;
						}
						texto.setText("" + numA);

						break;

					case 3:
						boolean achei = false;
						for (int h = 0; h <= numA / 2; h++) {
							if (h * h == numA) {
								texto.setText("" + h);
								achei = true;
								break;
							}
						}
						if (achei == false) {
							texto.setText("Inexistente");
						}
						break;
					
					case 4:
						boolean achei2 = false;
						for (int g = 0; g <= numA / 2; g++) {
							if (g * g * g == numA) {
								texto.setText("" + g);
								achei2 = true;

							}
						}
						if (achei2 == false) {
							texto.setText("Inexistente");
						}
						break;
					case 5:
						double e = 0.57;
						double x = 1;
						for(int v = 0; v < numA; v++) {
							x = x*e;
						}
						texto.setText(""+e);
						
						break;
					
					}
			}
			if (event.getActionCommand().equals("=")) {

				numB = Integer.parseInt(texto.getText().substring(posiB, texto.getText().length()));

				switch (op) {
				case 0:
					texto.setText("" + (numA + numB));
					break;
				case 1:
					texto.setText("" + (numA * numB));
					break;
				case 2:
					texto.setText("" + (numA - numB));
					break;
				case 3:
					texto.setText("" + (numA / numB));
					break;
				case 4:
					int r = 1;
					for (int y = 0; y < numB; y++) {
						r = r * numA;
					}
					texto.setText("" + r);
					break;
				case 5:
					texto.setText(""+(numA*numB)/100);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Calculadora cal = new Calculadora();
		cal.setVisible(true);
		cal.setSize(410, 180);
		cal.setDefaultCloseOperation(cal.EXIT_ON_CLOSE);

	}

}
