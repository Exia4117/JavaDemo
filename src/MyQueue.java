import java.util.Stack;

class MyQueue {
    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();

    /** Push element x to the back of queue. */
    public void push(int x) {
        a.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int returnPop = this.peek();
        b.pop();
        return returnPop;
    }

    /** Get the front element. */
    public int peek() {
        if (b.empty()) {
            for (int i = 0; i < a.size(); i++) {
                b.push(a.peek());
                a.pop();
            }
            return b.peek();
        } else {
            return b.peek();
        }

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return a.empty() && b.empty();
    }

    public static void main(String[] args) {
        MyQueue test = new MyQueue();
        int[] testArray = {0,1,2,0,0,0};
        test.push(testArray[0]);
        test.push(testArray[1]);
        test.peek();
        test.pop();

    }
}
