package controll;

import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;


public class ThreadTriatlo extends Thread{

	long tempoInicio, tempoFim;
	static int classifica[][] = new int[5][2];
	int corredor;
	private Semaphore semaforo;
	
	
	public ThreadTriatlo(int corredor,Semaphore semaforo) {
		this.corredor = corredor;
		semaforo = semaforo;
	}

	@Override
	public void run() {
		Triatlo();
		
	}
	private void Triatlo(){
		int pTiro=0;
		int tempo;
		tempoInicio = System.currentTimeMillis();
		Corrida();

		//semaforo para liberar os tiros
		try {
				semaforo.acquire();
				pTiro = Tiro();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				semaforo.release();
			}
	
		Natação();
		tempoFim = System.currentTimeMillis();
		
		tempo =(int) (tempoFim - tempoInicio);
		pTiro = pTiro * 1000;
		tempo = tempo - pTiro;
		
		classifica[corredor][1]= corredor;
		classifica[corredor][2]= tempo;
		
			Ordena();
			Mostra();
		
		
	}
	private void Corrida(){
		
		int dist=0;
		while (dist <5000){
			
			int i = (int)(Math.random()*5)+20;
			dist = dist + i;
			System.out.println(corredor+" "+ dist);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	private int Tiro(){
		
		int pontuação =0;
		int tiros=0;
		int sleep;
		while (tiros < 3){
			
			//randomiza a pontuação
			int i = (int)(Math.random()*5);
			pontuação = pontuação + i;
			
			//randomiza o tempo dos tiros
			sleep = (int)(Math.random()*100)+100;
			
			tiros++; //incrementa a variavel Tiros
			
			//coloca a Thread para esperar
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return pontuação;
	}
	private void Natação(){
		int dist=0;
		while (dist <1000){
			
			int i = (int)(Math.random()*4);
			dist = dist + 10 + i;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void Ordena(){
		for (int i = 0; i<5;i++){
			for (int j = 0; j<4; i++){
				if (classifica[i][2]>classifica[j][2]){
					int a, b;
					a = classifica[i][1];
					b = classifica[i][2];
					classifica[i][1] = classifica[j][1];
					classifica[i][2] = classifica[j][2];
					classifica[j][1] = a;
					classifica[j][2] = b;
				}
			}
		}
	}
	private void Mostra(){
		StringBuffer buffer = new StringBuffer();
		
		for (int i =0;i<5;i++){
			buffer.append("Atleta: ");
			buffer.append(classifica[i][1]);
			buffer.append("Tempo: ");
			buffer.append((classifica[i][2]/1000));
			buffer.append("s");
			buffer.append("\n");
		}
		
		JOptionPane.showMessageDialog(null, buffer.toString());
	}
	
}
