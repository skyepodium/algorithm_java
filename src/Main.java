class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> a = new CustomArrayList<>();

        for(int i=0; i<30; i++) {
            a.add(i);
        }

        while(!a.isEmpty()) {
            System.out.println(a.get(a.getSize() - 1));
            a.pop();
        }
    }
}

class CustomArrayList <T> {
    private T[] arr;
    private int idx = 0;
    private final int DEFAULT_SIZE = 10;
    private int MAX_SIZE = 0;

    private void sizeUp() {
        this.MAX_SIZE = this.MAX_SIZE + (this.MAX_SIZE >> 1);
    }

    private void copyArr() {
        T[] temp = (T[]) new Object[this.MAX_SIZE];
        for(int i=0; i<=this.idx; i++) {
            temp[i] = this.arr[i];
        }
        this.arr = temp;
    }

    public CustomArrayList() {
        this.MAX_SIZE = this.DEFAULT_SIZE;
        this.arr = (T[]) new Object[this.DEFAULT_SIZE];
    }

    public void add(T val) {
        if(this.idx == this.MAX_SIZE - 1) {
            this.sizeUp();
            this.copyArr();
        }

        this.arr[idx++] = val;
    }

    public void pop() {
        if(this.idx == 0) return;

        this.arr[idx--] = null;
    }

    public T get(int i) {
        return this.arr[i];
    }

    public boolean isEmpty() {
        return this.idx == 0;
    }

    public int getSize() {
        return this.idx;
    }
}