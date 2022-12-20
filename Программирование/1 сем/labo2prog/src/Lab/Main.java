package Lab;

import MyPokemons.*;
import ru.ifmo.se.pokemon.Battle;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Throh throh = new Throh("Тро", 1);
        Gligar gligar = new Gligar("Хихик", 1);
        Gliscor gliscor = new Gliscor("Глискор", 1);
        Litwick litwick = new Litwick("Литвик", 1);
        Lampent lampent = new Lampent("Фонарь", 1);
        Chandelure chandelure = new Chandelure("Люстра", 1);

        b.addAlly(throh);
        b.addAlly(gliscor);
        b.addAlly(lampent);

        b.addFoe(gligar);
        b.addFoe(litwick);
        b.addFoe(chandelure);

        b.go();
    }

    public static boolean chance(double c){
        return (c > Math.random());
    }
}
