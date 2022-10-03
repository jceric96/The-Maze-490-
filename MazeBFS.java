import java.util.LinkedList;
import java.util.Queue;

public class MazeBFS {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // BFS
        Queue<Integer> queue = new LinkedList<>();
        int xLen = maze.length, yLen = maze[0].length;
        boolean[][] visited = new boolean[xLen][yLen];
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        queue.offer(start[0] * yLen + start[1]);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            int nx = temp / yLen, ny = temp % yLen;
            if (nx == destination[0] && ny == destination[1]) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int x = nx + dx[i];
                int y = ny + dy[i];
                while (x >= 0 && x < xLen && y >= 0 && y < yLen && maze[x][y] == 0) {
                    x += dx[i];
                    y += dy[i];
                }
                x -= dx[i];
                y -= dy[i];
                if (!visited[x][y]) {
                    queue.offer(x * yLen + y);
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MazeBFS bfs = new MazeBFS();
        int[][] maze = new int[][] {
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 }
        };
        int[] start = new int[] { 0, 4 };
        int[] destination = new int[] { 3, 2 };
        System.out.println(bfs.hasPath(maze, start, destination));
    }
}
