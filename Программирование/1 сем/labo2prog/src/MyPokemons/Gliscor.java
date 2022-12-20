package MyPokemons;

import MyMove.BrutalSwing;
import MyMove.Confide;
import MyMove.Harden;
import MyMove.Venoshock;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Gliscor extends Pokemon {
    public Gliscor(String name, int level) {
        super(name, level);
        super.setType(Type.GROUND, Type.FLYING);
        super.setStats(75, 95, 125, 45, 75, 95);

        Harden harden = new Harden(0, 0);
        Confide confide = new Confide(0, 0);
        Venoshock venoshock = new Venoshock(65, 100);
        BrutalSwing brutalSwing = new BrutalSwing(60, 100);

        super.setMove(harden, confide, venoshock, brutalSwing);
    }
}
