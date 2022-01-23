import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main {
    public static void main(String args[]) {
        // 1. 스레드 풀 생성
        ExecutorService service = Executors.newCachedThreadPool();

        // 2. 반복문을 통해 - 10개의 스레드가 동시에 인스턴스 생성
        for (int i = 0; i < 10; i++) {
            service.submit(() -> {
                SingleTon.getInstance();
            });
        }
        // 3. 종료
        service.shutdown();
    }
}

// 싱글톤 클래스
class SingleTon {
    // private 생성자 new 를 통한 인스턴스 생성 방지
    private SingleTon() {
        System.out.println("싱글톤 인스턴스 생성");
    }

    // 정적 메서드를 통해 내부 클래스 로딩
    public static SingleTon getInstance() {
        return LazyHolder.INSTANCE;
    }

    // 내부 클래스가 로딩될때 초기화 수행 - 싱글톤 인스턴스 생성
    private static class LazyHolder {
        private static final SingleTon INSTANCE = new SingleTon();
    }
}