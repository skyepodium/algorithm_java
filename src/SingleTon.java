class SingleTon {
    public static final int a = 1;

    static {
        System.out.println("hihihi");
    }

    private SingleTon () {}

    private static class LazyHolder {
        private static final SingleTon INSTANCE = new SingleTon();
    }

    public static SingleTon getInstance () {
        return LazyHolder.INSTANCE;
    }
}