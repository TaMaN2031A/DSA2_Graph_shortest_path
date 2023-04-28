package Tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.company.Graph;

public class GraphTest {

    @Test
    public void testGetSize() throws IOException {
        Graph mygraph= new Graph("/home/yousef/Desktop/graph/DSA2_Graph_shortest_path/src/test40");
        assertEquals("Testing Size of Graph", mygraph.getSize(),40);
    }

}
