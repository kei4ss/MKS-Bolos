package util;

import java.util.Scanner;

public class ManualData {
    private static Scanner INPUT;

    public static Integer getInt(){
        try{
            int a = INPUT.nextInt();
            resetScanner();
            return a;
        }catch (Exception e){
            System.out.println("O dado informado não é Inteiro!");
            resetScanner();
        }
        return null;
    }

    public static String getString(){
        return INPUT.nextLine();
    }

    public static void openScanner(){
        INPUT = new Scanner(System.in);
    }
    public static void closeScanner(){
        INPUT.close();
    }
    public static void resetScanner(){
        if(INPUT.hasNextLine()){
            INPUT.nextLine();
        }
    }
}
