package by.bsu.seredinski;

import by.bsu.seredinski.entity.Graph;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        int enter = 1;
        while (enter != 0) {
            System.out.println("1)Print graph\n2)Add vertex\n3)Add edge\n4)Delete vertex\n5)Delete edge\n6)Example\n0 if you finished\n");
            enter = doInput();
            switch (enter) {
                case 1:
                    graph.print();
                    break;
                case 2:
                    System.out.println("Enter amount of vertices");
                    int amount = doInput();
                    for (int i = 0; i < amount; i++) {
                        graph.addVertex();
                    }
                    break;
                case 3:
                    System.out.println("Enter both vertices");
                    graph.addEdge(doInput() - 1, doInput() - 1);
                    break;
                case 4:
                    System.out.println("Enter vertex to delete");
                    graph.deleteVertex(doInput() - 1);
                    break;
                case 5:
                    System.out.println("Enter both vertices");
                    graph.deleteEdge(doInput() - 1, doInput() - 1);
                    break;
                case 6:{
                    graph.addVertex();
                    graph.addVertex();
                    graph.addVertex();
                    graph.addVertex();
                    graph.addVertex();
                    graph.addEdge(1, 2);
                    graph.addEdge(0, 1);
                    graph.addEdge(1, 3);
                    break;
                }
                default:
                    System.out.println("Choose from the list\n");
                    break;
            }
        }
    }

    private static int doInput() throws InputMismatchException{
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return scanner.nextInt();
            }
            catch (InputMismatchException e){
                return -1;
            }
        }
    }

}
