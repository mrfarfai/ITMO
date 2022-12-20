package MyMove;

import ru.ifmo.se.pokemon.*;

public class Harden extends StatusMove {
    public Harden(double pow, double acc) {
        super(Type.NORMAL, pow, acc);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect effect = new Effect().stat(Stat.DEFENSE, 1);
        p.addEffect(effect);
    }

    @Override
    protected String describe(){
        return "Harden";
    }
}
