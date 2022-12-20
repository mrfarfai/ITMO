package MyMove;

import ru.ifmo.se.pokemon.*;

public class BrutalSwing extends PhysicalMove {
    public BrutalSwing (double pow, double acc) {
        super(Type.DARK, pow, acc);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect effect = new Effect().stat(Stat.ATTACK, 1);
        pokemon.addEffect(effect);
        super.applyOppEffects(pokemon);
    }

    @Override
    protected String describe(){
        return "BrutalSwing";
    }
}
