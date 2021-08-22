class MyStack {

    Queue<Integer> q;

    public MyStack() {
        this.q = new LinkedList<>();
    }

    public void push(int x) {
        this.q.add(x);
        int size = q.size();
        for(int i=0; i<size-1; i++) {
            this.q.add(this.q.poll());
        }
    }

    public int pop() {
        return this.q.poll();
    }

    public int top() {
        return this.q.peek();
    }

    public boolean empty() {
        return this.q.isEmpty();
    }
}