package com.company;

import org.w3c.dom.Node;

import java.util.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {

    int[][] graph;
    ArrayList<ArrayList<Integer>> graph_list = new ArrayList<>();
    int size;

    public Graph(String path) throws IOException {
        Path p = Paths.get(path);
        List<String> lines = Files.readAllLines(p);
        String[] string = lines.get(0)
                .split(" ");
        int[] arr = new int[string.length];
        int v = Integer.parseInt(string[0]);
        int e = Integer.parseInt(string[1]);
        size = v;
        graph = new int[v][v];
        for(int i = 0; i < v; i++) {
            ArrayList<Integer> edges = new ArrayList<>();
            for (int j = 0; j < v; j++) {
                graph[i][j] = 0;
            }
            graph_list.add(edges);
        }
        System.out.println("Saba7");
        for(int i = 1; i <= e; i++)
        {
            string = lines.get(i)
                    .split(" ");
            arr = new int[string.length];
            int src = Integer.parseInt(string[0]);
            int dst = Integer.parseInt(string[1]);
            int wght = Integer.parseInt(string[2]);
            graph_list.get(src).add(dst);
            graph[src][dst] = wght;
        }
    }
    int getSize()
    {
        return size;
    }
    private int get_min_dist(ArrayList<Integer> cost, boolean[] spt)
    {
        int min = Integer.MAX_VALUE, ind = -1;
        for(int i = 0; i < size; i++)
        {
            if (spt[i] == false && cost.get(i) <= min) {
                min = cost.get(i);
                ind = i;
            }
        }
        return ind;
    }
    void dijkstra(ArrayList<Integer> dist, ArrayList<Integer> parents, int src)
    {
        boolean[] shortest_path_tree_set = new boolean[getSize()];
        for(int i = 0; i < getSize(); i++) {
            dist.set(i, Integer.MAX_VALUE);
            shortest_path_tree_set[i] = false;//Shortest path from
            //Src to i is not finalized
        }
        dist.set(src, 0);
        for(int i = 0; i < size-1; i++)
        {
            int u = get_min_dist(dist, shortest_path_tree_set);
            shortest_path_tree_set[u] = true; // Only enters once
            for(int v : graph_list.get(u))
            {
                if(!shortest_path_tree_set[v] && graph[u][v] != 0
                && dist.get(u) != Integer.MAX_VALUE && dist.get(u) + graph[u][v] < dist.get(v)) {
                    dist.set(v, dist.get(u) + graph[u][v]);
                    parents.set(v, u); // Update parent
                }
            }
        }
    }
    boolean bellman_ford(ArrayList<Integer> cost, ArrayList<Integer> parents, int src)
    {
        return true;
    }
    boolean floyd_warshall(ArrayList<ArrayList<Integer>> costs, ArrayList<Integer> predecessors)
    {
        return true;
    }
}
