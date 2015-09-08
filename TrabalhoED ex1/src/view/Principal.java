package view;

import javax.swing.JOptionPane;
import controll.*;

//Implementação em Java de FILA, PILHA e FILA CIRCULAR.
//autor: Felipe Rodrigues
//data: 08/09/2015

public class Principal {

	public static void main(String[] args) {
		String Menu = "Deseje a Opção desejada:"
				+ "\n1: Fila"
				+ "\n2: Fila Circular"
				+ "\n3: Pilha"
				+ "\nQualquer outra tecla para sair.";
		String opt = JOptionPane.showInputDialog(Menu);
		String pedeNum = "Insira um número inteiro:";
		String qtd = "Insira a quantidade de valores que deseja armazenar: \n(desejavel pelo menos 3)";
		int tamanho; 
		
		switch (opt){
		case "1":
			//recebe o tamanho desejado para a fila
			tamanho = Integer.parseInt(JOptionPane.showInputDialog(qtd));
			
			//instancia a fila passando a quantidade de valores como parametro
			Fila f = new Fila(tamanho);
			
			//laço para arcazenar valores na fila
			for (int i = 0; i<tamanho;i++){
				f.adiciona(Integer.parseInt(JOptionPane.showInputDialog(pedeNum)));
				JOptionPane.showMessageDialog(null,f.percorre());
			}
			
			//remove dois valores da fila, a fim de testar
			JOptionPane.showMessageDialog(null, f.remove());
			JOptionPane.showMessageDialog(null, f.remove());
			
			//adiciona mais um valor na fila para testar se vai para o lugar certo.
			f.adiciona(Integer.parseInt(JOptionPane.showInputDialog(pedeNum)));
			JOptionPane.showMessageDialog(null,f.percorre());
			
			break;
		case "2":
			//recebe o tamanho desejado para a fila
			tamanho = Integer.parseInt(JOptionPane.showInputDialog(qtd));
			
			//instancia a fila passando a quantidade de valores como parametro
			FilaCircular fc = new FilaCircular(tamanho);
			
			//laço para arcazenar valores na fila
			for (int i = 0; i<tamanho;i++){
				fc.adiciona(Integer.parseInt(JOptionPane.showInputDialog(pedeNum)));
				JOptionPane.showMessageDialog(null,fc.percorre());
			}
			
			//remove dois valores da fila, a fim de testar
			JOptionPane.showMessageDialog(null, fc.remove());
			JOptionPane.showMessageDialog(null, fc.remove());
			
			//adiciona mais um valor na fila para testar se vai para o lugar certo.
			fc.adiciona(Integer.parseInt(JOptionPane.showInputDialog(pedeNum)));
			JOptionPane.showMessageDialog(null,fc.percorre());
			
			
			break;
		case "3":
			//recebe o tamanho desejado para a pilha
			tamanho = Integer.parseInt(JOptionPane.showInputDialog(qtd));
			
			//instancia a pilha passando a quantidade de valores como parametro
			Pilha p = new Pilha(tamanho);
			
			//laço para arcazenar valores na pilha
			for (int i = 0; i<tamanho;i++){
				p.empilha(Integer.parseInt(JOptionPane.showInputDialog(pedeNum)));
				JOptionPane.showMessageDialog(null,p.mostra());
			}
			
			//remove dois valores da pilha, a fim de testar
			JOptionPane.showMessageDialog(null, p.desempilha());
			JOptionPane.showMessageDialog(null, p.desempilha());
			
			//adiciona mais um valor na pilha para testar se vai para o lugar certo.
			p.empilha(Integer.parseInt(JOptionPane.showInputDialog(pedeNum)));
			JOptionPane.showMessageDialog(null,p.mostra());
			
			break;
		default:
			System.exit(0);
			break;
		}

	}

}
