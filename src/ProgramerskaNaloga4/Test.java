package APS2.ProgramerskaNaloga4;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        // test 1
        System.out.println("TEST 1");
        GRPH testni = new GRPH(5);
        testni.addEdge(0, 1, 10);
        testni.addEdge(0, 2, 8);
        testni.addEdge(1, 3, -1);
        testni.addEdge(2, 3, 2);
        testni.addEdge(3, 4, 2);
        testni.addEdge(4, 1, -3);

        System.out.println(testni.najkrajsa(0, 4, new HashSet<>())); //11
        System.out.println(testni.najkrajsa(0, 1, new HashSet<>())); //5

        // test 2
        System.out.println("\nTEST 2");
        GRPH g = new GRPH(4);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 3, 2);
        g.addEdge(1, 2, 3);
        g.addEdge(3, 2, 1);
        g.printShortestDistsFrom(0);

        // test 3
        System.out.println("\nTEST 3");
        g = new GRPH(4);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 3, 2);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, -1);
        g.addEdge(3, 2, 1);
        g.printShortestDistsFrom(0);

        // test 4
        System.out.println("\nTEST 4");
        g = new GRPH(5);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 3, 2);
        g.addEdge(1, 2, 3);
        g.addEdge(3, 2, 1);
        g.printShortestDistsFrom(0);

        // test 5
        System.out.println("\nTEST 5");
        int[][] cells = new int[][] { { 0, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 0 },
                { 0, 1, 0, 1, 0 },
                { 0, 1, 0, 1, 0 },
                { 0, 0, 0, 0, 0 } };

        LBR l = new LBR(cells);
        l.printPath(15, 1);

        // test 6
        System.out.println("\nTEST 6");
        cells = new int[][] { { 0, 0, 0, 1 },
                { 0, 0, 1, 0 },
                { 0, 1, 0, 0 },
                { 1, 0, 0, 0 } };

        l = new LBR(cells);
        l.printPath(1, 16);

        // test 7
        System.out.println("\nTEST 7");
        int[][] labirint = new int[][] { {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0} };
        LBR lab = new LBR(labirint);
        lab.printPath(61, 28);
    }
}