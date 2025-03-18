package screen;

import entidades.Cliente;
import entidades.DAO.ClienteDAO;
import util.AnalisadorDados;
import util.ManualData;

public class UserScreen {
    private static Cliente cliente = null;

    /**
     * <h1>Inicia o processo de identificação do cliente</h1>
     * <p>
     * Este método solicita ao usuário a inserção de um CPF e verifica se ele pertence
     * a um cliente cadastrado no banco de dados. Caso o cliente seja encontrado, o sistema
     * atribui o cliente à variável global e exibe o menu. Se o cliente não existir, oferece
     * a opção de cadastro.
     * </p>
     *
     * <h2>Fluxo do método:</h2>
     * <ul>
     *     <li>Solicita ao usuário um CPF.</li>
     *     <li>Verifica se o CPF tem as caracteristicas de um CPF (11 digidos e numérico)</li>
     *     <li>Se o CPF for válido, consulta o banco de dados para encontrar o cliente.</li>
     *     <li>Se o cliente for encontrado, exibe o menu do sistema.</li>
     *     <li>Se o cliente não for encontrado, oferece a opção de cadastro.</li>
     *     <li>Se o usuário optar por cadastrar, chama o método {@code insertNewClient()}.</li>
     *     <li>Se o CPF for inválido, exibe uma mensagem de erro.</li>
     * </ul>
     */
    public static void start(){
        System.out.print("Insira seu CPF (apenas números): ");
        String cpf = ManualData.getString();

        if(AnalisadorDados.isCpf(cpf)) {
            Cliente c = ClienteDAO.selectClientByCPF(cpf);
            if(c != null){
                cliente = c;
                menu();
            } else{
                System.out.printf("Não há registros de um usuário com o CPF %s \n", cpf);
                cadastrarCLienteScreen(cpf);
            }
        }else{
            System.out.println("A informação inserida não corresponde a um CPF.");
            System.out.print("Verifique os dados inseridos e tente novamente. [ APERTE ENTER ] ");
            ManualData.getString();
        }
    }

    /**
     * <h1>Exibe o menu do cliente</h1>
     * <p>
     * Este método apresenta o menu principal para o cliente autenticado,
     * permitindo que ele visualize seus dados, veja suas compras anteriores,
     * compre novos produtos ou saia da sessão.
     * </p>
     *
     * <h2>Fluxo do método:</h2>
     * <ul>
     *     <li>Verifica se um cliente foi selecionado.</li>
     *     <li>Exibe o cabeçalho e as opções do menu.</li>
     *     <li>Aguarda a entrada do usuário para escolher uma opção.</li>
     *     <li>Executa a ação correspondente à opção escolhida:</li>
     *     <ul>
     *         <li><b>1</b> - Exibe os dados do cliente.</li>
     *         <li><b>2</b> - Mostra o histórico de compras (a ser implementado).</li>
     *         <li><b>3</b> - Lista os produtos disponíveis para compra (a ser implementado).</li>
     *         <li><b>4</b> - Finaliza a sessão do cliente e retorna à tela inicial.</li>
     *         <li>Opção inválida - Exibe uma mensagem de erro.</li>
     *     </ul>
     *     <li>Se nenhuma opção de saída for escolhida, o menu é exibido novamente.</li>
     * </ul>
     *
     * <h2>Observação:</h2>
     * <p>Se nenhum cliente estiver autenticado, uma mensagem de erro será exibida.</p>
     */
    private static void menu(){
        if (cliente != null) {
            System.out.println(Header.CLIENTE_MENU);
            System.out.printf("""
                                    
                    Usuário(a): %s
                    -------------------------------
                    | 1 - Meus dados              |
                    | 2 - Minhas compras          |
                    | 3 - Comprar novos produtos  |
                    | 4 - Sair                    |
                    -------------------------------         
                    \n""", cliente.getName());
            System.out.print("-> ");
            Integer userResponse = ManualData.getInt();

            if (userResponse != null) {
                switch (userResponse) {
                    case 1:
                        System.out.println(cliente.toString());
                        System.out.print("...");
                        ManualData.getString();
                        break;
                    case 2:
                        System.out.println("Ver as compras passadas");
                        break;
                    case 3:
                        System.out.println("Listar os produtos disponíveis");
                        break;
                    case 4:
                        cliente = null;
                        InitialScreen.start();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
            menu();
        }else{
            System.out.println("Nenhum cliente foi selecionado.");
        }
    }


    private static void cadastrarCLienteScreen(String cpf){
        System.out.println("Você deseja se cadastrar como um novo cliente? ");
        System.out.println("""
                        ------------
                        | 1 - Sim  |
                        | 2 - Não  |
                        ------------
                        """);
        while(true) {
            System.out.print("-> ");
            Integer response = ManualData.getInt();
            if(response != null) {
                switch (response) {
                    case 1:
                        Cliente newCliente = new Cliente();
                        newCliente.setCpf(cpf);
                        insertNewClient(newCliente);
                        return;
                    case 2:
                        return;
                    default:
                        System.out.println("Opção inválida");
                        break;

                }
            }
        }

    }

    private static void insertNewClient(Cliente newCliente){
        System.out.println(Header.CADASTRO_CLIENTE);

        System.out.print("Insira seu nome: ");
        String nome = ManualData.getString();
        System.out.print("Insira um email de contato: ");
        String email = ManualData.getString();
        System.out.print("Para finalizar, informe seu endereço: ");
        String endereco = ManualData.getString();

        newCliente.setName(nome);
        newCliente.setEmail(email);
        newCliente.setEndereco(endereco);

        System.out.println(newCliente);
        System.out.println("As informações estão corretas? ");
        System.out.println("""
                        ------------
                        | 1 - Sim  |
                        | 2 - Não  |
                        ------------
                        """);
        while(true) {
            System.out.print("-> ");
            Integer response = ManualData.getInt();
            if(response != null) {
                switch (response) {
                    case 1:
                        if (ClienteDAO.insertCLiente(newCliente)) {
                            System.out.print("Cadastro feito com sucesso. ");
                            System.out.printf("Agradecemos por escolher nosso sistema, %s! \n", newCliente.getName());
                            System.out.println("[APERTE ENTER PARA CONTINUAR]");
                            ManualData.getString();
                            cliente = newCliente;
                            menu();
                            return;
                        }
                    case 2:
                        System.out.println("Ok, vamos tentar novamente");
                        insertNewClient(newCliente);
                        return;
                    default:
                        System.out.println("Opção inválida");
                        break;

                }
            }
        }

    }
}
