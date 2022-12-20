package MyPokemons;

import MyMove.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Litwick extends Pokemon {
    public Litwick(String name, int level) {
        super(name, level);
        super.setType(Type.GHOST, Type.FIRE);
        super.setStats(50, 30, 55, 65, 55, 20);

        Smog smog = new Smog(30, 70);
        Facade facade = new Facade(70, 100);

        super.setMove(smog, facade);
    }
}
