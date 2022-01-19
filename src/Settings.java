public class Settings {
    // 1. private 생성자
    private Settings() {}

    // 2. static inner 클래스
    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    // 3. static 메서드
    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }
}