package MyMove;

import ru.ifmo.se.pokemon.*;

public class Leer extends StatusMove {
    public Leer(double pow, double acc){
        super(Type.NORMAL, pow, acc);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect effect = new Effect().stat(Stat.DEFENSE, -1);
        p.addEffect(effect);
    }

    @Override
    protected String describe(){
        return "Leer";
    }

}
