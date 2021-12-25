import java.util.HashMap;
import java.util.Objects;

class Main {
    public static void main(String[] args) {

        Dog dog1 = new Dog("모카", 1);
        Dog dog2 = new Dog("모카", 1);

        HashMap<Dog, String> dogHouse = new HashMap<>();
        dogHouse.put(dog1, "모카집");

        // 모카집 입니다.
        System.out.println(dogHouse.get(dog1));
        // null
        System.out.println(dogHouse.get(dog2));
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    // 인텔리제이 generate 기능 사용
    public boolean equals(Object o) {
        // 1. 주소값 비교
        if (this == o) return true;

        // 2. 인스턴스 여부 확인
        if (!(o instanceof Dog)) return false;

        // 3. 나이, 이름 비교
        Dog dog = (Dog) o;
        return age == dog.age && Objects.equals(name, dog.name);
    }

    @Override
    // Objects 클래스는 임의의 개수만큼 객체를 받아 해시코드를 계산해줍니다.
    public int hashCode() {
        return Objects.hash(name, age);
    }
}



