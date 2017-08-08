import java.util.Arrays;
import java.util.Random;

public class CampoDeTeste{

	private int[][] matriz;
	private int linhas;
	private int colunas;
	private int q;
	

	public CampoDeTeste(int m, int n, int q) {
		this.linhas = m;
		this.colunas = n;
		this.q = q;

		matriz = new int[linhas][colunas];
		for(int l=0; l<linhas; l++){
			for(int c=0; c<colunas; c++){
				matriz[l][c] = 0;	
			}
		}
		//até aqui o construtor gera a matriz zeros do tamanho que quizermos (m linhas, n colunas)
		//a próxima linha chama o método para adicionar as bombas
		this.preencheBombas(q);
	}
	 

	public void imprimeCampoDeTeste(){
		for(int l=0; l<linhas; l++){
			for (int c=0; c<colunas; c++){
				System.out.print(matriz[l][c]+",");
			}
			System.out.println();
		}		
	}

	private void preencheBombas(int q) {

		Random gerador = new Random();
		//numero de bombas q
		int bombas = q;
		//numero de elementos da matriz
		int linh = 5;
		int colun = 5;

		//imprime sequência de (bombas) com as posições aleatorios
		//numero1 e numero2 a seguir são os indices, da matriz, sorteados randomicamente, onde as bombas serão alocadas
		for (int i = 0; i < bombas; i++) {
			int numero1 = gerador.nextInt();
			if (numero1 < 0){
				numero1 *= -1;
			}
			while (numero1 > linh){
				numero1 /=10;
			}
			System.out.println("numero1: "+numero1);
			int numero2 = gerador.nextInt();
			if (numero2 < 0){
				numero2 *= -1;
			}
			while (numero2 > colun){
				numero2 /=10;
			}
			System.out.println("numero2: "+numero2);
			if(matriz[numero1][numero2]==0){
				matriz[numero1][numero2]=-1;
			} else { bombas +=1;}
		}
	}

	// private void preencheQuantasBombasNaVizinhanca(int m, int n){
	// 	int bombasVizinho = 0;
	// 	int linhas = m;
	// 	int colunas = n;
	// 	for (i=0;i<linhas;i++){
	// 		for(j=0;j<colunas;j++){
	// 			if (matriz[i][j]!=-1){

	// 			}

	// 		}

	// 	}
	// }

	public static void main (String[] args){
		CampoDeTeste campo1 = new CampoDeTeste(10,10,10);
		campo1.imprimeCampoDeTeste();
	}


}





