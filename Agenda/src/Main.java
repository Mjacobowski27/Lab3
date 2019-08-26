import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main (String args[]) throws IOException {
        Scanner tec = new Scanner(System.in);
        ArrayList<Contato> agenda = new ArrayList<Contato>();
        int[] resultados;
        resultados = new int[10];
        int contador;
        String escolha;
        String nome;
        String numero;
        boolean loop = false;
        boolean terminou = false;
        FileOutputStream out = null;

        // lendo a agenda ja existente.
        FileReader arq;
        try {
            arq = new FileReader("Agenda");
            BufferedReader br = new BufferedReader(arq);

            String linha;
            while( (linha = br.readLine()) != null){
                String[] entrada = new String[2];
                entrada = linha.split(", ");
                Contato leitura = new Contato(entrada[0], entrada[1]);
                agenda.add(leitura);
                Collections.sort (agenda, new Comparator() {
                    public int compare(Object o1, Object o2) {
                        Contato c1 = (Contato) o1;
                        Contato c2 = (Contato) o2;
                        return c1.getNome().compareToIgnoreCase(c2.getNome());
                    }
                });
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

        while(loop != true) {
            System.out.println("");
            System.out.println("***********************");
            System.out.println("*  Agenda Telefônica  *");
            System.out.println("* 1 - Contatos        *");
            System.out.println("* 2 - Buscar contato  *");
            System.out.println("* 3 - Adicionar       *");
            System.out.println("* 4 - Editar          *");
            System.out.println("* 5 - Excluir         *");
            System.out.println("* 9 - Sair            *");
            System.out.println("***********************");
            int controle = tec.nextInt();

            switch (controle) {
                //Listando os contatos
                case 1:    for (int x = 1; x < agenda.size(); x++){
                    System.out.println("Nome: " + agenda.get(x).getNome() + " || Telefone: " + agenda.get(x).getNumero());
                }
                    System.in.read();
                    break;
                //Buscando na lista de contatos
                case 2 :
                while(terminou != true) {
                    System.out.println("Qual o nome do contato à ser buscado?");
                    nome = tec.next();
                    escolha = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
                    boolean achou = false;
                    for (int x = 0; x < agenda.size(); x++) {
                        if (agenda.get(x).getNome().contains(nome)) {
                            System.out.println("Nome: " + agenda.get(x).getNome() + " || Telefone: " + agenda.get(x).getNumero());
                            achou = true;
                            terminou = true;
                        }
                    }
                    for (int x = 0; x < agenda.size(); x++) {
                        if (agenda.get(x).getNome().contains(escolha)) {
                            System.out.println("Nome: " + agenda.get(x).getNome() + " || Telefone: " + agenda.get(x).getNumero());
                            achou = true;
                            terminou = true;
                        }
                    }
                    if (!achou) {
                        System.out.println("Nome não encontrado, deseja tentar novamente?");
                        nome = tec.next();
                        if (nome.equals("sim") || nome.equals("s") || nome.equals("Sim") || nome.equals("S")){
                            terminou = false;
                        }
                        else{
                            terminou = true;
                        }
                    }
                }
                    terminou = false;
                    System.in.read();
                    break;
                //Adicionando contato e atualizando arquivo txt
                case 3 :
                    System.out.println("Qual o nome do contato a ser adicionado?");
                    nome = tec.next();
                    nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
                    System.out.println("Qual o numero do contato a ser adicionado?");
                    numero = tec.next();
                    Contato contato = new Contato(nome, numero);
                    agenda.add(contato);
                    grava(agenda);
                    System.out.println("Agenda atualizada com sucesso!!");
                    System.out.println("ENTER para continuar");
                    break;
                //Editar contato ja existente
                case 4 :
                try{
                    while(terminou != true){
                        System.out.println("Qual nome deseja editar?");
                        nome = tec.next();
                        escolha = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
                        contador = 0;
                        int[] contagem = new int[99];
                        for(int x = 0; x < agenda.size(); x++){
                            if(agenda.get(x).getNome().contains(nome)){
                                System.out.println("Nome: " + agenda.get(x).getNome() + " || Telefone: " + agenda.get(x).getNumero());
                                contagem[contador] = x;
                                contador ++;
                            }
                        }for(int x = 0; x < agenda.size(); x++){
                            if(agenda.get(x).getNome().contains(escolha)){
                                System.out.println("Nome: " + agenda.get(x).getNome() + " || Telefone: " + agenda.get(x).getNumero());
                                contagem[contador] = x;
                                contador ++;
                            }
                        }
                        if(contador == 0){
                            System.out.println("Nome não encontrado, deseja tentar novamente?");
                            escolha = tec.next();
                            if (escolha.equals("sim") || escolha.equals("s") || escolha.equals("Sim") || escolha.equals("S")){
                                terminou = false;
                            }
                            else{
                                terminou = true;
                            }
                        }
                        else if(contador == 1){
                            System.out.println("Você tem certeza que deseja editar " + agenda.get(contagem[0]).getNome() + "?");
                            escolha = tec.next();
                            if (escolha.equals("sim") || escolha.equals("s") || escolha.equals("Sim") || escolha.equals("S")){
                                System.out.println("Qual novo numero?");
                                numero = tec.next();
                                agenda.get(contagem[0]).setNumero(numero);
                                grava(agenda);
                                System.out.println("Agenda atualizada com sucesso!!");
                            }
                            System.out.println("ENTER para continuar");
                            System.in.read();
                            terminou = true;
                        }
                        else if(contador >= 2){
                            System.out.println("Insira o numero do contato que você deseja editar:");
                            numero = tec.next();
                            for (int x = 0; x < agenda.size(); x++) {
                                if(agenda.get(x).getNome().equals(nome)){
                                    if (agenda.get(x).getNumero().equals(numero)) {
                                        System.out.println("Insira o novo numero:");
                                        numero = tec.next();
                                        agenda.get(x).setNumero(numero);
                                        grava(agenda);
                                        System.out.println("Agenda atualizada com sucesso!!");
                                    }
                                }
                                else{
                                    System.out.println("Numero nao encontrado");
                                }
                            }
                            System.out.println("ENTER para continuar");
                            System.in.read();
                            terminou = true;

                        }
                    }
                    terminou = false;
                }
                catch (Exception ex) {
                    System.out.println(ex);
                }
                break;
                case 5:
                    try {
                        while(terminou != true){
                            System.out.println("Qual contato deseja excluir?");
                            nome = tec.next();
                            nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
                            contador = 0;
                            int[] contagem = new int[99];
                            for (int x = 0; x < agenda.size(); x++) {
                                if (agenda.get(x).getNome().contains(nome)) {
                                    System.out.println("Nome: " + agenda.get(x).getNome() + " || Telefone: " + agenda.get(x).getNumero());
                                    contagem[contador] = x;
                                    contador++;
                                }
                            }
                            if(contador == 0){
                                System.out.println("Nome não encontrado, deseja tentar novamente?");
                                escolha = tec.next();
                                if (escolha.equals("sim") || escolha.equals("s") || escolha.equals("Sim") || escolha.equals("S")){
                                    terminou = false;
                                }
                                else{
                                    terminou = true;
                                }
                            }
                            else if(contador == 1){
                                System.out.println("Você tem certeza que deseja excluir " + agenda.get(contagem[0]).getNome() + "?");
                                escolha = tec.next();
                                if (escolha.equals("sim") || escolha.equals("s") || escolha.equals("Sim") || escolha.equals("S")) {
                                    agenda.remove(contagem[0]);
                                    grava(agenda);
                                    System.out.println("Agenda atualizada com sucesso!! ENTER para continuar");
                                }
                                System.in.read();
                                terminou = true;
                            }
                            else if(contador >= 2){
                                System.out.println("Insira o numero do contato que você deseja excluir:");
                                numero = tec.next();
                                for (int x = 0; x < agenda.size(); x++) {
                                    if (agenda.get(x).getNumero().equals(numero)) {
                                        agenda.remove(x);
                                    }
                                }
                                grava(agenda);
                                System.out.println("Agenda atualizada com sucesso!!");
                                System.out.println("ENTER para continuar");
                                System.in.read();
                                terminou = true;

                            }
                        }
                        terminou = false;
                    }
                    catch (Exception ex)
                    {
                        System.out.println(ex);
                    }
                    break;
                case 9 : System.out.println("Fim!!");
                    loop = true;
                    break;

                default: System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public static void grava(ArrayList agenda) throws IOException {
        ArrayList<Contato> gravacao = new ArrayList<Contato>();
        gravacao = agenda;
        Collections.sort (gravacao, new Comparator() {
            public int compare(Object o1, Object o2) {
                Contato c1 = (Contato) o1;
                Contato c2 = (Contato) o2;
                return c1.getNome().compareToIgnoreCase(c2.getNome());
            }
        });
        FileWriter fw = new FileWriter("Agenda");
        BufferedWriter bw = new BufferedWriter( fw );
        for (int x = 0; x < agenda.size(); x++){
            bw.write(gravacao.get(x).getNome() + ", " + gravacao.get(x).getNumero() + '\n');
        }
        bw.close();
        fw.close();
    }
}