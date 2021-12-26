class Main {
    public static void main(String[] args) {
        // 생성자를 통해 인스턴스 생성
        Dog dog = new Dog("모카", 1);

        // 출력
        System.out.println(dog);
    }
}

class Dog {
    // 이름을 저장하는 인스턴스 변수
    private String name;
    // 나이를 저장하는 인스턴스 변수
    private int age;

    // 생성자
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    // 인텔리제이의 generate 기능을 사용했습니다.
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}