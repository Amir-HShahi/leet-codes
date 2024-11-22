class MyStack {
    MyQueue firstQueue = new MyQueue();
    MyQueue secondQueue = new MyQueue();
    

    public MyStack() {

    }

    public void push(int x) {
        firstQueue.enqueue(x);
    }

    public int pop() {
        while (firstQueue.size() > 1) {
            secondQueue.enqueue(firstQueue.dequeue());
        }
        while (secondQueue.size() != 0) {
            firstQueue.enqueue(secondQueue.dequeue());
        }
        return firstQueue.dequeue();
    }

    public int top() {
        while (firstQueue.size() > 1) {
            secondQueue.enqueue(firstQueue.dequeue());
        }
        int x = firstQueue.dequeue();
        secondQueue.enqueue(x);
        while (secondQueue.size() != 0) {
            firstQueue.enqueue(secondQueue.dequeue());
        }
        return x;
    }

    public boolean empty() {
        return firstQueue.isEmpty();
    }
}

class MyQueue {
    private int head = 0;
    private int tail = 0;
    private int capacity = 3;
    private int size = 0;
    private Integer[] queue = new Integer[capacity];

    public int size() {
        return size;
    }

    public Boolean isFull() {
        if (head == (tail + 1) || ((head == 0) && (tail == capacity - 1)))
            return true;
        else
            return false;
    }

    public Boolean isEmpty() {
        if (tail == head)
            return true;
        else
            return false;
    }

    public void enqueue(Integer object) {
        if (isFull())
            throw new RuntimeException("Queue is full");

        queue[tail] = object;
        tail = (tail + 1) % capacity;
        size++;
    }

    public Integer dequeue() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");

        Integer dequeuedObject = queue[head];
        head = (head + 1) % capacity;
        size--;
        return dequeuedObject;
    }
}