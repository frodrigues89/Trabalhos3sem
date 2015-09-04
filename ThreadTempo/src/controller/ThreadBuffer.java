package controller;

public class ThreadBuffer extends Thread{
	
	private long time;
	
	public ThreadBuffer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		Buffer();
	}
	
	private void Buffer(){
		time = System.currentTimeMillis();
		
		StringBuffer buffer = new StringBuffer();
		
		for (int i=0; i<32768;i++)
			buffer.append(".");		
		
		time = (System.currentTimeMillis()) - time;
		System.out.println("TEMPO Buffer: "+ time + " ms");
	}
	
}
