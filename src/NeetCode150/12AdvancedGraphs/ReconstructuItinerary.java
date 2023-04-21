//// 2023/04/21 // 9:48 //

//// 332. Reconstruct Itinerary // Hard //

// You are given a list of airline tickets where tickets[i] = [fromi, toi] represent
// the departure and the arrival airports of one flight. Reconstruct the itinerary in order
// and return it.

// All of the tickets belong to a man who departs from "JFK", thus, the itinerary must
// being with "jfk". If there are multiple valid itineraries, you should return the itinerary
// that has the smallest lexical order when read as a single string.

// * For example, the itinerary ["JFK", 'LGA"] has a smaller lexical order than ["JFK", "LGB"].

// You may assume all tickets form at least one valid itinerary.
// You must use all the tickets once and only once.

// Example 1:
// Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
// Output: ["JFK","MUC","LHR","SFO","SJC"]

// Example 2:
// Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
// Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
// Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]
//  but it is larger in lexical order.

// Constraints:
// 1 <= tickets.length <= 300
// tickets[i].length == 2
// fromi.length == 3
// toi.length == 3
// fromi and toi consist of uppercase English letters.
// fromi != toi

////

// One possible way to solve this problem is to use a depth-first-search (DFS) algorithm on
// a graph that represents the tickets. Each node in the graph is an airport, and each edge
// is a ticket from one airport to another. We can use a priority queue or a sorted list to
// store the outgoing edges for each node, so that we can always pick the smallest one in
// lexical order. We can also use a hash map or an array to keep track of how many tickets
// we have used for each edge, so that we can avoid using the same ticket twice.

// The DFS algorithm starts from JFK and tries to find a path that uses all the tickets. If it
// reaches a dead end, it backtracks and tries another edge. The trick is to add the current
// node to the itinerary only when we backtrack, not when we visit it. This way, we can
// ensure that the itinerary is in reverse order of the DFS traversal. For example, if we have
// tickets ["JFK",A],[A,B],[B,C],[C,JFK],[JFK,D],[D,A], the DFS traversal will be JFK->A->B->C->JFK->D->A,
// bu the itinerary will be A->D->JFK->C->B->A->JFK.

import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Create a graph with priority queue for each node
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        // Create a list to store the itinerary
        List<String> itinerary = new LinkedList<>();

        // Create a stack to store the DFS path
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String curr = stack.peek();
            // If the current node has no more outgoing edges, add it to the itinerary
            if (!graph.containsKey(curr) || graph.get(curr).isEmpty()) {
                itinerary.add(0, curr);
                stack.pop();
            } else {
                // Otherwise, pick the smallest edge and push it to the stack
                String next = graph.get(curr).poll();
                stack.push(next);
            }
        }

        return itinerary;
    }

}

// The explanation of the code is as follows:
// * We import the java.util package to use some data structures like HashMap,
// PriorityQueue, LinkedList and Stack.
// * We define a class Solution that has a public method findItinerary that takes a list of
// lists of strings as input and returns a list of strings as output.
// * We create a hash map called graph that maps each airport (string) to a priority queue
// of strings that represent its outgoing edges (tickets). We iterate over the input
// tickets and add them to the graph accordingly. We use a priority queue to ensure that
// we always pick the smallest edge is lexical order.
// * We create a linked list called itinerary that will store the final result. We use a linked
// list because we need to insert elements at the beginning of the list efficiently.
// * We create a stack called stack that will store the current DFS parh. We initialize it
// with "JFK" as the starting point.
// * We use a while loop to iterate until the stack is empty. Inside the loop, we do the
// following steps:
    // * We peek at the top element of the stack and assign it to a string variable curr.
    // This is the current node we are visiting.
    // * We check if the current node has no more outgoings edges or if it is not in the
    // graph at all. This means we have reached a dead end, and we need to backtrack.
    // In this case, we add the current node to the beginning of the itinerary list
    // and pop it from the stack
    // * Otherwise, we pick the smallest edge from the priority queue of the current node
    // and assign it to a string variable next.
    // This is the next node we want to visit. We push the next node to the stack

// The time complexity of this solution is O(E log E), where E is the number of tickets
// (edges) in the graph. This is because we need to sort the edges for each node using a
// priority queue, which takes O(log E) time per insertion and deletion. We also need to
// traverse all the edges in the graph using DFS, which takes O(E) time in total. Therefore,
// the overall time complexity is O(E log E)

// The space complexity of this solution is O(V + E), where V is the number of airports
// (nodes) in the graph. This is because we need to store the graph in a hsh map, which
// takes O(V + E) space. We also need to store the itinerary in a linked list, which takes O(E)
// space. We also need to store the stack for DFS, which takes O(V) space is the worst
// case. Therefore, the overall space complexity is O(V + E).
