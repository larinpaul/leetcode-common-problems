//// 2023/07/04 // 11:15 //

//// 853. Car Fleet // Medium //

// There are n cars going to the same destination along a one-lane road.
// The destination is target miles away.

// You are given two integer array position and speed, both of length n,
// where position[i] is the position of the ith car and speed[i]
// is the speed of the ith car (in miles per hour).

// A can can never pass another car ahead of it, but it can catch up to it and drive bumper to
// bumper at the same speed. The faster car will slow down to match the slower car's speed.
// The distance between these two cars is ignored (i.e., they ae assumed to have
// the same position).

// A car fleet is some non-empty set of cars driving at the same position and same speed.
// Note that a single car is also a car fleet.

// If a car catches up to a car fleet right at the destination point,
// it will still be considered as one car fleet.

// Return the number of car fleets that will arrive at the destination.

// Example 1:
// Input: target = 12, position = [10,8,80,5,3], speed = [2,4,1,1,3]
// Output: 3
// Explanation:
// The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12.
// The car starting at 0 does not catch up to any other car, so it is a fleet by itself.
// The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet,
// meeting each other at 6. The fleet moves at speed 1 until it reaches target.
// Note that no other cars meet these fleets before the destination, so the answer is 3.

// Example 2:
// Input: target = 10, position = [3], speed = [3]
// Output: 1
// Explanation: There is only one car, hence there is only one fleet.

// Example 3:
// Input: target = 100, position = [0,2,4], speed = [4,2,1]
// Output: 1
// Explanation:
// The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet,
// meeting each other at 4. The fleet moves at speed 2.
// Then, the fleet (speed 2) and the car starting at 4 (speed 1)
// become one fleet, meeting each other at 6.
// The fleet moves at speed 1 until it reaches target.

// Constraints:
// * n == position.length == speed.length
// * 1 <= n <= 10^5
// * 0 < target <= 10^6
// * 0 <= position[i] < target
// * All the values of position are unique.
// * 0 < speed[i] <= 10^6

import javax.swing.*;
import java.util.Arrays;

class CarFleet {

    // Explanation:
    // To solve this problem, we can calculate the time each car takes to reach the target.
    // If a car at position i takes less time to reach the target than the car at position i - 1,
    // then they will become a fleet since the car at position i will catch up to the car at position i - 1.
    // Otherwise, the car at position i will form its own fleet.

    // We can follow these steps to solve the problem:
    // 1. Create an array timeToTarget to store the time taken by each car to reach the target.
    // 2. Sort the cars by their positions in descending order. This makes it easier to determine
    // when a car catches up to another car.
    // 3. Iterate through the sorted cars and calculate the time taken for each car to reach the target.
    // 4. Iterate through the timeToTarget array and count the number of fleets.

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] timeToTarget = new double[n];

        // Create an array of car indices and sort them by position in descending order
        Integer[] carIndices = new Integer[n];
        for (int i = 0; i < n; i++) {
            carIndices[i] = i;
        }
        Arrays.sort(carIndices, (i, j) -> position[j] - position[i]);

        // Calculate time to target for each car
        for (int i = 0; i < n; i++) {
            int carIndex = carIndices[i];
            timeToTarget[i] = (double) (target - position[carIndex]) / speed[carIndex];
        }

        // Count the number of fleets
        int fleets = 0;
        for (int i = 0; i < n; i++) {
            if (timeToTarget[i] > 0) {
                fleets++;
                double curTime = timeToTarget[i];
                // Find the next car that cannot catch up to the current fleet
                while (i + 1 < n && timeToTarget[i + 1] <= curTime) {
                    i++;
                }
            }
        }

        return fleets;
    }

    // Big O:

    // Time Complexity:
    // O(n * log(n)) due to sorting the cars by their positions.

    // Space Complexity:
    // O(n) for sorting the time to target for each car and the sorted car indices.

}
