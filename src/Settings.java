public class Settings {
    private static Settings instance;

    private Settings() {
        System.out.println("새로운 인스턴스가 생성되었습니다.");
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }
}