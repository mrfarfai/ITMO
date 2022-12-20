package MyMove;

import Lab.Main;
import ru.ifmo.se.pokemon.*;

public class Astonish extends PhysicalMove {
    public Astonish(double pow, double acc) {
        super(Type.GHOST, pow, acc);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if(Main.chance(0.3)) {
            Effect.flinch(pokemon);
        }
    }

    @Override
    protected String describe(){
        return "Astonish";
    }
}
