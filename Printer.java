package exercicioLayout;

import java.awt.*;
import javax.swing.*;
import javax.swing.SpringLayout.Constraints;

public class Printer extends JFrame {

	JLabel cima;
	JPanel meio;
	JPanel direita;
	JButton[] botoes;
	JRadioButton[] radio;
	JCheckBox[] box;
	String[] bots = { "OK", "Cancel", "Setup", "Help" };
	String[] boxs = { "Image", "Text", "Code" };
	String[] radis = { "Selection", "All", "Applet" };
	ButtonGroup[] grupos;
	JTextArea[] textos;
	JPanel baixo;
	JCheckBox solitario;
	JComboBox lista;
	JLabel textin;

	public Printer() {
		super("Printer");
		setVisible(true);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setSize(500, 170);
		cima = new JLabel("                   Printer: MyPrinter");
		add(cima, BorderLayout.NORTH);
		botoes = new JButton[4];
		direita = new JPanel(new GridLayout(4, 1));
		for (int i = 0; i < 4; i++) {
			botoes[i] = new JButton(bots[i]);
			direita.add(botoes[i]);
		}
	
		meio = new JPanel(new FlowLayout());
		Box itens = Box.createVerticalBox();
		Box itens2 = Box.createVerticalBox();
		box = new JCheckBox[3];
		radio = new JRadioButton[3];
		grupos = new ButtonGroup[2];
		grupos[0] = new ButtonGroup();
		grupos[1] = new ButtonGroup();
		textos = new JTextArea[3];
		
		for (int i = 0; i < 3; i++) {
			box[i] = new JCheckBox(boxs[i]);
			radio[i] = new JRadioButton(radis[i]);
			itens.add(box[i]);
			itens2.add(radio[i]);
			grupos[0].add(box[i]);
			grupos[1].add(radio[i]);
			textos[i] = new JTextArea();
			textos[i].setColumns(5);
			textos[i].setRows(5);
			textos[i].setEditable(false);
		}

		meio.add(textos[0]);
		meio.add(itens);
		meio.add(textos[1]);
		meio.add(itens2);
		meio.add(textos[2]);
		add(meio, BorderLayout.CENTER);
		
		baixo = new JPanel(new FlowLayout());
		textin = new JLabel("Print Quality:            ");
		baixo.add(textin);
		String[] x = {"High","Medium","Low"};
		lista = new JComboBox(x);
		baixo.add(lista);
		solitario = new JCheckBox("Print To File           ");
		baixo.add(solitario);
		add(baixo,BorderLayout.SOUTH);
		add(direita, BorderLayout.EAST);
		
		

	}

	public static void main(String[] args) {
		Printer p = new Printer();
	}

}
