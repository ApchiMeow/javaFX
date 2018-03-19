package com.apchimeow.javafx;

public class ProceduralGrid {

    private static Vector3[] vertices;
    private static int[] triangles;

    //параметры сетки
    private static float cellSize = 1; // размер ячейки
    private static int gridSize = 1; // размер сетки

    public static void main(String[] args) {
        MakeContiguousProceduralGrid();
    }

    private static void MakeContiguousProceduralGrid() {
        vertices = new Vector3[(gridSize + 1) * (gridSize + 1)];
        triangles = new int[gridSize * gridSize * 6];

        int v = 0;
        int t = 0;

        for (int x = 0; x <= gridSize; x++) {
            for (int y = 0; y <= gridSize; y++) {
                vertices[v] = new Vector3(x * cellSize, 0, y * cellSize);
                v++;
            }
        }

        v = 0;

        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                triangles[t] = v;
                triangles[t + 1] = triangles[t + 4] = v + 1;
                triangles[t + 2] = triangles[t + 3] = v + (gridSize + 1);
                triangles[t + 5] = v + (gridSize + 1) + 1;
                v++;
                t += 6;
            }
            v++;
        }
    }
}