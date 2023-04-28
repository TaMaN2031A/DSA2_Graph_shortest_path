package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class CLI {
    Graph graph;
    Scanner in = new Scanner(System.in);
    FileWriter writer;

    int method_picker(int options)
    {
        int sub_menu = 0;
        if(options == 3)
        {
            System.out.println("1. Bellman-Ford");
            System.out.println("2. Floyd-Warshall");
            System.out.println("3. Dijkstra");
            try{
            while (sub_menu < 1 || sub_menu > 3)
                sub_menu = Integer.parseInt(in.nextLine());
            }catch(Exception e){
                System.out.println("Please Enter a Valid Option!");
            }
            }
        else
        {
            System.out.println("1. Bellman-Ford");
            System.out.println("2. Floyd-Warshall");
            try{
                while (sub_menu < 1 || sub_menu > 2)
                    sub_menu = Integer.parseInt(in.nextLine());
            }catch(Exception e){
                    System.out.println("Please Enter a Valid Option!");
            }
        }
        return sub_menu;
    }
    public void print_path(ArrayList<Integer> parents, int dest, int src)
    {
        String path = "";
        Stack s =new Stack();
        s.push(dest);
        while(dest != src)
        {
            s.push(parents.get(dest));
            dest = parents.get(dest);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        System.out.println(path);
    }

    void initialize() throws IOException {
        System.out.println("Insert the path to construct the graph");
           try {
                Scanner in = new Scanner(System.in);
                String path = in.nextLine();
                graph = new Graph(path);
                mainMenu();
            }
            catch (Exception e) {
                System.out.println("Please check the path or the file you supplied!");
            }
    }
    void mainMenu() throws IOException
    {
        while(true) {
            System.out.println("Pick your required sub-menu");
            System.out.println("1. src to all");
            System.out.println("2. all to all");
            System.out.println("3. cycle checker");
            int sub_menu = 0;
        try{
            while (sub_menu!=1 && sub_menu!=2 && sub_menu!=3 )
                sub_menu = Integer.parseInt(in.nextLine());
            if (sub_menu == 1)
                src_to_all_solver();
            else if (sub_menu == 2)
                all_to_all_solver();
            else if (sub_menu == 3)
                cycle_check_solver();
            else
                System.out.println("Please Enter a Valid Option!");
        }catch (Exception e){
            System.out.println("Please Enter an Option!");
        }
    } 
    }
    void src_to_all_solver() throws IOException
    {
        int method = method_picker(3); // All three options
        int source = -1;
        try {
            while(source < 0 || source >= graph.getSize()) {
                System.out.println("Please give us the source node");
                source = Integer.parseInt(in.nextLine());
            }
            if (method == 2) { // Floyd warshall
                ArrayList<ArrayList<Integer>> costs = new ArrayList<>();
                ArrayList<ArrayList<Integer>> predecessors = new ArrayList<>();
                long start=System.nanoTime();
                graph.floyd_warshall(costs, predecessors);
                long end=System.nanoTime();
                while(true) {
                    int destination = -2;
                    while (destination != -1 && (destination < -1 || destination >= graph.getSize())) {
                        System.out.println("Choose destination node, enter -1 to return");
                        destination = Integer.parseInt(in.nextLine());
                    }
                    if (destination == -1)
                        return;
                    int c = costs.get(source).get(destination);
                    if(c == Integer.MAX_VALUE){
                        System.out.println("No possible path");
                        System.out.println("Time taken is "+(end-start)+" nanoseconds");
                        writer = new FileWriter("srctoall_floyd.txt",true);
                        writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+"\n");
                        writer.close();
                    }
                    else {
                        System.out.println("Total cost is: " + c);
                        print_path(predecessors.get(source), destination, source);
                        System.out.println("Time taken is "+(end-start)+" nanoseconds");
                        writer = new FileWriter("srctoall_floyd.txt",true);
                        writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+"\n");
                        writer.close();
                    }
                }
            } else if(method == 1) { // Bellman ford
                ArrayList<Integer> cost = new ArrayList<>();
                ArrayList<Integer> parent = new ArrayList<>();
                for(int i = 0; i < graph.getSize(); i++) {
                    parent.add(-1);
                    cost.add(0);
                }
                long start=System.nanoTime();
                graph.bellman_ford(cost, parent, source);
                long end=System.nanoTime();
                while(true) {
                    int destination = -2;
                    while (destination != -1 && (destination < -1 || destination >= graph.getSize())) {
                        System.out.println("Choose destination node, enter -1 to return");
                        destination = Integer.parseInt(in.nextLine());
                    }
                    if (destination == -1)
                        return;
                    int c =  cost.get(destination);
                    if(c == Integer.MAX_VALUE){
                        System.out.println("No possible path");
                        System.out.println("Time taken is "+(end-start)+" nanoseconds");
                        writer = new FileWriter("srctoall_bellman.txt",true);
                        writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+"\n");
                        writer.close();
                    }
                    else {
                        System.out.println("Total cost is: " + cost.get(destination));
                        print_path(parent, destination, source);
                        System.out.println("Time taken is "+(end-start)+" nanoseconds");
                        writer = new FileWriter("srctoall_bellman.txt",true);
                        writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+"\n");
                        writer.close();
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
                long start=System.nanoTime();
                graph.dijkstra(cost, parent, source);
                long end=System.nanoTime();
                while(true) {
                    int destination = -2;
                    while (destination != -1 && (destination < -1 || destination >= graph.getSize())) {
                        System.out.println("Choose destination node, enter -1 to return");
                        destination = Integer.parseInt(in.nextLine());
                    }
                    if (destination == -1)
                        return;
                    int c =  cost.get(destination);
                    if(c == Integer.MAX_VALUE){
                        System.out.println("No possible path");
                        System.out.println("Time taken is "+(end-start)+" nanoseconds");
                        writer = new FileWriter("srctoall_dijkstra.txt",true);
                        writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+"\n");
                        writer.close();}
                    else {
                        System.out.println("Total cost is: " + cost.get(destination));
                        print_path(parent, destination, source);
                        System.out.println("Time taken is "+(end-start)+" nanoseconds");
                        writer = new FileWriter("srctoall_dijkstra.txt",true);
                        writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+"\n");
                        writer.close();
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Please Enter a Vald Option!");
        }
    }
    void all_to_all_solver() throws IOException
    {
        while (true)
        {
            int method = method_picker(3); // All three options
            ArrayList<ArrayList<Integer>> allCosts = new ArrayList<>();
            ArrayList<ArrayList<Integer>> allParents = new ArrayList<>();

            if(method == 1)
            {
                long start=System.nanoTime();
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
                long end=System.nanoTime();
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
                    if(c == Integer.MAX_VALUE){
                        System.out.println("No possible path");
                        System.out.println("Time taken is "+(end-start)+" nanoseconds");
                        writer = new FileWriter("alltoall_bellman.txt",true);
                        writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+"\n");
                        writer.close();
                    }
                    else {
                        System.out.println("Total cost is: " + c);
                        print_path(allParents.get(source), destination, source);
                        System.out.println("Time taken is "+(end-start)+" nanoseconds");
                        writer = new FileWriter("alltoall_bellman.txt",true);
                        writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+"\n");
                        writer.close();
                    }
                }
            }
            else if(method == 2)
            {   long start=System.nanoTime();
                graph.floyd_warshall(allCosts, allParents);
                long end=System.nanoTime();
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
                    if(c == Integer.MAX_VALUE){
                        System.out.println("No possible path");
                        System.out.println("Time taken is "+(end-start)+" nanoseconds");
                        writer = new FileWriter("alltoall_floyd.txt",true);
                        writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+"\n");
                        writer.close();
                    }
                    else {
                        System.out.println("Total cost is: " + c);
                        print_path(allParents.get(source), destination, source);
                        System.out.println("Time taken is "+(end-start)+" nanoseconds");
                        writer = new FileWriter("alltoall_floyd.txt",true);
                        writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+"\n");
                        writer.close();
                    }
                }
            }
            else if(method == 3)
            {   long start=System.nanoTime();
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
                long end=System.nanoTime();
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
                    if(c == Integer.MAX_VALUE){
                        System.out.println("No possible path");
                        System.out.println("Time taken is "+(end-start)+" nanoseconds");
                        writer = new FileWriter("alltoall_dijkstra.txt",true);
                        writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+"\n");
                        writer.close();
                    }
                    else {
                        System.out.println("Total cost is: " + c);
                        print_path(allParents.get(source), destination, source);
                        System.out.println("Time taken is "+(end-start)+" nanoseconds");
                        writer = new FileWriter("alltoall_dijkstra.txt",true);
                        writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+"\n");
                        writer.close();
                    }
                }
            }
        }
    }
    void cycle_check_solver() throws IOException
    {
        while (true) {
            int method = method_picker(2); // Only second and third
            if (method == 1)
            {   long start=0,end=0;
                ArrayList<Integer> parent = new ArrayList<>();
                ArrayList<Integer> cost = new ArrayList<>();
                start=System.nanoTime();
                for(int i = 0; i < graph.getSize(); i++)
                {
                    for(int j = 0; j < graph.getSize(); j++) {
                        parent.add(-1);
                        cost.add(0);
                    }
                    boolean cycles = graph.bellman_ford(cost, parent, i);
                    end=System.nanoTime();
                    if (!cycles) {
                        System.out.println("Negative cycle present");
                        System.out.println("Time taken is "+(end-start)+" nanoseconds");
                        writer = new FileWriter("checkcycles_bellman.txt",true);
                        writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+" Negative Cycle Presents"+"\n");
                        writer.close();
                        return;
                    }
                }
                System.out.println("No negative cycle detected");
                System.out.println("Time taken is "+(end-start)+" nanoseconds");
                writer = new FileWriter("checkcycles_bellman.txt",true);
                writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+" No Negative Cycles detected"+"\n");
                writer.close();
                return;
            }
            else if (method == 2)
            {   
                ArrayList<ArrayList<Integer>> allCosts = new ArrayList<>();
                ArrayList<ArrayList<Integer>> allParents = new ArrayList<>();
                long start=System.nanoTime();
                boolean cycles = graph.floyd_warshall(allCosts, allParents);
                long end=System.nanoTime();
                if (cycles){ 
                    System.out.println("No negative cycle detected");
                    System.out.println("Time taken is "+(end-start)+" nanoseconds");
                    writer = new FileWriter("checkcycles_floyd.txt",true);
                    writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+" No Negative Cycles detected"+"\n");
                    writer.close();
                } else {
                    System.out.println("Negative cycle present");
                    System.out.println("Time taken is "+(end-start)+" nanoseconds");
                    writer = new FileWriter("checkcycles_floyd.txt",true);
                    writer.write(((end-start))+" "+graph.getSize()+" "+graph.getdensity()+" Negative Cycle presents"+"\n");
                    writer.close();
                }
                return;
            }
        }
    }


}
