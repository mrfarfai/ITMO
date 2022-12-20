package MyMove;

import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove {
    public Confide (double pow, double acc) {
        super(Type.NORMAL, pow, acc);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect effect = new Effect().stat(Stat.SPECIAL_ATTACK, -1);
        p.addEffect(effect);
    }

    @Override
    protected String describe(){
        return "Confide";
    }
}
