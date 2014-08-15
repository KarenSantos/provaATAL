package solutionsUVa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DividingCoins562 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		while (cases-- != 0) {
			int numCoins = sc.nextInt();
			int[] coins = new int[numCoins];
			int sum = 0;
			
			for (int i = 0; i < coins.length; ++i) {
				coins[i] = sc.nextInt();
				sum += coins[i];
			}
			
			int[][] valores = new int[numCoins + 1][sum + 1];
			
			for (int i = 1; i <= numCoins; ++i)
				for (int s = 1; s <= sum; ++s) {
					valores[i][s] = valores[i - 1][s];
					if (s - coins[i - 1] >= 0)
						valores[i][s] = Math.max(valores[i - 1][s], coins[i - 1]
								+ valores[i - 1][s - coins[i - 1]]);
				}
			int res = Integer.MAX_VALUE;
			for (int i = 0; i <= sum; ++i)
				res = Math.min(res, f(sum, valores[numCoins][i]));
			System.out.println(res);
		}
	}

	private static int f(int sum, int nowSum) {
		return Math.abs((sum - nowSum) - nowSum);
	}
}
