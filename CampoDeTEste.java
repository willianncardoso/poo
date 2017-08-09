import java.util.Arrays;
import java.util.Random;

public class CampoDeTeste{

	protected int[][] matriz;
	protected int linhas;
	protected int colunas;
	protected int q;
	

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
		this.preencheBombas(m,n,q);
		this.preencheQuantasBombasNaVizinhanca();
	}
	 

	public void imprimeCampoFechado(){
		for(int l=0; l<linhas; l++){
			for (int c=0; c<colunas; c++){
				System.out.print("."+" ");
			}
			System.out.println();
		}		
	}

	public void imprimeCampoDeTeste(){
		for(int l=0; l<linhas; l++){
			for (int c=0; c<colunas; c++){
				System.out.print(matriz[l][c]+" ");
			}
			System.out.println();
		}
	}

	private void preencheBombas(int m, int n, int q) {

		Random gerador = new Random();
		//numero de bombas q
		int bombas = q;
		//numero de elementos da matriz
		int linh = m;
		int colun = n;

		//imprime sequência de (bombas) com as posições aleatorios
		//numero1 e numero2 a seguir são os indices, da matriz, sorteados randomicamente, onde as bombas serão alocadas
		for (int i = 0; i < bombas; i++) {
			int numero1 = gerador.nextInt();
			if (numero1 < 0){
				numero1 *= -1;
			}
			while (numero1 >= linh){
				numero1 /=10;
			}
			System.out.println("numero1: "+numero1); //-> da as posições das BOMBAS
			int numero2 = gerador.nextInt();
			if (numero2 < 0){
				numero2 *= -1;
			}
			while (numero2 >= colun){
				numero2 /=10;
			}
			System.out.println("numero2: "+numero2); //-> da as posições das BOMBAS
			if(matriz[numero1][numero2]==0){
				matriz[numero1][numero2]=-1;
			} else { bombas +=1;}
		}
	}

	private void preencheQuantasBombasNaVizinhanca(){
		int m = this.matriz.length;
		int n = this.matriz[0].length;
		for (int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if (matriz[i][j]!=-1){
					
					this.matriz[i][j]= this.contaBombasNaVizinhanca(i,j);	
				}
			}
		}
	}

	public int contaBombasNaVizinhanca(int i, int j){
		int m = this.matriz.length;
		int n = this.matriz[0].length;
		int bombasVizinho = 0;
		for(int ii=i-1;ii<=i+1;ii++){
			for(int jj=j-1;jj<=j+1;jj++){
				if(ii>=0 && jj>=0 && ii<linhas && jj<colunas && matriz[ii][jj]==-1){
					bombasVizinho +=1;
				}
			}
		}
		return bombasVizinho;
	}


	public static void main (String[] args){
		CampoDeTeste campo1 = new CampoDeTeste(4,4,1);
		campo1.imprimeCampoDeTeste();
	}


}





