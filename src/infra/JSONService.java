package infra;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class JSONService<T> {

    private static final Gson GSON  = new Gson();
    private final Class<T> clazz;

    public JSONService( Class<T> clazz ) {
        this.clazz = clazz;
    }

    public ArrayList<T> deseralization( String json ) {
        Type tipoLista = TypeToken.getParameterized(ArrayList.class, clazz).getType();
        return GSON.fromJson(json, tipoLista);
    }

    public String seralization( T clazz ) {
        return GSON.toJson(clazz);
    }

}
