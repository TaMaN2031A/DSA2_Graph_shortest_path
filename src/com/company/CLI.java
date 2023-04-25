package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CLI {
    Graph graph;
    Scanner in = new Scanner(System.in);

    int method_picker(int options)
    {
        int sub_menu = 0;
        if(options == 3)
        {
            System.out.println("1. Bellman-Ford");
            System.out.println("2. Floyd-Warshall");
            System.out.println("3. Dijkstra");
            while (sub_menu < 1 || sub_menu > 3)
                sub_menu = Integer.parseInt(in.nextLine());
        }
        else
        {
            System.out.println("1. Bellman-Ford");
            System.out.println("2. Floyd-Warshall");
            while (sub_menu < 1 || sub_menu > 2)
                sub_menu = Integer.parseInt(in.nextLine());
        }
        return sub_menu;
    }
    void print_path(ArrayList<Integer> parents, int dest, int src)
    {
        String path = "";
        path += dest;
        while(dest != src)
        {
            path = path.concat (">-"+parents.get(dest));
            dest = parents.get(dest);
        }
        for(int i = path.length()-1; i >= 0; i--)
            System.out.print(path.charAt(i));
        System.out.println();
    }

    void initialize() throws IOException {
        System.out.println("Insert the path to construct the graph");
          //  try {
                Scanner in = new Scanner(System.in);
                String path = in.nextLine();
                graph = new Graph(path);
                mainMenu();
          /*  }
            catch (Exception e) {
                System.out.println("Wrong path");
            }*/
    }
    void mainMenu()
    {
        while(true) {
            System.out.println("Pick your required sub-menu");
            System.out.println("1. src to all");
            System.out.println("2. all to all");
            System.out.println("3. cycle checker");
            int sub_menu = 0;
            while (sub_menu < 1 || sub_menu > 3)
                sub_menu = Integer.parseInt(in.nextLine());
            if (sub_menu == 1)
                src_to_all_solver();
            else if (sub_menu == 2)
                all_to_all_solver();
            else if (sub_menu == 3)
                cycle_check_solver();
        }
    }
    void src_to_all_solver()
    {
        int method = method_picker(3); // All three options
        int source = -1;
        System.out.println("HOLA");
      //  try {
            while(source < 0 || source >= graph.getSize()) {
                System.out.println("Please give us the source node");
                source = Integer.parseInt(in.nextLine());
            }
            if (method == 2) { // Floyd warshall
                ArrayList<ArrayList<Integer>> costs = new ArrayList<>();
                ArrayList<ArrayList<Integer>> predecessors = new ArrayList<>();
                graph.floyd_warshall(costs, predecessors);
                while(true) {
                    int destination = -2;
                    while (destination != -1 && (destination < -1 || destination >= graph.getSize())) {
                        System.out.println("Choose destination node, enter -1 to return");
                        destination = Integer.parseInt(in.nextLine());
                    }
                    if (destination == -1)
                        return;
                    int c = costs.get(source).get(destination);
                    if(c == Integer.MAX_VALUE)
                        System.out.println("No possible path");
                    else {
                        System.out.println("Total cost is: " + c);
                        print_path(predecessors.get(source), destination, source);
                    }
                }
            } else if(method == 1) { // Bellman ford
                ArrayList<Integer> cost = new ArrayList<>();
                ArrayList<Integer> parent = new ArrayList<>();
                for(int i = 0; i < graph.getSize(); i++) {
                    parent.add(-1);
                    cost.add(0);
                }
                graph.bellman_ford(cost, parent, source);
                while(true) {
                    int destination = -2;
                    while (destination != -1 && (destination < -1 || destination >= graph.getSize())) {
                        System.out.println("Choose destination node, enter -1 to return");
                        destination = Integer.parseInt(in.nextLine());
                    }
                    if (destination == -1)
                        return;
                    int c =  cost.get(destination);
                    if(c == Integer.MAX_VALUE)
                        System.out.println("No possible path");
                    else {
                        System.out.println("Total cost is: " + cost.get(destination));
                        print_path(parent, destination, source);
                    }
                }
            }
            else
            {
                ArrayList<Integer> cost = new ArrayList<>();
                ArrayList<Integer> parent = new ArrayList<>();
                for(int i = 0; i < graph.getSize(); i++) {
                    parent.add(-1);
                    cost.add(0);
                }
                graph.dijkstra(cost, parent, source);
                while(true) {
                    int destination = -2;
                    while (destination != -1 && (destination < -1 || destination >= graph.getSize())) {
                        System.out.println("Choose destination node, enter -1 to return");
                        destination = Integer.parseInt(in.nextLine());
                    }
                    if (destination == -1)
                        return;
                    int c =  cost.get(destination);
                    if(c == Integer.MAX_VALUE)
                        System.out.println("No possible path");
                    else {
                        System.out.println("Total cost is: " + cost.get(destination));
                        print_path(parent, destination, source);
                    }
                }
            }
      /*  }
        catch (Exception e)
        {
            System.out.println("Wrong input, retry");
        }*/
    }
    void all_to_all_solver()
    {
        while (true)
        {
            int method = method_picker(3); // All three options
            ArrayList<ArrayList<Integer>> allCosts = new ArrayList<>();
            ArrayList<ArrayList<Integer>> allParents = new ArrayList<>();

            if(method == 1)
            {
                for(int i = 0; i < graph.getSize(); i++)
                {
                    ArrayList<Integer> parent = new ArrayList<>();
                    ArrayList<Integer> cost = new ArrayList<>();
                    for(int j = 0; j < graph.getSize(); j++) {
                        parent.add(-1);
                        cost.add(0);
                    }
                    graph.bellman_ford(cost, parent, i);
                    allCosts.add(cost);
                    allParents.add(parent);
                }
                /**Queries Taking*/
                while(true) {
                    int source = -2, destination = -2;
                    while (source < 0 || source >= graph.getSize()) {
                        System.out.println("Please give us the source node");
                        source = Integer.parseInt(in.nextLine());
                    }
                    while (destination != -1 && (destination < -1 || destination >= graph.getSize())) {
                        System.out.println("Choose destination node, enter -1 to return");
                        destination = Integer.parseInt(in.nextLine());
                    }
                    if (destination == -1)
                        return;
                    int c =  allCosts.get(source).get(destination);
                    if(c == Integer.MAX_VALUE)
                        System.out.println("No possible path");
                    else {
                        System.out.println("Total cost is: " + c);
                        print_path(allParents.get(source), destination, source);
                    }
                }
            }
            else if(method == 2)
            {
                graph.floyd_warshall(allCosts, allParents);
                /**Queries Taking*/
                while(true) {
                    int source = -2, destination = -2;
                    while (source < 0 || source >= graph.getSize()) {
                        System.out.println("Please give us the source node");
                        source = Integer.parseInt(in.nextLine());
                    }
                    while (destination != -1 && (destination < -1 || destination >= graph.getSize())) {
                        System.out.println("Choose destination node, enter -1 to return");
                        destination = Integer.parseInt(in.nextLine());
                    }
                    if (destination == -1)
                        return;

                    int c =  allCosts.get(source).get(destination);
                    if(c == Integer.MAX_VALUE)
                        System.out.println("No possible path");
                    else {
                        System.out.println("Total cost is: " + c);
                        print_path(allParents.get(source), destination, source);
                    }
                }
            }
            else if(method == 3)
            {
                for(int i = 0; i < graph.getSize(); i++)
                {
                    ArrayList<Integer> parent = new ArrayList<>();
                    ArrayList<Integer> cost = new ArrayList<>();
                    for(int j = 0; j < graph.getSize(); j++) {
                        parent.add(-1);
                        cost.add(0);
                    }
                    graph.dijkstra(cost, parent, i);
                    allCosts.add(cost);
                    allParents.add(parent);
                }
                /**Queries Taking*/
                while(true) {
                    int source = -2, destination = -2;
                    while (source < 0 || source >= graph.getSize()) {
                        System.out.println("Please give us the source node");
                        source = Integer.parseInt(in.nextLine());
                    }
                    while (destination != -1 && (destination < -1 || destination >= graph.getSize())) {
                        System.out.println("Choose destination node, enter -1 to return");
                        destination = Integer.parseInt(in.nextLine());
                    }
                    if (destination == -1)
                        return;
                    int c =  allCosts.get(source).get(destination);
                    if(c == Integer.MAX_VALUE)
                        System.out.println("No possible path");
                    else {
                        System.out.println("Total cost is: " + c);
                        print_path(allParents.get(source), destination, source);
                    }
                }
            }
        }
    }
    void cycle_check_solver()
    {
        while (true) {
            int method = method_picker(2); // Only second and third
            if (method == 1)
            {
                ArrayList<Integer> parent = new ArrayList<>();
                ArrayList<Integer> cost = new ArrayList<>();
                for(int i = 0; i < graph.getSize(); i++)
                {
                    for(int j = 0; j < graph.getSize(); j++) {
                        parent.add(-1);
                        cost.add(0);
                    }
                    boolean cycles = graph.bellman_ford(cost, parent, i);
                    if (!cycles) {
                        System.out.println("Negative cycle present");
                        return;
                    }
                }
                System.out.println("No negative cycle detected");
                return;
            }
            else if (method == 2)
            {
                ArrayList<ArrayList<Integer>> allCosts = new ArrayList<>();
                ArrayList<ArrayList<Integer>> allParents = new ArrayList<>();
                boolean cycles = graph.floyd_warshall(allCosts, allParents);
                if (cycles) System.out.println("No negative cycle detected");
                else System.out.println("Negative cycle present");
                return;
            }
        }
    }


}
