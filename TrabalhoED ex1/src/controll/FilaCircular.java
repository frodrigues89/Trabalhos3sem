package controll;

public class FilaCircular {
		//variáveis private para uso das filas.
		private int dados[],tamanho,i,f, capacidade;  
		
		//método construtor
		public FilaCircular(int capacidade) {
			this.dados = new int[capacidade];
			this.capacidade = capacidade;
			this.tamanho = 0;
			this.i = 0;
			this.f = 0;
		}
		
		public boolean vazia(){
		    return tamanho==0;
		}
		public boolean cheia(){
		    return tamanho==dados.length;
		}    
		
		
		//método de adicionar
		public void adiciona(int e){
			if (cheia()){
				System.out.println("ERRO! A fila esta cheia!");				
			}else{
				dados[f] = e;
				tamanho++;
				f++;
				if(f==dados.length)
				    f=0;
			}
		}
		//metodo para remover
		public int remove(){
			int r = 0;
			if(vazia()){
				System.out.println("Erro! Fila Vazia");
		    }
			else{
	            r=dados[i];
	            dados[i] = 0;
	            i=(i+1)%dados.length;
	            tamanho--;
	        }
						
			return r;
		}
		//método percorre (para mostrar a fila em uma String
		//dificuldades para mostrar a fila de maneira circular
		//por este motivo, estou mostrando a fila inteira, com um 0 onde estiver vazio.
		public String percorre(){
			StringBuffer buffer = new StringBuffer();
			
			for (int a = 0; a<capacidade;a++){
				buffer.append(dados[a]);
				buffer.append(" ");
			}
			return buffer.toString();
		}
		
}
