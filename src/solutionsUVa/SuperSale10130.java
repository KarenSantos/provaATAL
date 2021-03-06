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
		int valorTotal;

		for (int i = 0; i < casos; i++) {
			totalItens = sc.nextInt();
			valor = new int[totalItens];
			peso = new int[totalItens];
			valorTotal = 0;
			matrizPD = new int[40][totalItens];

			for (int j = 0; j < totalItens; j++) {
				valor[j] = sc.nextInt();
				peso[j] = sc.nextInt();
			}

			pessoas = sc.nextInt();
			for (int j = 0; j < pessoas; j++) {
				int pessoaCarrega = sc.nextInt();
				valorTotal += salePD(pessoaCarrega, totalItens - 1);
			}
			System.out.println(valorTotal);
		}
		sc.close();
	}

	private static int salePD(int pessoaCarrega, int item) {
		if (item < 0)
			return 0;
		else if (matrizPD[pessoaCarrega][item] != 0)
			return matrizPD[pessoaCarrega][item];
		else if ((pessoaCarrega < peso[item]))
			matrizPD[pessoaCarrega][item] = salePD(pessoaCarrega, item - 1);
		else
			matrizPD[pessoaCarrega][item] = Math.max(
					salePD(pessoaCarrega, item - 1),
					salePD(pessoaCarrega - peso[item], item - 1) + valor[item]);
		return matrizPD[pessoaCarrega][item];
	}
}
