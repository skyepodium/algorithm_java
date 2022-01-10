class Main {
    public static void main(String[] args) {
        // 1. 참조타입에 null값 대입
        Long a = null;

        // 2. 삼항 연산자 수행
        // 조건이 false 이기 때문에 a가 b에 대입
        Long b = false ? 0L : a;
    }
}