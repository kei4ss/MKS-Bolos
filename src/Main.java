import util.ManualData;
import screen.InitialScreen;

public class Main {
    public static void main(String[] args) {
        ManualData.openScanner();
        InitialScreen.start();
        ManualData.closeScanner();
    }
}