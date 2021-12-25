class Main {

    public static void main(String[] args) {
        long primitiveStartTime = System.currentTimeMillis();
        long primitiveSumValue = 0;
        for(int i=0; i<100000000; i++) {
            primitiveSumValue += i;
        }
        System.out.println("원시 타입 수행 결과: " + (System.currentTimeMillis() - primitiveStartTime) + "ms");

        long referenceStartTime = System.currentTimeMillis();
        Long referenceSumValue = 0L;
        for(Integer i=0; i<100000000; i++) {
            referenceSumValue += i;
        }
        System.out.println("참조 타입 수행 결과: " + (System.currentTimeMillis() - referenceStartTime) + "ms");
    }
}