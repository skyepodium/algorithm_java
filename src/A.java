public class A {
    static {
        System.out.println("1. static 블록 수행");
//        System.out.println(a); 정적 블록이 먼저 수행되기 때문에 정적변수 출력불가
    }

    public static String a = "2. static 멤버 변수";

    public A() {
        System.out.println(a);
        System.out.println("3. 생성자");
    }

    public static void printA() {
        System.out.println(a);
        System.out.println("4. 정적 변수");
    }

    public static class innerA {
        static {
            System.out.println("5. inner class static 블록");
        }

        public innerA() {
            System.out.println("6. inner 생성자");
        }
    }
}