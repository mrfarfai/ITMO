package MyPokemons;

import MyMove.Astonish;
import MyMove.Facade;
import MyMove.Smog;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Lampent extends Pokemon {
    public Lampent(String name, int level) {
        super(name, level);
        super.setType(Type.GHOST, Type.FIRE);
        super.setStats(60, 40, 60, 95, 60, 55);

        Smog smog = new Smog(30, 70);
        Facade facade = new Facade(70, 100);
        Astonish astonish = new Astonish(30, 100);

        super.setMove(smog, facade, astonish);
    }
}
