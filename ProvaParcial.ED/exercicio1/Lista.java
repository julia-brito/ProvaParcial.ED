package exercicio1;

public class Lista {
	No inicio, fim;
	
	// insere um nó no final da lista. Esse método será chamado pelo método inserir
	private void inserirFim(No aux) {
		if(inicio == null) {
			inicio = aux;
		} else {
			fim.prox = aux;
		}
		fim = aux;
	}
	
	//esse método deverá ser implementado de acordo com o enunciado do exercício
	private void inserirPrioridade(No aux) {
		No aux2 = inicio;
		int cont = 0;

		if (inicio == null) {
			inicio = aux;
			fim = aux;
		} else if (inicio.cor.equalsIgnoreCase("verde")){
			
			aux.prox = inicio;
			inicio = aux;


		} else if (fim.cor.equalsIgnoreCase("amarelo")) {

			inserirFim(aux);

		} else {
			
			while (aux2.cor != "verde") {

				aux2 = aux2.prox;
				cont++;
			
			}

		aux2 = inicio;
		for(int i = 0; i < cont-1; i++) {
			aux2 = aux2.prox;
		} 

		aux.prox = aux2.prox;
		aux2.prox = aux;
		
		}
		
	}
	
	// método inserir. Esse método será chamado a partir da classe Main
	public void inserir(int numero, String cor) {
		No aux = new No(numero, cor);
		if(cor.equalsIgnoreCase("verde")) {
			inserirFim(aux);
		} else {
			inserirPrioridade(aux);
		}
	}
	
	// método utilizado para imprimir os dados da lista
	public void imprimir() {
		No aux = inicio;
		while(aux != null) {
			System.out.println(aux.numero + "-" + aux.cor);
			aux = aux.prox;
		}
	}
}
