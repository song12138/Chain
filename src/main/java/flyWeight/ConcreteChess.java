package flyWeight;

/** 具体享元类:
 * Created by paul on 2017/11/24.
 */
public class ConcreteChess implements ChessFlyWeight{

    private String color;


    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate c) {
        System.out.println("棋子颜色："+color);
        System.out.println("棋子位置"+c.getX()+"-----"+c.getY());

    }
}
