import java.util.Stack;

class MyQueue {

    Stack<Integer> left, right;

    public MyQueue() {
        left = new Stack<>();
        right = new Stack<>();
    }

    public void push(int x) {
        this.right.add(x);
    }

    public int pop() {
        this.peek();
        return left.pop();
    }

    public int peek() {
        if(left.empty()){
            while(!right.empty()) {
                left.add(right.pop());
            }
        }

        return left.peek();
    }

    public boolean empty() {
        return this.left.empty() && this.right.empty();
    }
}
