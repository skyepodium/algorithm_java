public interface Calculator {

    default int sumDefault(int x, int y) {
        return x + y;
    }

    static int sumStatic(int x, int y) {
        return x + y;
    }
}
