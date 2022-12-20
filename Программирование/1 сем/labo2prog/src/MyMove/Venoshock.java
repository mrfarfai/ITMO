package MyMove;

import ru.ifmo.se.pokemon.*;

public class Venoshock extends SpecialMove {
    public Venoshock(double pow, double acc) {
        super(Type.POISON, pow, acc);
    }

    @Override
    protected void applyOppDamage(Pokemon pokemon, double v) {
        if (pokemon.getCondition() == Status.POISON) {
            super.applyOppDamage(pokemon, 2);
        }

    }

        @Override
        protected String describe(){
            return "Venoshock";
        }


}