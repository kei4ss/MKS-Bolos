package util;

public class AnalisadorDados {
    public static boolean isCpf(String dado){
        if (dado.length() == 11 && dado.matches("\\d+")){
            return true;
        }
        return false;
    }
}
