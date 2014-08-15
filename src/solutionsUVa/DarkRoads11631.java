package solutionsUVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class DarkRoads11631 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int totalNos, totalArestas;
		int no1, no2, peso;
		ArrayList<Node> kurshal;
		Union_Find_Set U;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			totalNos = Integer.parseInt(st.nextToken());
			totalArestas = Integer.parseInt(st.nextToken());

			if (totalNos == 0 & totalArestas == 0)
				break;

			int all = 0;
			int custoPath = 0;
			int arestasPath = 0;

			kurshal = new ArrayList<Node>();
			U = new Union_Find_Set(totalNos + 1);

			for (int i = 0; i < totalArestas; i++) {
				st = new StringTokenizer(br.readLine());
				no1 = Integer.parseInt(st.nextToken());
				no2 = Integer.parseInt(st.nextToken());
				peso = Integer.parseInt(st.nextToken());
				all += peso;
				kurshal.add(new Node(no1, no2, peso));
			}
			Collections.sort(kurshal);

			Node noDaVez;

			for (int i = 0; i < totalArestas | arestasPath < totalNos - 1; i++) {
				noDaVez = kurshal.get(i);
				if (!U.isInTheSameSet(noDaVez.no1, noDaVez.no2)) {
					arestasPath++;
					custoPath += noDaVez.aresta;
					U.merge(noDaVez.no1, noDaVez.no2);
				}
			}

			System.out.println(all - custoPath);
		}

		br.close();
	}

	public static class Node implements Comparable<Node> {
		int no1, no2, aresta;
		Node(int a, int b, int w) {
			this.no1 = a;
			this.no2 = b;
			this.aresta = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.aresta - o.aresta;
		}
	}

	public static class Union_Find_Set {

		int[] parent;

		Union_Find_Set(int x) {
			parent = new int[x];
			for (int i = 0; i < x; i++)
				parent[i] = i;
		}

		int find(int a) {
			if (parent[a] == a) {
				return a;
			}
			return parent[a] = find(parent[a]);
		}

		void merge(int a, int b) {
			parent[find(a)] = find(b);
		}

		boolean isInTheSameSet(int a, int b) {
			return find(a) == find(b);
		}
	}
}
