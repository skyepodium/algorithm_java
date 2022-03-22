import java.util.Arrays;

enum Pokemon {
    bulbasaur("이상해씨", "grass", 1),
    charmander("파이리", "fire", 4),
    squirtle("꼬부기", "water", 7),
    missingno("미씽노", "normal", 0);


    private String name;
    private String type;
    private int number;

    Pokemon(String name, String type, int number) {
        this.name = name;
        this.type = type;
        this.number = number;
    }

    // 타입, 번호를 기준으로 식별자 필터링
    public static Pokemon getPokemon (String type, int number) {
        return Arrays.stream(Pokemon.values())
                .filter(x -> x.type.equals(type) && x.number == number)
                .findAny()
                .orElse(missingno);
    }

    // 필터링된 식별자의 이름 반환
    public static String getPokemonName (String type, int number) {
        return getPokemon(type, number).getName();
    }

    public String getName() {
        return this.name;
    }
}

class Main {
    public static void main(String[] args) {

        String name = Pokemon.getPokemonName("grass", 1);

        System.out.println("name " + name);
    }
}