public class Contato {
    String nome;
    String numero;

    public Contato(){

    }

    public Contato(String nome, String numero){
        this.nome = nome;
        this.numero = numero;

    }

    public String getNome(){
        return this.nome;
    }

    public String getNumero(){
        return this.numero;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }
}
