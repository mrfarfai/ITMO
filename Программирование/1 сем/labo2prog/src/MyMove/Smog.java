package MyMove;

import Lab.Main;
import ru.ifmo.se.pokemon.*;

public class Smog extends SpecialMove {
    public Smog (double pow, double acc) {
        super(Type.POISON, pow, acc);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if(Main.chance(0.4)) {
            Effect.poison(pokemon);
        }
    }

    @Override
    protected String describe(){
        return "Smog";
    }
}
