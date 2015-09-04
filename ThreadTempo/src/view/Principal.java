package view;

import controller.*;

public class Principal {
	public static void main(String[] args) {
		ThreadBuffer buffer = new ThreadBuffer();
		buffer.start();
		ThreadConc conc = new ThreadConc();
		conc.start();
	}
}
