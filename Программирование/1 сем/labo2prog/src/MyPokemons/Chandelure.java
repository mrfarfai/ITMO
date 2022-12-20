package MyPokemons;

import MyMove.Astonish;
import MyMove.CalmMind;
import MyMove.Facade;
import MyMove.Smog;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Chandelure extends Pokemon {
    public Chandelure(String name, int level) {
        super(name, level);
        super.setType(Type.GHOST, Type.FIRE);
        super.setStats(60, 55, 90, 145, 90, 80);

        Smog smog = new Smog(30, 70);
        Facade facade = new Facade(70, 100);
        Astonish astonish = new Astonish(30, 100);
        CalmMind calmMind = new CalmMind(0, 0);

        super.setMove(smog, facade, astonish, calmMind);
    }
}
