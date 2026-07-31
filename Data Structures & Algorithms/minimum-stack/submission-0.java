class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);

        // If minStack is empty or new value is less than or equal to
        // the top of the minStack, push it onto the minStack
        if(minStack.isEmpty() || val<= minStack.peek())
           minStack.push(val);
    }
    
    public void pop() {
        int poppedvalue = stack.pop();

        // If popped value == top of the minStack,
        // pop it from the minStack as well
        if(poppedvalue== minStack.peek())
            minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
