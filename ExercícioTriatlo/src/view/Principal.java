package view;

import java.util.concurrent.Semaphore;

import controll.*;

public class Principal {
	
	public static Semaphore semaforo;
	
	public static void main(String[] args) {
		semaforo = new Semaphore(3);
		
		ThreadTriatlo atleta1 = new ThreadTriatlo(1,semaforo);
		atleta1.start();
		ThreadTriatlo atleta2 = new ThreadTriatlo(2,semaforo);
		atleta2.start();
		ThreadTriatlo atleta3 = new ThreadTriatlo(3,semaforo);
		atleta3.start();
		ThreadTriatlo atleta4 = new ThreadTriatlo(4,semaforo);
		atleta4.start();
		ThreadTriatlo atleta5 = new ThreadTriatlo(5,semaforo);
		atleta5.start();
	}

}
