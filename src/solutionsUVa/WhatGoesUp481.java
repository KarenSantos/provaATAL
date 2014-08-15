package solutionsUVa;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WhatGoesUp481 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> lst = new LinkedList<Integer>();

		String s = in.readLine();
		while (!s.equals("")) {
			s = s.trim();
			int num = Integer.parseInt(s);
			lst.add(num);
			s = in.readLine();
		}

		int[] numeros = new int[lst.size()];
		for (int i = 0; i < lst.size(); i++) {
			numeros[i] = lst.get(i);
		}

		int[] best = new int[numeros.length];
		int[] indices = new int[numeros.length];
		int[] parent = new int[numeros.length];
		Arrays.fill(best, Integer.MAX_VALUE);

		for (int i = 0; i < numeros.length; i++) {
			int l = 0;
			int len = numeros.length - 1;
			while (len > 0) {
				len /= 2;
				if (best[l + len] < numeros[i])
					l += len + 1;
			}
			if (best[l] > numeros[i]) {
				indices[l] = i;
				best[l] = numeros[i];
				if (l - 1 < 0) {
					parent[i] = -1;
				} else {
					parent[i] = indices[l - 1];
				}
			}
		}

		Stack<Integer> sequence = new Stack<Integer>();
		for (int i = numeros.length - 1; i >= 0; i--) {
			if (best[i] != Integer.MAX_VALUE) {
				int ind = indices[i];
				while (ind != -1) {
					sequence.push(numeros[ind]);
					ind = parent[ind];
				}
				break;
			}
		}
		System.out.println(sequence.size());
		System.out.println("-");
		while (!sequence.isEmpty()) {
			System.out.println(sequence.pop());
		}
	}
}