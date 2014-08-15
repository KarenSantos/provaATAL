package solutionsUVa;

import java.util.Scanner;

public class SuperSale10130 {

	static int[][] matrizPD;
	static int[] valor;
	static int[] peso;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		int totalItens;
		int pessoas;
		int ValorTotal;
		
		for (int i = 0; i < casos; i++) {
			totalItens = sc.nextInt();
			valor = new int[totalItens];
			peso = new int[totalItens];
			ValorTotal = 0;
			matrizPD = new int[40][totalItens];
			
			for (int j = 0; j < totalItens; j++) {
				valor[j] = sc.nextInt();
				peso[j] = sc.nextInt();
			}
			
			pessoas = sc.nextInt();
			for (int j = 0; j < pessoas; j++) {
				int pessoaCarrega = sc.nextInt();
				ValorTotal += solve(pessoaCarrega, totalItens - 1);
			}
			System.out.println(ValorTotal);
		}
		sc.close();
	}
	
	private static int solve(int pessoaCarrega, int item) {
		if (item < 0)
			return 0;
		else if (matrizPD[pessoaCarrega][item] != 0)
			return matrizPD[pessoaCarrega][item];
		else
			if ((pessoaCarrega >= peso[item])) 
				matrizPD[pessoaCarrega][item] = 
				Math.max(solve(pessoaCarrega, item - 1), solve(pessoaCarrega - peso[item], item - 1) + valor[item]);
			else
				matrizPD[pessoaCarrega][item] = solve(pessoaCarrega, item - 1);
			return matrizPD[pessoaCarrega][item];	
	}
}
