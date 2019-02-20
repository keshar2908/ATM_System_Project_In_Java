import java.io.IOException;

public class Clear {
    public static void main(String[] arg) throws Exception{
        Clear c = new Clear();
        c.screen();

    }
    public void screen() throws Exception {
   		new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    }
}