package controller;

public class ThreadConc extends Thread{
	
	private String conc;
	private long time;
	
	
	public ThreadConc() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		Concatena();
	}
	
	private void Concatena(){
		time = System.currentTimeMillis();
		for (int i=0; i<32768;i++)
			conc = conc + ".";
		time = (System.currentTimeMillis()) - time;
		System.out.println("TEMPO CONCATENANDO: "+ time + " ms");
	}
}
