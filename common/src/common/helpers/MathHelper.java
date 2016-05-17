package common.helpers;

/**
 * Created by Carlos Zubiran on 5/10/2016.
 */
public class MathHelper {

    //region PROPERTIES

    public static final double E = 2.71;
    public static final double PI = 3.14;



    //endregion PROPERTIES

    //region CONSTRUCTORS


    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS


    //endregion GETTERS / SETTERS

    //region CUSTOM METHODS

    public static int square(int val) {
        return val * val;
    }

    public static double areaOfACircle(double radius){
        return PI * Math.pow(radius, 2);
    }

    public static double areaOfARectangle(double width, double height) {
        return width * height;
    }

    public static double Power(double num, double power) {
        double result = 1;
        for (int i = 0; i < power; i++) {
            result *= num;
        }
        return result;
    }


    //endregion CUSTOM METHODS


}
