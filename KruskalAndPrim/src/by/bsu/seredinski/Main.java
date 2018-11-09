package by.bsu.seredinski;

import by.bsu.seredinski.algorithms.Kruskal;
import by.bsu.seredinski.entity.EdgesOfGraph;
import by.bsu.seredinski.entity.Graph;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        EdgesOfGraph edges = new EdgesOfGraph();
        int enter = 1;
        while (enter != 0) {
            System.out.println("1)Print graph\n2)Add vertex\n3)Add edge\n" +
                    "4)Delete vertex\n5)Delete edge\n6)Example\n7)Kruskal\n0)If you finished\n");
            enter = doInput();
            switch (enter) {
                case 0:
                    break;
                case 1:
                    graph.print();
                    edges.setEdgesOfGraph(graph.getMatrixOfIncidence());
                    System.out.println(edges);
                    break;
                case 2:
                    System.out.println("Enter amount of vertices");
                    graph.addVertices(doInput());
                    break;
                case 3:
                    System.out.println("Enter both vertices");
                    graph.addEdge(doInput(), doInput(), doInput());
                    break;
                case 4:
                    System.out.println("Enter vertex to delete");
                    //graph.deleteVertex(doInput() - 1);
                    break;
                case 5:
                    System.out.println("Enter both vertices");
                    graph.deleteEdge(doInput() - 1, doInput() - 1);
                    break;
                case 6: {
                    graph.addEdge(1, 2, 4);
                    graph.addEdge(1, 3, 2);
                    graph.addEdge(2, 4, 1);
                    graph.addEdge(3, 4, 2);
                    graph.addEdge(4, 5, 5);
                    break;
                }
                case 7: {
                    Kruskal.doKruskal(graph);
                }
                default:
                    System.out.println("Choose from the list\n");
                    break;
            }
        }
    }

    private static int doInput() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                return -1;
            }
        }
    }

}
