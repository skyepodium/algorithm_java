public class Settings {
    // 1. private 생성자
    private Settings() {
        throw new RuntimeException("싱글턴 인스턴스를 리플렉션으로 생성할 수 없습니다.");
    }

    // 2. static inner 클래스
    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    // 3. static 메서드
    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }
}