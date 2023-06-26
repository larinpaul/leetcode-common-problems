//// 2023/06/26 // 18:44 //

//// 621. Task Scheduler // Medium

// Given a characters array tasks, representing the tasks a CPU need to do, where each letter
// represents a different task. Tasks could be done in any order. Each task is done in one unit of
// time. For each unit of time, the CPU could complete either one task or just be idle.

// However, there is a non-negative integer n that represents the cooldown period
// between two same tasks (the same letter in the array), that is that there must be at least n
// units of time between any two same tasks.

// Return the least number of units of times that the CPU will take to finish all the given tasks.

// Example 1:
// Input: tasks = ["A","A","A","B","B","B"], n = 2
// Output: 8
// Explanation:
// A -> B -> idle -> A -> B -> idle -> A -> B
// There is at least 2 units of time between any two same tasks.

// Example 2:
// Input: tasks = ["A","A","A","B","B","B"], n = 2
// Output: 6
// Explanation: On this case any permutation of size 6 would work since n = 0.
// ["A","A","A","B","B","B"]
// ["A","B","A","B","A","B"]
// ["B","B","B","A","A","A"]
// ...
// And so on.

// Example 3:
// Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
// Output: 16
// Explanation:
// One possible solution is
// A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A

// Constraints:
// * 1 <= task.length <= 10^4
// * tasks[i] is upper-case English letter.
// * The integer n is the range [0, 100].

class TaskScheduler {

    // Solution:

    // The basic idea is to find the most frequent tasks and arrange them with n idle slots between them. For
    // example, if we have tasks = ["A","A","A","B',"B","B"] and n = 2, then we can arrange them
    // as A -> B -> idle -> A -> B -> idle -> A -> B.
    // The number of slots between two same tasks is equal to frequency of the most frequent task minus one,
    // which is 2 in this case. The length of this arrangement is (2 + 1) * 3 = 9, where 2 + 1
    // is the number of slots per cycle and 3 is the number of cycles.

    // However, there might be more than one task with the same frequency as the most frequent one.
    // For example, if we have tasks = ["A","A","A","B","B","B","C","C"] and n = 2,
    // then we can arrange them as A -> B -> C -> A -> B -> C -> A -> B.
    // The number of slots between two same tasks is still 2, but the length of this arrangement is
    // (2 + 1) * 3 + 1 = 10, where 1 is the number of extra tasks that have the same frequency
    // as the most frequent one.

    // Therefore, the general formula for the length of the optimal arrangement is:

    // (length of a cycle) * (number of cycles) + (number of extra tasks)

    // where
    // * length of a cycle = n + 1
    // * number of cycles = frequency of the most frequent task - 1
    // * number of extra tasks = number of tasks that have the same frequency as the most frequent one

    // However, there is one more case to consider.
    // If the number of tasks is larger than the length of the optimal arrangement,
    // then we don't need any idle slots at all.
    // For example, if we have tasks = ["A","A","A","B","B","B"] and n = 1,
    // then we can arrange them as A -> B -> A -> B -> A -> B.
    // The length of this arrangement is equal to the number of tasks, which is 6.

    // Therefore, the final answer is:

    // max (number of tasks, length of optimal arrangement)

    public int leastInterval(char[] tasks, int n) {

        // count the frequency of each task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // find the maximum frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // find the number of tasks that have the same frequency as the maximum
        int extra = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                extra++;
            }
        }

        // calculate the length of the optimal arrangement
        int cycle = n + 1;
        int cycles = maxFreq - 1;
        int optimal = cycle * cycles + extra;

        // return the maximum of the number of tasks and the optimal length
        return Math.max(tasks.length, optimal);
    }

    // Big O:

    // The time complexity is O(n), where n is the number of tasks. We need to iterate over the tasks array
    // once to count the frequencies, and then iterate over the frequencies array once to find the maxiumum
    // and extra values.

    // The space complexity is O(1), since we only use a constant size array to store the frequencies.

}
