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
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int m,n;
        int a,b,w;
        ArrayList<node> kurshal;
        Union_Find_Set U ;
        while(true)
        {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
             
            if(m==0&n==0) break;
             
            int all = 0,mst_cost = 0, edge=0;
             
            kurshal = new ArrayList<node>();
            U = new Union_Find_Set(m+1);
             
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                all+=w;
                kurshal.add(new node(a,b,w));
            }
            Collections.sort(kurshal);
             
            node cur ;
             
            for (int i = 0; i < n | edge<m-1 ; i++) {
                cur = kurshal.get(i);
                if(!U.isInTheSameSet(cur.a, cur.b))
                {
                    edge++;
                    mst_cost+=cur.w;
                    U.merge(cur.a, cur.b);
                }
            }
             
            pw.println(all-mst_cost);
             
        }
         
        br.close();
        pw.close();
    }
	
	public static class node implements Comparable<node>
    {
        int a,b,w;
        node(int a,int b,int w)
        {
            this.a = a;
            this.b = b;
            this.w = w;
        }
 
        @Override
        public int compareTo(node o) {
            return this.w-o.w;
        }
         
    }
     
     
     
     
     
    public static class Union_Find_Set {
 
        int[] parent;
         
        Union_Find_Set(int x)
        {
            parent = new int[x];
            for (int i = 0; i < x; i++) parent[i] = i;
        }
         
        int find(int a)
        {
            if(parent[a]==a) return a;
            return parent[a] = find(parent[a]);
        }
         
        void merge(int a,int b)
        {
            parent[find(a)] = find(b);
        }
         
        boolean isInTheSameSet(int a, int b)
        {
            return find(a)==find(b);
        }
 
    }
	
/*

 Sort E edges by increasing weight

T = empty set

for (i=0; i<edgeList.length; i++)

  if adding e=edgelist[i] does not form a cycle

    add e to T

  else ignore e

T is an MST

 */
	
	
	
}
