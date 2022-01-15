public enum Settings {
    INSTANCE;

    private int count = 0;

    public void plusCount () {
        System.out.println(++count);
    }
}