/*

Esta classe sera usada para entrar dados via teclado.

*/

// Aqui, usaremos algumas bibliotecas do Java.
import java.io.*;
import java.util.*;
public class Teclado
	{
	protected static InputStreamReader is = new InputStreamReader(System.in);
	protected static BufferedReader br = new BufferedReader(is);
	protected static StringTokenizer st;
	protected static String nt;

	// Este metodo eh privado e eh usado internamente nesta classe.
	protected static StringTokenizer getToken() throws IOException,
		NullPointerException
	{
	String s = br.readLine();
	return new StringTokenizer(s);
	}

	// Leitura de um numero inteiro. Devolve o valor lido.
	public static int leInteiro()
	{
	int i = 0;
	try
		{
		st = getToken();
		// Le os tokens da linha.
		nt = st.nextToken();
		i = Integer.parseInt(nt);
		}
		catch (IOException ioe)
		// Se erro de leitura.
		{
		System.err.println("Teclado:: Erro de entrada e saida.");
		System.exit(0);
		}
	return i;
	}
} // Fim da classe Teclado.