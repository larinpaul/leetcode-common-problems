//// 2023/09/03 // 9:35 //

//// 2013. Detect Squares // Medium //

// You are given a stream of points on the X-Y plane. Design an algorithm that:
// * Adds new points from the stream into a data structure. Duplicate points are allowed and should be
// treated as different points.
// * Given a query point, counts the number of ways to choose three points from the data structure such
// that the three points and the query point form an axis-aligned square with positive area.

// An axis-aligned square is a square whose edges are all the same length and are either parallel or
// perpendicular to the x-axis and y-axis.

// Implement the DetectSquares class:
// * DetectSquares() Initializes the object with an empty data structure.
// * void add(int[] point) Adds a new point point = [x, y] to the data structure.
// * int count(int[] point) Counts the number of ways to form axis-aligned squares
// with point point = [x, y] as described above.

// Example 1:
// Image
// Input
// ["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
// [[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
// Output
// [null, null, null, null, 1, 0, null, 2]

// Explanation
// DetectSquares detectSquares = new DetectSquares();
// detectSquares.add([3, 10]);
// detectSquares.add([11, 2]);
// detectSquares.add([3, 2]);
// detectSquares.count([11, 10]); // return 1. You can choose:
                                  //   - The first, second, and third points
// detectSquares.count([14, 8]);  // return 0. The query point cannot form a
// square with any points in the data structure.
// detectSquares.add([11, 2]);    // Adding duplicate points is allowed.
// detectSquares.count([11, 10]); // return 2. You can choose:
                                  //   - The first, second, and third points
                                  //   - The first, thirds, and fourth points

// Constraints:
// * point.length == 2
// * <= x, y <= 1000
// * At most 3000 calls in total will be made to add and count.


import com.sun.jdi.IntegerType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DetectSquares {

    // Here's an explanation of the solution, the updated code, and the
    // time complexity analysis:

    // Explanation:
    // The solution uses two main data structures: pointmap and mapx.
    // * pointmap is a HashMap that maps a pair of coordinates (x, y) to the
    // frequency/count of points with those coordinates.
    // * mapx is a HashMap that maps an x-coordinate to a list of
    // PointAndCount objects. Each PointAndCount object contains a
    // y-coordinate and its corresponding count.

    // The add method:
    // * It adds the given point to pointmap and updates the
    // frequency/count of the point.
    // * It also adds the point to mapx and updates the count for the
    // corresponding x-coordinate and y-coordinate. If a PointAndCount
    // object with the same x and y coordinates already exists in the list, its
    // count is incremented; otherwise, a new PointAndCount object is
    // added to the list.

    // The count method:
    // * It iterates over the list of PointAndCount objects for the given
    // x-coordinate from mapx.
    // * For each PointAndCount object, it calculates four potential corner
    // points of a square using the given query point and the y-coordinate
    // o the object.
    // * It checks if the y-coordinate difference is not zero (to avoid counting
    // squares with the same points).
    // * It then checks pointmap for the frequency/count of the corner points
    // and multiplies them with the count of the PointAndCount object.
    // * The results are accumulated in the res variable and returned as the
    // final count.


    class PointAndCount {
        public int val, count;

        PointAndCount(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    class DetectSquares {
        private HashMap<Pair<Integer, Integer>, Integer> pointmap;
        private HashMap<Integer, List<PointAndCount>> mapx;

        public DetectSquares() {
            pointmap = new HashMap<>();
            mapx = new HashMap<>();
        }

        public void add(int[] point) {
            Pair<Integer, Integer> pair = new Pair<>(point[0], point[1]);
            pointmap.put(pair, pointmap.getOrDefault(pair, 0) + 1);
            addValuesToMaps(mapx, point);
        }

        private void addValuesToMaps(HashMap<Integer, List<PointAndCount>> map, int[] point) {
            List<PointAndCount> lis = map.getOrDefault(point[0], new ArrayList<>());
            int count = 0;
            PointAndCount y = null;
            if (lis.size() == 0) {
                lis.add(new PointAndCount(point[1], 1));
                map.put(point[0], lis);
            } else {
                for (PointAndCount ob : lis) {
                    if (ob.val == point[1]) {
                        y = ob;
                        break;
                    }
                }
                if (y == null) {
                    y = new PointAndCount(point[1], 1);
                    lis.add(y);
                } else
                    y.count++;
            }
        }

        public int count(int[] point) {
            int res = 0;
            List<PointAndCount> lis = mapx.getOrDefault(point[0], new ArrayList<>());
            for (PointAndCount ob : lis) {
                Pair<Integer, Integer> pointa = new Pair<>(ob.val - point[1] + point[0], point[1]);
                Pair<Integer, Integer> pointb = new Pair<>(ob.val - point[1] + point[0], ob.val);

                Pair<Integer, Integer> pointc = new Pair<>(-(ob.val - point[1]) + point[0], point[1]);
                Pair<Integer, Integer> pointd = new Pair<>(-(ob.val - point[1]) + point[0], ob.val);

                if ((ob.val - point[1]) != 0) {
                    res += pointmap.getOrDefault(pointa, 0) * pointmap.getOrDefault(pointb, 0) * ob.count;
                    res += pointmap.getOrDefault(pointc, 0) * pointmap.getOrDefault(pointd, 0) * ob.count;
                }
            }
            return res;
        }
    }

    // Time Complexity Analysis:
    // * The add method takes O(1) time complexity since it involves
    // HashMap operations that have constant time complexity.
    // * The count method iterates over the list of PointAndCount objects
    // for the given x-coordinate, which has a maximum of O(n) iterations,
    // where n is the number of points added so far.
    // * Inside the loop, the method performs constant time operations such
    // as HashMap lookups and multiplication.
    // * Therefore, the overall time complexity of the count method is O(n),
    // where n is the number of points added so far.

    // In summary, the solution maintains two data structures to efficiently add
    // and count points for detecting squares. The add method updates the
    // frequency/count of points in the pointmap and mapx data structures. The
    // count method iterates over the relevant PointAndCount objects and
    // calculates the potential corner points of squares, checking their
    // frequencies in the pointmap and accumulating the count. The overall
    // time complexity of the solution is O(n), where n is the number of points
    // added so far.

    // Please note that this code also relies on a PointAndCount class and a Pair class.
    // Ensure that these classes are available and properly implemented in your code.

}
