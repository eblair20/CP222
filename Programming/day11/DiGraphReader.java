import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    // Fields needed for the Graph Reader should be added here
    INode<String> start;
    INode<String> destination;
    Double weight;

    String[] word_array;
    /**
     * Creates a new graph reader instance
     */
    public DiGraphReader() {
        // Configure the graph reader here
        start = null;
        destination = null;
        weight = 0.0;
    }

    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
        // Open the file
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        IGraph<String,Double> graph = new Graph<String,Double>();

        //Parse the lines. If a line does not have exactly 3 fields, ignore the line
        // For each line, add the nodes and edge
        String lines = reader.readLine();
        while(lines != null) {
          word_array = lines.split(":");

          weight = Double.parseDouble(word_array[2]);
          start = graph.addNode(word_array[0]);
          destination = graph.addNode(word_array[1]);

          graph.addEdge(start, destination, weight);

          lines = reader.readLine();
        }

        // Return the graph instance
        return graph;
    }

    /**
     * Simple main method to open and process a file
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
    }

  }
