package solutionsUVa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class AnodeTooFar336 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalArestas = sc.nextInt();
		int numCase = 1;
		List<Integer> vertices = new ArrayList<Integer>();
		int[][] arestas = new int[totalArestas * 2 + 100][2 + 100];

		while (totalArestas != 0) {

			for (int i = 0; i < totalArestas; i++) {
				int no1 = sc.nextInt();
				int no2 = sc.nextInt();

				if (!vertices.contains(no1))
					vertices.add(no1);

				if (!vertices.contains(no2))
					vertices.add(no2);

				arestas[i][0] = no1;
				arestas[i][1] = no2;
			}

			int noInicial = sc.nextInt();
			int ttl = sc.nextInt();

			while (!(noInicial == 0 && ttl == 0)) {
				System.out.println("Case " + numCase + ": "
						+ naoAlcancaveis(vertices, arestas, noInicial, ttl)
						+ " nodes not reachable from node " + noInicial
						+ " with TTL = " + ttl + ".");
				numCase++;
				noInicial = sc.nextInt();
				ttl = sc.nextInt();
			}
			vertices = new ArrayList<Integer>();
			arestas = new int[totalArestas * 2 + 10][2];
			totalArestas = sc.nextInt();
		}
	}

	private static int naoAlcancaveis(List<Integer> vertices, int[][] arestas,
			int noInicial, int ttl) {

		int totalVertices = vertices.size();
		List<Integer> marcados = new ArrayList<Integer>();

		Queue<Integer> fila = new LinkedList<Integer>();
		fila.add(noInicial);
		fila.add(ttl);

		marcados.add(noInicial);

		while (!fila.isEmpty()) {
			int primeiroV = fila.poll();
			int ttlV = fila.poll();
			if (ttlV > 0) {
				for (int i = 0; i < arestas.length; i++) {
					if (arestas[i][0] == primeiroV) {
						if (!marcados.contains(arestas[i][1])) {
							marcados.add(arestas[i][1]);
							fila.add(arestas[i][1]);
							fila.add(ttlV - 1);
						}
					}
					if (arestas[i][1] == primeiroV) {
						if (!marcados.contains(arestas[i][0])) {
							marcados.add(arestas[i][0]);
							fila.add(arestas[i][0]);
							fila.add(ttlV - 1);
						}
					}

				}
			}
		}
		return totalVertices - marcados.size();
	}
}
