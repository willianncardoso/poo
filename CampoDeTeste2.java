import java.util.*;

public class CampoDeTeste2 extends CampoDeTeste {
	// Indica se a posicao estah:
	// 0:fechada
	// 1:aberta
	// 2:marcada com B pois acho que eh uma bomba!
	private int[][] rotulo;

	// Quantidade de marcas B no campo minado.
	private int qm;

	// Construtor.
	// Reutiliza o construtor da superclasse.
	// Inicializa atributos adicionais da subclasse.
	public CampoDeTeste2(int m, int n, int q) {
		super(m, n, q);
		this.rotulo = new int[m][n];
	}

	// Metodo sobrecarregado para imprimir o campo minado na tela.
	// Desta vez imprime:
	// '.' para posicao fechada,
	// 'B' para marcado,
	// '*' para bomba!
	public void imprimeCampoDeTeste() {
		int m = this.matriz.length;
		int n = this.matriz[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (this.rotulo[i][j] == 0) { // fechado
					System.out.print(". ");
				}
				else if (this.rotulo[i][j] == 2) { // marcado
					System.out.print("B ");
				}
				else {
					if (this.matriz[i][j] == -1) {
						System.out.print("* ");
					}
					else {
						System.out.print(this.matriz[i][j]+" ");
					}
				}
			}
			System.out.println();
		}
	}

	// Metodo recursivo para abrir posicao atual e seus vizinhos.
	// Recebe a posicao atual (i,j).
	// Se a posicao atual for zero na matriz, temos que olhar seus
	// 8 vizinhos.

	private void abreAtualEVizinhos(int i, int j) {
	// Base da recursão:
		if (this.rotulo[i][j] == 0){
			this.rotulo[i][j] = 1;

			if (this.contaBombasNaVizinhanca(i,j) == 0){
				for(int ii=i-1;ii<=i+1;ii++){
					for(int jj=j-1;jj<=j+1;jj++){
						if(ii>=0 && jj>=0 && ii<this.matriz.length && jj<this.matriz[0].length && matriz[ii][jj]!=-1){
							abreAtualEVizinhos(ii, jj);
						}
					}
				}	
			}
		}
	}
	
	// Metodo que processa cada passo do jogador.
	// Recebe a operacao (abrir/marcar) e a posicao a ser aberta/marcada.
	// A funcao que devolve:
	// 0 se não terminou o jogo,
	// 1 se o usuario ganhou (todas as posicoes abertas sem estourar),
	// -1 se o usuario perdeu (estourou uma bomba).
	
	public int jogaCampoMinado(int operacao, int i, int j) {
		int resultado=0;
		if (operacao == 1){
			this.abreAtualEVizinhos(i,j);
			if(this.rotulo[i][j]==-1){
				resultado = -1;
				return resultado; 
			}
		}
		if (operacao == 2){
			this.rotulo[i][j] =2;
			resultado = 0;
			return resultado;
		}
	}

	public static void main( String args[] ) {

		// Inicializamos com os parametros do jogo do celular.
		int m = 9; // Total de linhas da matriz.
		int n = 9; // Todal de colunas.
		int q = 10; // Total de bombas.

		CampoDeTeste2 C = new CampoDeTeste2(m, n, q);
		// Algumas variaveis auxiliares:
		// - operacao: 1:abrir, 2:marcar.
		// - (i,j): linha, coluna.
		// - resultado da jogada: 0:continua, 1:ganhou, -1:perdeu.
		int operacao, i, j, resultado;

		// Executa o jogo enquanto o resultado da jogada for zero.
		do {	
			// Exibe a matriz na tela.
			C.imprimeCampoDeTeste();

			// Pede para usuario digitar a operacao: abrir ou marcar posicao.
			System.out.print("\nDigite a operacao (1: abrir; 2: marcar/desmarcar): ");
			operacao = Teclado.leInteiro();

			// Pede a posicao da matriz.
			System.out.print("Digite a linha (comeca de 0): ");
			i = Teclado.leInteiro();
			System.out.print("Digite a coluna (comeca de 0): ");
			j = Teclado.leInteiro();

			// Faz a jogada.
			resultado = C.jogaCampoMinado(operacao, i, j);
		} while (resultado == 0);

		// Neste ponto, o jogo terminou.
		// Exibe a matriz na tela e a mensagem se ganhou ou perdeu.
		C.imprimeCampoDeTeste();
		if (resultado == -1) {
			System.out.println("Voce perdeu!");
		}
		else {
			System.out.println("Voce ganhou!");
		}
	}
} 