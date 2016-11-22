import java.awt.Color;
import GUI.desktop_codebehind.Car;
import GUI.desktop_resources.GUI;

public class CarTest {
    
    public static void main(String[] args) {
        Car car = new Car.Builder()
            .typeRacecar()
            .primaryColor(Color.BLUE)
            .secondaryColor(Color.RED)
            .patternDiagonalDualColor()
            .build();
        GUI.addPlayer("Sebastian Vettel", 25000, car);
    }
}
