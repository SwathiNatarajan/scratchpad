package graphs;


import java.util.Stack;

public class DepthFirstSearch {

    private final int maxVertices = 20;

    private Vertex[] verticesList;
    private int[][] adjacencyMatrix;
    private int vertexCount;
    private Stack<Vertex> backtracker;

    public DepthFirstSearch() {
        backtracker = new java.util.Stack<>();
        verticesList = new Vertex[maxVertices];
        adjacencyMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for (int i = 0; i < maxVertices; i++) {
            for (int j = 0; j < maxVertices; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(String c) {
        verticesList[vertexCount++] = new Vertex(c);
    }

    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1;
        adjacencyMatrix[end][start] = 1;
    }

    public void compute() {
        verticesList[0].visited = true;
        backtracker.push(verticesList[0]);
    }

}
