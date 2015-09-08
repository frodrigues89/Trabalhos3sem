package controll;


public class Fila {
	//variáveis private para uso das filas.
	private int dados[];
	private int tamanho;
	
	
	//método construtor
	public Fila(int capacidade) {
		this.dados = new int[capacidade];
		this.tamanho = 0;
	}
	
	//método de adicionar
	public void adiciona(int e){
		if (tamanho<dados.length){
			dados[tamanho] = e;
			tamanho++;
		}else{
			System.out.println("ERRO! A fila esta cheia!");
		}
	}
	//metodo para remover o primeiro
	public int remove(){
		int r = 0;
		if(tamanho==0){
		        System.out.println("Erro! Fila Vazia");
	    }
		else{
            r=dados[0];
	    
            for (int i=0; i<tamanho-1; i++)
	        dados[i]=dados[i+1];
	    
            tamanho--;
        }
		
		
		return r;
	}
	//método percorre (para mostrar a fila em uma String
	public String percorre(){
		StringBuffer buffer = new StringBuffer();
		
		for (int i = 0; i<tamanho;i++){
			buffer.append(dados[i]);
			buffer.append(" ");
		}
		return buffer.toString();
	}
	
}
