package entidades;

public class Cliente implements Cloneable{
    private Integer id;
    private String name;
    private String telefone;
    private String email;
    private String endereco;
    private String cpf;

    public Cliente(int id,String name, String telefone, String email, String endereco, String cpf) {
        this.id = id;
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public Cliente(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        String txt =  "-----------------------------------------\n";
        if(this.id != null){
            txt = txt +  "| ID: " + id + "\n";
        }
        txt = txt + "| Nome: " + name + "\n" +
                "| Telefone: " + (telefone!=null?telefone:"Não informado") + "\n" +
                "| E-mail: " + email + "\n" +
                "| Endereço: " + endereco + "\n" +
                "| CPF: " + cpf + "\n" +
                "-----------------------------------------";


        return txt;
    }
}
