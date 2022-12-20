package MyMove;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger(double pow, double acc) {
        super(Type.NORMAL, pow, acc);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.confuse();
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect effect = new Effect().stat(Stat.ATTACK, 2);
        p.addEffect(effect);
    }

    @Override
    protected String describe(){
        return "Swagger";
    }
}
