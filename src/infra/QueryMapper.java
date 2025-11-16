package infra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QueryMapper {

    public static Map<String, String> get( String query ) {

        Map<String, String> map = new HashMap<>();

        String[] kargs = query.split("[&=]");

        for ( int i = 0 ; i < kargs.length ; i += 2 )
            map.put(kargs[i], kargs[i + 1]);

        return map;

    }

}
