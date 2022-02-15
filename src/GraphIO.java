
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.NoSuchElementException;

import static java.lang.Integer.*;

public class GraphIO {
    static public void readFile(Graph g, String filename) throws IOException {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            int nodes = parseInt(scanner.nextLine()); // Sparar mängden noder
            int nodes_added = 0; // Håller koll på mängden noder tillagda

            while (scanner.hasNextLine()) {
                while (scanner.hasNextLine() && nodes_added < nodes) {
                    g.addNode(parseInt(scanner.next()), parseInt(scanner.next()), parseInt(scanner.next()));
                    nodes_added++;
                }
                while (scanner.hasNextLine()) {
                    g.addEdge(parseInt(scanner.next()), parseInt(scanner.next()), parseInt(scanner.next()));
                }
            }
            scanner.close();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
