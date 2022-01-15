import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Main {
    public static void main(String args[]) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1. 싱글톤 클래스의 인스턴스 생성
        Settings settings = Settings.getInstance();

        // 2. 리플랙션
        // 1) settings 클래스의 생성자 가져옴
        Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
        // 2) private 생성자 외부 접근 허용
        constructor.setAccessible(true);
        // 3) 생성자를 통한 인스턴스 생성 new Settgings()와 유사
        Settings settings1 = constructor.newInstance();

        // 3. 주소값 비교 - false
        System.out.println(settings == settings1);
    }
}