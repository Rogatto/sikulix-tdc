import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class sikulix {


    public static void main(String[] args) throws FindFailed {


        Screen sc = new Screen();
        Pattern image = new Pattern();
        sc.wait(image, 19);
    }
}
