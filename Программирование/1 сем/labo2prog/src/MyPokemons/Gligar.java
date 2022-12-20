package MyPokemons;

import MyMove.Confide;
import MyMove.Harden;
import MyMove.Venoshock;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Gligar extends Pokemon {
    public Gligar(String name, int level) {
        super(name, level);
        super.setType(Type.GROUND, Type.FLYING);
        super.setStats(65, 75, 105, 35, 65, 85);

        Harden harden = new Harden(0, 0);
        Confide confide = new Confide(0, 0);
        Venoshock venoshock = new Venoshock(65, 100);

        super.setMove(harden, confide, venoshock);
    }
}
