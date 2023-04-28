package Tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

import com.company.CLI;
import com.company.Graph;

public class CLITest {
    
    CLI cli =new CLI();
    @Test
    public void testSrc_to_all_solverd1() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test5");
        ArrayList<Integer> cost = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        int source=0;
        int destination=3;
        for(int i = 0; i < mygraph.getSize(); i++) {
            parent.add(-1);
            cost.add(0);
        }
        mygraph.dijkstra(cost, parent, source);
        int c =  cost.get(destination);

        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(parent.get(destination));
            destination = parent.get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing Dijkstra 1", path, "0->4->3");
        assertEquals("Testing Dijkstra 1", c,2);
    }
    @Test
    public void testSrc_to_all_solverb1() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test5");
        ArrayList<Integer> cost = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        int source=0;
        int destination=3;
        for(int i = 0; i < mygraph.getSize(); i++) {
            parent.add(-1);
            cost.add(0);
        }
        mygraph.bellman_ford(cost, parent, source);
        int c =  cost.get(destination);
        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(parent.get(destination));
            destination = parent.get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing bellmanford 1", path, "0->4->3");
        assertEquals("Testing bellmanford 1", c,2);



    }  
    
    
    @Test
    public void testSrc_to_all_solverf1() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test5");
        ArrayList<ArrayList<Integer>> costs = new ArrayList<>();
        ArrayList<ArrayList<Integer>> predecessors = new ArrayList<>();
        mygraph.floyd_warshall(costs, predecessors);
        int source=0;
        int destination=3;
        int c = costs.get(source).get(destination);

        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(predecessors.get(source).get(destination));
            destination = predecessors.get(source).get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing floydwarshall 1", path, "0->4->3");
        assertEquals("Testing floydwarshall 1", c,2);
        
    }
    
    @Test
    public void testSrc_to_all_solverd2() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test20");
        ArrayList<Integer> cost = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        int source=2;
        int destination=15;
        for(int i = 0; i < mygraph.getSize(); i++) {
            parent.add(-1);
            cost.add(0);
        }
        mygraph.dijkstra(cost, parent, source);
        int c =  cost.get(destination);

        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(parent.get(destination));
            destination = parent.get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing Dijkstra 2", path, "2->7->15");
        assertEquals("Testing Dijkstra 2", c,14);
    }
    @Test
    public void testSrc_to_all_solverb2() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test20");
        ArrayList<Integer> cost = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        int source=2;
        int destination=15;
        for(int i = 0; i < mygraph.getSize(); i++) {
            parent.add(-1);
            cost.add(0);
        }
        mygraph.bellman_ford(cost, parent, source);
        int c =  cost.get(destination);
        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(parent.get(destination));
            destination = parent.get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing bellmanford 2", path, "2->7->15");
        assertEquals("Testing bellmanford 2", c,14);



    }  
    
    
    @Test
    public void testSrc_to_all_solverf2() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test20");
        ArrayList<ArrayList<Integer>> costs = new ArrayList<>();
        ArrayList<ArrayList<Integer>> predecessors = new ArrayList<>();
        mygraph.floyd_warshall(costs, predecessors);
        int source=2;
        int destination=15;
        int c = costs.get(source).get(destination);

        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(predecessors.get(source).get(destination));
            destination = predecessors.get(source).get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing floydwarshall 2", path, "2->7->15");
        assertEquals("Testing floydwarshall 2", c,14);
        
    
    }

    @Test
    public void testSrc_to_all_solverd3() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test40");
        ArrayList<Integer> cost = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        int source=25;
        int destination=32;
        for(int i = 0; i < mygraph.getSize(); i++) {
            parent.add(-1);
            cost.add(0);
        }
        mygraph.dijkstra(cost, parent, source);
        int c =  cost.get(destination);

        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(parent.get(destination));
            destination = parent.get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing Dijkstra 3", path, "25->10->32");
        assertEquals("Testing Dijkstra 3", c,5);
    }
    @Test
    public void testSrc_to_all_solverb3() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test40");
        ArrayList<Integer> cost = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        int source=25;
        int destination=32;
        for(int i = 0; i < mygraph.getSize(); i++) {
            parent.add(-1);
            cost.add(0);
        }
        mygraph.bellman_ford(cost, parent, source);
        int c =  cost.get(destination);
        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(parent.get(destination));
            destination = parent.get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing bellmanford 3", path, "25->3->15->32");
        assertEquals("Testing bellmanford 3", c,5);

    }  
    
    
    @Test
    public void testSrc_to_all_solverf3() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test40");
        ArrayList<ArrayList<Integer>> costs = new ArrayList<>();
        ArrayList<ArrayList<Integer>> predecessors = new ArrayList<>();
        mygraph.floyd_warshall(costs, predecessors);
        int source=25;
        int destination=32;
        int c = costs.get(source).get(destination);

        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(predecessors.get(source).get(destination));
            destination = predecessors.get(source).get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing floydwarshall 3", path, "25->10->32");
        assertEquals("Testing floydwarshall 3", c,5);
        
    
    }
    


    @Test
    public void testAll_to_all_solverd1() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test20");
        ArrayList<ArrayList<Integer>> allCosts = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allParents = new ArrayList<>();
        int source=2;
        int destination=7;
        for(int i = 0; i < mygraph.getSize(); i++)
                {
                    ArrayList<Integer> parent = new ArrayList<>();
                    ArrayList<Integer> cost = new ArrayList<>();
                    for(int j = 0; j < mygraph.getSize(); j++) {
                        parent.add(-1);
                        cost.add(0);
                    }
                    mygraph.dijkstra(cost, parent, i);
                    allCosts.add(cost);
                    allParents.add(parent);
            }
        int c =  allCosts.get(source).get(destination);

        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(allParents.get(source).get(destination));
            destination = allParents.get(source).get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing all to all dijkstra 1", path, "2->7");
        assertEquals("Testing all to all dijkstra 1", c,6);
    }
        
    @Test
    public void testAll_to_all_solverb1() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test20");
        ArrayList<ArrayList<Integer>> allCosts = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allParents = new ArrayList<>();
        int source=2;
        int destination=7;
        for(int i = 0; i < mygraph.getSize(); i++)
        {
            ArrayList<Integer> parent = new ArrayList<>();
            ArrayList<Integer> cost = new ArrayList<>();
            for(int j = 0; j < mygraph.getSize(); j++) {
                parent.add(-1);
                cost.add(0);
            }
            mygraph.bellman_ford(cost, parent, i);
            allCosts.add(cost);
            allParents.add(parent);
        }        
        int c =  allCosts.get(source).get(destination);

        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(allParents.get(source).get(destination));
            destination = allParents.get(source).get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing all to all bellman-ford 1", path, "2->7");
        assertEquals("Testing all to all bellman-ford 1", c,6);
        
    
    
    
    }    
    @Test
    public void testAll_to_all_solverf1() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test20");
        ArrayList<ArrayList<Integer>> allCosts = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allParents = new ArrayList<>();
        int source=2;
        int destination=7;
        mygraph.floyd_warshall(allCosts, allParents);
        int c =  allCosts.get(source).get(destination);
        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(allParents.get(source).get(destination));
            destination = allParents.get(source).get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing all to all floyd-warshall 1", path, "2->7");
        assertEquals("Testing all to all floyd-warshall 1", c,6);
    }   
    
    
    @Test
    public void testAll_to_all_solverd2() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test40");
        ArrayList<ArrayList<Integer>> allCosts = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allParents = new ArrayList<>();
        int source=23;
        int destination=17;
        for(int i = 0; i < mygraph.getSize(); i++)
                {
                    ArrayList<Integer> parent = new ArrayList<>();
                    ArrayList<Integer> cost = new ArrayList<>();
                    for(int j = 0; j < mygraph.getSize(); j++) {
                        parent.add(-1);
                        cost.add(0);
                    }
                    mygraph.dijkstra(cost, parent, i);
                    allCosts.add(cost);
                    allParents.add(parent);
            }
        int c =  allCosts.get(source).get(destination);

        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(allParents.get(source).get(destination));
            destination = allParents.get(source).get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing all to all dijkstra 2", path, "23->16->17");
        assertEquals("Testing all to all dijkstra 1", c,2);
    }
        
    @Test
    public void testAll_to_all_solverb2() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test40");
        ArrayList<ArrayList<Integer>> allCosts = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allParents = new ArrayList<>();
        int source=23;
        int destination=17;
        for(int i = 0; i < mygraph.getSize(); i++)
        {
            ArrayList<Integer> parent = new ArrayList<>();
            ArrayList<Integer> cost = new ArrayList<>();
            for(int j = 0; j < mygraph.getSize(); j++) {
                parent.add(-1);
                cost.add(0);
            }
            mygraph.bellman_ford(cost, parent, i);
            allCosts.add(cost);
            allParents.add(parent);
        }        
        int c =  allCosts.get(source).get(destination);

        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(allParents.get(source).get(destination));
            destination = allParents.get(source).get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing all to all bellman-ford 2", path, "23->16->17");
        assertEquals("Testing all to all bellman-ford 2", c,2);
    
    }    

    @Test
    public void testAll_to_all_solverf2() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test40");
        ArrayList<ArrayList<Integer>> allCosts = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allParents = new ArrayList<>();
        int source=23;
        int destination=17;
        mygraph.floyd_warshall(allCosts, allParents);
        int c =  allCosts.get(source).get(destination);
        String path = "";
        Stack s =new Stack();
        s.push(destination);
        while(destination != source)
        {
            s.push(allParents.get(source).get(destination));
            destination = allParents.get(source).get(destination);
        }
        while(!s.empty()){
            path=path+ s.pop();
            if(!s.empty()){
                path+="->";
            }
        }
        assertEquals("Testing all to all floyd-warshall 2", path, "23->16->17");
        assertEquals("Testing all to all floyd-warshall 2", c,2);
    }   
    

    @Test
    public void testCycle_check_solverb1() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test5n");
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> cost = new ArrayList<>();
        boolean cycles=true;
        for(int i = 0; i < mygraph.getSize(); i++){
                for(int j = 0; j < mygraph.getSize(); j++) {
                    parent.add(-1);
                    cost.add(0);
                }
                cycles = mygraph.bellman_ford(cost, parent, i);
                if(!cycles){
                    break;
                }
            }
        assertEquals("Checking negative cycles with bellman-ford 1", false, cycles);
    
    
    
    }
    @Test
    public void testCycle_check_solverf1() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test5n");
        ArrayList<ArrayList<Integer>> allCosts = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allParents = new ArrayList<>();
        boolean cycles = mygraph.floyd_warshall(allCosts, allParents);
        assertEquals("Checking negative cycles with floyd-warshall 1", false,cycles);
    
    }
    
    
    @Test
    public void testCycle_check_solverb2() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test40");
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> cost = new ArrayList<>();
        boolean cycles=true;
        for(int i = 0; i < mygraph.getSize(); i++){
                for(int j = 0; j < mygraph.getSize(); j++) {
                    parent.add(-1);
                    cost.add(0);
                }
                cycles = mygraph.bellman_ford(cost, parent, i);
                if(!cycles){
                    break;
                }
            }
        assertEquals("Checking negative cycles with bellman-ford 2", true, cycles);
    

    }   
    
    @Test
    public void testCycle_check_solverf2() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test5n");
        ArrayList<ArrayList<Integer>> allCosts = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allParents = new ArrayList<>();
        boolean cycles = mygraph.floyd_warshall(allCosts, allParents);
        assertEquals("Checking negative cycles with floyd-warshall 2", false,cycles);    
    }
}
