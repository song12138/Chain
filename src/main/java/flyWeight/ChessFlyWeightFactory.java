package flyWeight;

import java.util.HashMap;
import java.util.Map;

/** 享元工厂
 * Created by paul on 2017/11/24.
 */
public class ChessFlyWeightFactory {
    //享元池
    private static Map<String, ChessFlyWeight> map = new HashMap<>();

    public static ChessFlyWeight getChess(String color) {
        if (map.get(color) != null) {
            return map.get(color);
        }else {
            ChessFlyWeight chessFlyWeight = new ConcreteChess(color);
            map.put(color, chessFlyWeight);
            return chessFlyWeight;
        }
    }

}
