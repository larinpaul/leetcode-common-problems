//// 2023/09/01 // 16:40 //

//// 210. Course Schedule II // Medium //

// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are
// given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course
// bi first if you want to take course ai.
// * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

// Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any
// of them. If it is impossible to finish all courses, return an emtpy array.

// Example 1:
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: [0,1]
// Explanation: There are a total of 2 courses to take. To take course 1 you
// should have finished course 0. So the correct course order is [0,1].

// Example 2:
// Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
// Output: [0,2,1,3]
// Explanation: There are a total fo 4 courses to take. To take course 3 you
// should have finished both courses 1 and 2. Both courses 1 and 2 should be
// taken after you finished course 0.
// SO one correct course order is [0,1,2,3]. Another correct ordering is
// [0,2,1,3].

// Example 3:
// Input: numCourses = 1, prerequisites = []
// Output: [0]

// Constraints:
// * 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= numCourses * (numCourses - 1)
// * prerequisites[i].length == 2
// * 0 <= ai, bi < numCourses
// * ai != bi
// * All the pairs [ai, bi] are distinct.


import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseScheduleII {

    // To solve the problem, we need to find the ordering of courses that allows
    // us to finish all course, given the prerequisite relationships between them.
    // If it is impossible to finish all courses, we should return an emty array.

    // Here's one possible approach to solve this problem:
    // 1. Build a directed graph representing the prerequisite relationships
    // between courses. Each course is a node in the graph, and a directed
    // edge from node A to node B indicates that course A is a prerequisite
    // for course B.
    // 2. Initialize an array inDegree of size numCourses to keep track of the
    // number of prerequisites for each course. Initially, all elements of
    // inDegree should be set to 0.
    // 3. Traverse the prerequisites array and update the inDegree array
    // accordingly. For each prerequisite pair [ai, bi], increment the value of
    // inDegree[ai] by 1.
    // 4. Initialize a queue and enqueue all course with 0 prerequisites
    // (i.e., courses with inDegree value of 0).
    // 5. Initialize an array result to store the final ordering of courses.
    // 6. Perform a breadth-first search (BFS) on the graph using the queue.
    // For each course dequeued from the queue, add it to the result
    // array. Then, decrement the inDegree value for all the courses that
    // have an incoming edge from the dequeued course. If any of these
    // courses have 0 prerequisites after decrementing, enqueue them into
    // the queue.
    // 7. After the BFS. check if all courses have been added to the result
    // array. If the size of result is equal to numCourses, return result as
    // the valid course ordering. Otherwise, return an empty array.

    // Here's the implementation fo the findOrder method in Java:
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Build the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Initialize inDegree array
        int[] inDegree = new int[numCourses];

        // Step 3: Update inDegree array
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);
            inDegree[course]++;
        }

        // Step 4: Enqueue courses with 0 prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 5: Initialize result array
        int[] result = new int[numCourses];
        int index = 0;

        // Step 6: Perform BFS
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;

            for (int adjacentCourse : graph.get(course)) {
                inDegree[adjacentCourse]--;
                if (inDegree[adjacentCourse] == 0) {
                    queue.offer(adjacentCourse);
                }
            }
        }

        // Step 7: Check if all courses are taken
        if (index == numCourses) {
            return result;
        } else {
            return new int[0]; // Empty array
        }
    }

    // The time complexity of this solution is O(V + E), where V is the number of
    // courses (vertices) and E is the number of prerequisite relationships
    // (edges).

    // The space complexity is O(V + E) as well, considering the space
    // used for the graph and the inDegree array.

}
