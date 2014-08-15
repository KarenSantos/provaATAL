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
			int pos = 0;
			int tamanho = numeros.length - 1;
			while (tamanho > 0) {
				tamanho /= 2;
				if (best[pos + tamanho] < numeros[i])
					pos += tamanho + 1;
			}
			if (best[pos] > numeros[i]) {
				indices[pos] = i;
				best[pos] = numeros[i];
				if (pos - 1 < 0) {
					parent[i] = -1;
				} else {
					parent[i] = indices[pos - 1];
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