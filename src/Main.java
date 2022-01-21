class Main {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("a");
        StringBuffer b = a;
        for(int i=0; i<1000; i++) {
            a.append("c");
        }

        System.out.println(a);
        System.out.println(b);
    }
}