package controll;

public class Pilha {
	private int topo, dados[];

	public Pilha(int capacidade) {
		this.topo = -1;
		this.dados = new int[capacidade];
	}
	
	public boolean vazia(){
		return topo == -1;
	}
	public boolean cheia(){
		return topo == dados.length-1;
	}
	
	
	public void empilha(int e){
		if (cheia()){
			System.out.println("ERRO! Pilha Cheia!");
		}else
			dados[++topo] = e;
		
	}	
	public int desempilha(){
		int r = -1;
		if(vazia()){
			System.out.println("ERRO! Lista Vazia!");
		}else{
			r = dados[topo];
			topo--;
		}
		return r;
		
	}
    public String mostra(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("Elementos da Pilha");
        for (int i=topo;i>=0;i--)
            buffer.append("\n" + dados[i]);
        return buffer.toString();
    }
    public int obtemTopo(){
        if(vazia()){
            System.out.println("ERRO! Pilha Vazia");
            return -1;
        }
        return dados[topo];
    }
}
