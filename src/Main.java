class Main {
    public static void main(String[] args) throws Exception {

        Calculator calculator = new Calculator() {
            @Override
            public int sumDefault(int x, int y) {
                return x * y;
            }
        };

        int sumResultDefault = calculator.sumDefault(3, 4);
        System.out.println(sumResultDefault);

        int sumResultStatic = Calculator.sumStatic(1, 2);
        System.out.println(sumResultStatic);
    }
}
