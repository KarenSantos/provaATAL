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
		ArrayList<Node> grafo;
		UnionFindSet unionFind;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			totalNos = Integer.parseInt(st.nextToken());
			totalArestas = Integer.parseInt(st.nextToken());

			if (totalNos == 0 & totalArestas == 0)
				break;

			int custoTotal = 0;
			int custoPath = 0;
			int arestasPath = 0;

			grafo = new ArrayList<Node>();
			unionFind = new UnionFindSet(totalNos + 1);

			for (int i = 0; i < totalArestas; i++) {
				st = new StringTokenizer(br.readLine());
				no1 = Integer.parseInt(st.nextToken());
				no2 = Integer.parseInt(st.nextToken());
				peso = Integer.parseInt(st.nextToken());
				custoTotal += peso;
				grafo.add(new Node(no1, no2, peso));
			}
			
			Collections.sort(grafo);

			Node noDaVez;
			
			for (int i = 0; i < totalArestas | arestasPath < totalNos - 1; i++) {
				noDaVez = grafo.get(i);
				if (!unionFind.isUnion(noDaVez.no1, noDaVez.no2)) {
					arestasPath++;
					custoPath += noDaVez.aresta;
					unionFind.union(noDaVez.no1, noDaVez.no2);
				}
			}

			System.out.println(custoTotal - custoPath);
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

	public static class UnionFindSet {

		int[] parent;

		UnionFindSet(int x) {
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

		void union(int a, int b) {
			parent[find(a)] = find(b);
		}

		boolean isUnion(int a, int b) {
			return find(a) == find(b);
		}
	}
}
