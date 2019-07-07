import org.sikuli.script.*;

public class sikulix {


    public static void main(String[] args) throws FindFailed, InterruptedException {

        Screen sc = new Screen();
        Pattern image = new Pattern("/Users/guilhermerogatto/Documents/git/sikulix-tdc/src/main/resources/imgs/teste_fotor.png");
        System.out.println(image.getFilename());

        if(image.isValid()){
            System.out.println("existe");
        } else {
            System.out.println("não existe");
        }

        //sc.wait(image, 10);

        sc.click(image);

        //sc.capture();

        /* montar exemplo de match de imagem
           sc.compare();
         */

        /*
        // Create a screen region object that corresponds to the default monitor in full screen
        ScreenRegion s = new DesktopScreenRegion();

        // Specify an image as the target to find on the screen
        URL imageURL = new URL("http://code.google.com/images/code_logo.gif");
        Target imageTarget = new ImageTarget(imageURL);

        // Wait for the target to become visible on the screen for at most 5 seconds
        // Once the target is visible, it returns a screen region object corresponding
        // to the region occupied by this target
        ScreenRegion r = s.wait(imageTarget,5000);
         */
    }
}
