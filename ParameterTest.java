import java.util.List;
import java.util.ArrayList;

public class ParameterTest {
    public static void main(String... args) {
        Volume volume = new Volume(66);
        Pan pan = new Pan(-2);

        // "Always program to an interface, not an implementation."
        // The variable is a List, but the created instance 
        // is ArrayList (which implements List).
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameters.add(volume);
        parameters.add(pan);

        for (Parameter p : parameters) {
            System.out.println(p);
        }

        // Set the volume to clamping. Then try an invalid value.
        volume.setClamping(true);
        volume.setValue(666);
        System.out.println("clamped volume = " + volume.getValue());

        // Try to set pan to an invalid value.
        // Throws InvalidArgumentException.
        pan.setValue(1000);
    } 
}
