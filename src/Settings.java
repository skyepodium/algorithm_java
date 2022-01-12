public class Settings {
    private static Settings instance;

    private Settings() {}

    public static synchronized Settings getInstance() {
        if(instance == null) {
            System.out.println("inner");
            instance = new Settings();
        }

        return instance;
    }
}