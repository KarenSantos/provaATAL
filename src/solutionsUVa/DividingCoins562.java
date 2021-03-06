package solutionsUVa;

import java.util.*;

public class DividingCoins562 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		while (cases-- != 0) {
			int numCoins = sc.nextInt();
			int[] coins = new int[numCoins];
			int somaTotal = 0;

			for (int i = 0; i < numCoins; ++i) {
				coins[i] = sc.nextInt();
				somaTotal += coins[i];
			}

			int[][] valores = new int[numCoins + 1][somaTotal + 1];

			for (int c = 1; c <= numCoins; c++) {
				for (int s = 1; s <= somaTotal; s++) {
					valores[c][s] = valores[c - 1][s];
					if (s - coins[c - 1] >= 0)
						valores[c][s] = Math.max(coins[c - 1]
								+ valores[c - 1][s - coins[c - 1]],
								valores[c - 1][s]);
				}
			}
			
		int resposta = Integer.MAX_VALUE;
		for (int i = 0; i <= somaTotal; ++i) {
			int resto = divisao(somaTotal, valores[numCoins][i]);
			resposta = Math.min(resposta, resto);
		}
		System.out.println(resposta);
	}
	sc.close();
}

private static int divisao(int somaTotal, int somaAtual) {
	int pessoa1 = (somaTotal - somaAtual);
	int pessoa2 = pessoa1 - somaAtual;
	return Math.abs(pessoa2);
}
}
