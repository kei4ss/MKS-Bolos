package screen;

import util.ManualData;

public class InitialScreen {
    public static void start(){

        System.out.println(Header.JMX_LOGO);
        System.out.println("""
                ---------------------------------
                | 1 - Entrar como usuário       |
                | 2 - Entrar como administrador |
                | 3 - Sair                      |
                ---------------------------------
                """);
        System.out.print("-> ");
        Integer userOption = ManualData.getInt();

        if(userOption != null){
            switch (userOption){
                case 1:
                    UserScreen.start();
                    break;
                case 2:
                    AdmScreen.start();
                    break;
                case 3:
                    System.out.println("Bye!");
                    ManualData.closeScanner();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

        start();
    }
}
