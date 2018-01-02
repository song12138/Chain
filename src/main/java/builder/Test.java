package builder;

/**
 * Created by paul on 2017/11/9.
 */
public class Test {
    public static void main (String [] args){
        User u = new User.UserBuilder().username("sxf").age("24").height("180").build();

    }
}
