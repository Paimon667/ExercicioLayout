package pratico3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class ColorSelect extends JFrame {

	Box esquerda = Box.createVerticalBox();
	Box cima = Box.createHorizontalBox();
	JButton[] botE = new JButton[3];
	JButton[] botT = new JButton[3];
	String[] acoes = { "Cor", "OK", "Cancel", "+", "-", "Apagar" };
	pintar tela;

	public ColorSelect() {
		super("ColorSelect");
		setLayout(new BorderLayout());
		////////////// instanciando acoes///////////////////////////////////
		acoesE e = new acoesE();
		acoesA a = new acoesA();

		////////////// Instanciar os botoes//////////////////////////
		for (int i = 0; i < botE.length; i++) {
			botE[i] = new JButton(acoes[i]);
			botE[i].addActionListener(e);
			esquerda.add(Box.createVerticalStrut(30));
			esquerda.add(botE[i]);
		}

		for (int i = 0; i < 3; i++) {
			botT[i] = new JButton(acoes[3 + i]);
			botT[i].addActionListener(a);
			cima.add(Box.createGlue());
			cima.add(botT[i]);
		}
		////////////////////////// adicionando///////////////////////
		add(esquerda, BorderLayout.WEST);
		add(cima, BorderLayout.NORTH);
		///////////////////////// criando a tela/////////////////////////////
		tela = new pintar();
		tela.setBackground(Color.blue);
		add(tela, BorderLayout.CENTER);

	} /// fim do construtor

	///////////////////////// ACOES PROS BOTOES////////////////////////////////

	public class acoesE implements ActionListener {

		public void actionPerformed(ActionEvent x) {

			if (x.getSource() == botE[0]) {

				tela.cor = JColorChooser.showDialog(null, "Escolha Cor", tela.cor);

			}

			else if (x.getSource() == botE[1]) {
				tela.setBackground(tela.cor);
			}

			else {
				tela.setBackground(Color.white);
			}

		}

	}

	public class acoesA implements ActionListener {

		public void actionPerformed(ActionEvent x) {

			if (x.getSource() == botT[0]) {
				tela.tamanho++;
			}

			else if (x.getSource() == botT[1]) {
				tela.tamanho--;
			} else {
				tela.contarPontos = 0;
				tela.pontos = new Point[1000];
				tela.repaint();
			}

		}
	}

	////////////////////// Criando o JPanel personalizado///////////////

	public class pintar extends JPanel {

		Point[] pontos = new Point[1000];
		int contarPontos = 0;
		int tamanho = 3;
		Color cor = Color.BLACK;

		public pintar() {

			addMouseMotionListener(

					new MouseMotionAdapter() {

						@Override
						public void mouseDragged(MouseEvent e) {
							if (contarPontos < pontos.length) {
								pontos[contarPontos] = e.getPoint();
								contarPontos++;
								repaint();
							}
						}

					}

			);
		}

		public void paintComponent(Graphics x) {
			super.paintComponent(x);

			for (int i = 0; i < contarPontos; i++) {
				x.setColor(cor);
				x.fillOval(pontos[i].x, pontos[i].y, tamanho, tamanho);
			}

		}

	}

	public static void main(String[] args) {
		ColorSelect cor = new ColorSelect();
		cor.setVisible(true);
		cor.setDefaultCloseOperation(cor.EXIT_ON_CLOSE);
		cor.setSize(420, 250);
	}

}
