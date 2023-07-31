//// 2023/07/31 // 21:40 //

//// 207. Course Schedule // Medium //

// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are
// given an array prerequisites where prerequisited[i] = [ai, bi] indicates that you must take course b1
// first if you want to take course ai.
// * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

// Return true if you can finish all courses. Otherwise, return false.

// Example 1:
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take.
// TO take course 1, you should have finished course 0. So it is possible.

// Example 2:
// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take.
// To take course 1 you should have finished course 0, and to take course 0
// you should also have finished course 1. So it is impossible.

// Constraints:
// * 1 <= numCourse <= 2000
// * 0 <= prerequisites.length <= 5000
// * 0 <= prerequisites[i].length == 2
// * 0 <= ai, bi,, < numCourses
// * All the pairs prerequisites[i] are unique.

import java.util.ArrayList;
import java.util.List;

class CourseSchedule {

    // This is a problem of finding a cycle in a directed graph. The courses are the nodes and
    // the prerequisites are the edges. If there is a cycle, then it is impossible to finish all
    // courses. Otherwise, it is possible.

    // One possible solution is to use a depth-first search (DFS) algorithm to traverse the graph
    // and mark the nodes with three states: unvisited, visiting, and visited. Unvisited means
    // the node has not been explored yet. Visiting means the node is being explored and its
    // neighbors are being visited. Visited means the node and all its neighbors have been
    // explored.

    // The algorithm starts from any unvisited node and performs a DFS. If during the DFS, we
    // encounter a node that is already in the visiting state, then we have found a cycle and we
    // can return false. If we finish the DFS without finding any cycle, then we can return true.

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build the adjacency list of the graph
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            graph[pair[0]].add(pair[1]);
        }

        // initialize the state of each node
        int[] state = new int[numCourses]; // 0: unvisited, 1: visiting, 2: visited

        // define a helper function for DFS
        private boolean dfs(int node) {
            // mark the node as visiting
            state[node] = 1;
            // loop through its neighbors
            for (int neighbor : graph[node]) {
                // if the neighbor is visiting, there is a cycle
                if (state[neighbor] == 1) {
                    return false;
                }
                // if the neighbor is unvisited, do a DFS on it
                if (state[neighbor] == 0) {
                    if (!dfs(neighbor)) {
                        return false;
                    }
                }
            }
            // makr the node as visited
            state[node] = 2;
            return true;
        }

        // loop through all nodes
        for (int i = 0; i < numCourses; i++) {
            // if the node is unvisited, do a DFS on it
            if (state[i] == 0) {
                if (!dfs(i)) {
                    return false;
                }
            }
        }

        // if no cycle is found, return true
        return true;
    }

    // Big O:

    // The time complexity of this solution is O(V + E), where V is the number of courses and E
    // is the number of prerequisites. The space complexity is O(V + E), as well. This is
    // because we need to store the graph and the state of each node, and the DFS may use up
    // to O(V) stack space.

}
