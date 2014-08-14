package solutionsUVa;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 - a[j] - the smallest value which ends an increasing sequence of length j
 - values[]  - stores the values 
 - prev[i] - stores the previous value in the sequence for position i
 */

public class WhatGoesUp481 {


	public static void main(String[] args) {
		List<Integer> entradas = new ArrayList<Integer>();
		List<Integer> sequencia = new ArrayList<Integer>();
		List<Integer> posicoes = new ArrayList<Integer>();
		List<Integer> prev = new ArrayList<Integer>();
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int n;
		int pos;
		int i = 0;

		while (sc.hasNext()) {

			n = sc.nextInt();

			if (sequencia.size() > 0 && n > sequencia.get(0)) {
				pos = Collections.binarySearch(sequencia, n);
				if (pos < 0) {
					pos = -(pos + 1);
				}
			} else {
				if (sequencia.size() > 0) {
					sequencia.set(0, n);
					posicoes.set(0, i);
				} else {
					sequencia.add(0, n);
					posicoes.add(0, i);
				}
				pos = 0;
			}

			if (pos >= 0) {
				if (pos < sequencia.size()) {
					if (sequencia.get(pos) >= n) {
						sequencia.set(pos, n);
						posicoes.set(pos, i);
					}
				} else {
					sequencia.add(pos, n);
					posicoes.add(pos, i);
				}
			}

			if (pos >= 1)
				prev.add(i, posicoes.get(pos - 1));
			else
				prev.add(i, -1);

			entradas.add(n);

			i++;
		}

		pos = posicoes.get(posicoes.size() - 1);

		Stack<Integer> pilha = new Stack<Integer>();
		while (pos != -1) {
			pilha.push(entradas.get(pos));
			pos = prev.get(pos);
		}

		System.out.println(sequencia.size());
		System.out.println("-");
		while (!pilha.isEmpty()) {
			System.out.println(pilha.pop());
		}

		sc.close();
	}
}
