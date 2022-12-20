package MyMove;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class VitalThrow extends PhysicalMove {
    public VitalThrow(double pow, double acc) {
        super(Type.FIGHTING, pow, acc);
    }
    @Override
    protected void applySelfDamage(Pokemon def, double damage){
        super.applySelfDamage(def, damage);

    }

    @Override
    protected String describe(){
        return "VitalThrow";
    }
}
