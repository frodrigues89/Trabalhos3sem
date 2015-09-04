package controll;

import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;


public class ThreadTriatlo extends Thread{

	long tempoInicio, tempoFim;
	static int classifica[][] = new int[5][2];
	static int chegada=0;
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
//		try {
//				semaforo.acquire();
//				pTiro = Tiro();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}finally{
//				semaforo.release();
//			}
	
		Natação();
		tempoFim = System.currentTimeMillis();
		chegada++;
		
		tempo =(int) (tempoFim - tempoInicio);
//		pTiro = pTiro * 1000;
//		tempo = tempo - pTiro;
		
		classifica[chegada-1][0]= corredor;
		classifica[chegada-1][1]= tempo;
		
		if(chegada == 5){
			//Ordena();
			Mostra();
		}
		
	}
	private void Corrida(){
		
		int dist=0;
		while (dist <5000){
			
			int i = (int)(Math.random()*5)+20;
			dist = dist + i;
			System.out.println("Corrida:"+corredor+" "+ dist);
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
			System.out.println("Natação:"+corredor+" "+ dist);
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
				if (classifica[j][1]>classifica[j+1][1]){
					int a, b;
					a = classifica[i][0];
					b = classifica[i][1];
					classifica[i][0] = classifica[j][0];
					classifica[i][1] = classifica[j][1];
					classifica[j][0] = a;
					classifica[j][1] = b;
				}
			}
		}
		System.out.println("fim sort");
	}
	private void Mostra(){
		StringBuffer buffer = new StringBuffer();
		
		for (int i =0;i<5;i++){
			buffer.append("Atleta: ");
			buffer.append(classifica[i][0]);
			buffer.append("Tempo: ");
			double time = classifica[i][1]/1000;
			buffer.append(time);
			buffer.append("s");
			buffer.append("\n");
			System.out.println("Buffering");
		}
		
		
		System.out.println(buffer.toString());
		JOptionPane.showMessageDialog(null, buffer.toString());
	}
	
}
