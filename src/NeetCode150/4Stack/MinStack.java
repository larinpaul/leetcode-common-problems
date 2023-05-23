//// 2023/05/23 // 23:03 //

//// 155. Min Stack // Medium //

// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:
// * MinStack() initializes the stack object.
// * void push(int val) pushes the element val onto the stack
// * void pop() removes the element on the top of the stack.
// * int top() gets the top element of the stack.
// * int getMin() retrieves the minimum element in the stack.

// You must implement a solution with O(1) time complexity for each function.

// Example 1:
// Input:
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]
// Output:
// [null,null,null,null,-3,null,0,-2]

// Explanation:
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top(); // return 0
// minStack.getMin(); // return -2

// Constraints:
// * -2^31 <= val <= 2^31 - 1
// * Methods pop, top and getMin operations will always be called on non-empty stacks.
// * At most 3 * 10^4 calls will be made to push, pop, top, and getMin.

import java.util.Stack;

class MinStack {

    // Here we will need to design a stack that supports push, pop, top, and getMin operations
    // in constant time. A stack is a data structure that follows the last-in first-out (LIFO) principle,
    // meaning that the last element pushed onto the stack is the first one popped off.
    // The getMin operation returns the minimum element in the stack without removing it.

    // One possible solution is to use an auxiliary stack that keeps track of the minimum element
    // at each level of the main stack. Whenever we push a new element onto the main stack,
    // we also push the current minimum element onto the auxiliary stack. Whenever we pop an
    // element form the main stack, we also pop an element from the auxiliary stack.
    // This way,the top of the auxiliary stack always contains the minimum element in the main stack.

    // Declare two stacks: one for storing element and one for storing minimums
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // Initialize both stacks
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push an element onto both stacks
    public void push(int val) {
        // Push val onto the main stack
        stack.push(val);
        // If the minStack is empty or val is smaller than or equal to the current minimum,
        // push val onto the minStack as well
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Pop an element form both stacks
    public void pop() {
        // Pop an element form the main stack and store it in a variable
        int val = stack.pop();
        // If the popped element is equal to the current minimum,
        // pop an element form the minStack as well
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    // Return the top element of the main stack
    public int top() {
        return stack.peek();
    }

    // Return the top element of the minStack, which is the minimum element of the main stack
    public int getMin() {
        return minStack.peek();
    }



//    public MinStack() {
//
//    }
//
//    public void push(int val) {
//
//    }
//
//    public void pop() {
//
//    }
//
//    public int top() {
//
//    }
//
//    public int getMin() {
//
//    }

    // The time complexity of each operation is O(1), since we only perform constant time
    // operations on both stacks. The space complexity is O(n), where n is the number of
    // elements in the main stack, since we use an extra stack of size n/2 on average.

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */










