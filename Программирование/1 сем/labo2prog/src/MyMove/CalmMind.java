package MyMove;

import ru.ifmo.se.pokemon.*;

public class CalmMind extends StatusMove {
    public CalmMind (double pow, double acc) {
        super(Type.PSYCHIC, pow, acc);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        Effect effect = new Effect().stat(Stat.SPECIAL_ATTACK, +1);
        pokemon.addEffect(effect);

        Effect effect2 = new Effect().stat(Stat.SPECIAL_DEFENSE, +1);
        pokemon.addEffect(effect2);
    }

    @Override
    protected String describe(){
        return "CalmMind";
    }
}
