package tests;

import org.junit.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class TestSikuliX {

    @Test
    public void Test1() throws FindFailed {
        Screen sc = new Screen();
        Pattern image = new Pattern("/Users/guilhermerogatto/Documents/git/sikulix-tdc/spotify2.png");
        System.out.println(image.getFilename());

        sc.wait(image, 10);

        sc.click(image);
    }
}
