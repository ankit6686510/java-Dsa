import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/course-schedule/description/
public class Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());
        for (int[] pre : prerequisites)
            graph.get(pre[1]).add(pre[0]);

        int[] visited = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited))
                return false;
        }

        return true;
    }

    private boolean dfs(int course, List<List<Integer>> graph, int[] visited) {
        if (visited[course] == 1)
            return false;
        if (visited[course] == 2)
            return true;

        visited[course] = 1;
        for (int next : graph.get(course)) {
            if (!dfs(next, graph, visited))
                return false;
        }

        visited[course] = 2;
        return true;
    }
}
