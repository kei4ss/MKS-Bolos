package screen;

import entidades.Adm;
import entidades.DAO.AdmDAO;
import util.ManualData;

public class AdmScreen {
    private static Adm currentAdm = null;

    public static void start(){
        System.out.print("Insira seu login: ");
        String login = ManualData.getString();
        System.out.print("Insira sua senha: ");
        String senha = ManualData.getString();

        Adm adm = AdmDAO.selectAdmByLogin(login);
        if(adm != null){
            if(adm.getSenha().equals(senha)){
                currentAdm = adm;
                menu();
            }else System.out.println("Senha incorreta");
        }else System.out.println("Login não encontrado");
    }

    public static void menu(){
        if(currentAdm != null){
            System.out.println("""
                    ----------------------
                    | 1 - Produtos      |
                    | 2 - Pagamentos    |
                    | 3 - Usuários      |
                    | 4 - Sair          |
                    ----------------------
                    """);
            while(true) {
                System.out.print("-> ");
                Integer response = ManualData.getInt();
                switch (response){
                    case 1:
                        System.out.println("Opções de gerenciamento de produtos");
                        ManualData.getString();
                        break;
                    case 2:
                        System.out.println("Opções de gerenciamento de pagamentos");
                        ManualData.getString();
                        break;
                    case 3:
                        System.out.println("Opções de gerenciamento de usuário");
                        ManualData.getString();
                        break;
                    case 4:
                        InitialScreen.start();
                        return;
                    default:
                        System.out.println("Opção inválida");
                        break;

                }
            }
        }
    }
}
