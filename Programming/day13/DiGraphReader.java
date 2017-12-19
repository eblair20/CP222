import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class DiGraphReader implements IGraphReader {

    INode<String> destination;
    INode<String> start;
    String[] word_array;
    IGraph<String,Double> graph;
    double weight;


    public DiGraphReader() {
      weight = 0.0;
      graph = new Graph<String,Double>();
    }

    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

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

        return graph;
    }

    public static void main(String[] argv) throws Exception {
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue() + " -> "+edges[i].getDestination().getValue() + "  w: "+edges[i].getWeight());
        }
    }
}
