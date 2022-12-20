package MyMove;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Status;
import ru.ifmo.se.pokemon.Type;

public class Facade extends PhysicalMove {
    public Facade (double pow, double acc) {
        super(Type.NORMAL, pow, acc);
    }

    @Override
    protected void applyOppDamage(Pokemon pokemon, double v) {
        Status status = pokemon.getCondition();

        super.applyOppDamage(pokemon, 1);

        if(status == Status.BURN || status == Status.POISON || status == Status.PARALYZE) {
            super.applyOppDamage(pokemon, 140);
        }
    }

    @Override
    protected String describe(){
        return "Facade";
    }
}
