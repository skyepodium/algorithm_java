import java.util.concurrent.*;

class Main {
    public static void main(String args[]) {
        // 1. 스레드 풀 생성
        ExecutorService service = Executors.newCachedThreadPool();

        // 2. 반복문을 통해 - 여러개의 스레드가 거의 동시에 인스턴스를 생성
        for (int i = 0; i < 10; i++) {
            service.submit(() -> {
                Settings.getInstance();
            });
        }
        // 3. 종료
        service.shutdown();
    }
}