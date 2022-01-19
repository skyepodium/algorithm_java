public class Temp {
    // 1. private 생성자
    private Temp() {
        System.out.println("temp constructor");
    }

    static {
        System.out.println("Temp static");
    }

    // 2. static inner 클래스
    private static class SettingsHolder {
        public int a = 1;
        static {
            System.out.println("inner!!! static");
        }

        public SettingsHolder () {
            System.out.println("SettingHolder constructor");
        }

        private static final Temp INSTANCE = new Temp();
    }

    public static void temp() {
        System.out.println("temp method");
        System.out.println(SettingsHolder.class);
        SettingsHolder settingsHolder = new SettingsHolder();
//        System.out.println(settingsHolder.a);
    }

    // 3. static 메서드
    public static Temp getInstance() {
        return SettingsHolder.INSTANCE;
    }
}