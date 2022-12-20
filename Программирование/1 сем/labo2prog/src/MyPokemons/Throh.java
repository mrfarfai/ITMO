package MyPokemons;

import MyMove.Confide;
import MyMove.Leer;
import MyMove.Swagger;
import MyMove.VitalThrow;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Throh extends Pokemon {
    public Throh(String name, int level) {
        super(name, level);

        super.setType(Type.FIGHTING);
        super.setStats(120, 100, 85, 30, 85, 45);
        Leer leer = new Leer(0, 100);
        Swagger swagger = new Swagger(0, 85);
        Confide confide = new Confide(0, 0);
        VitalThrow vitalThrow = new VitalThrow(70, Double.POSITIVE_INFINITY);

        super.setMove(leer, swagger, confide, vitalThrow);
    }
}