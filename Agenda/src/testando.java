/*


                        while (terminou != true) {
                            System.out.println("Qual o nome do contato à ser excluido?");
                            nome = tec.next();
                            nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
                            contador = 0;
                            for (int x = 0; x < agenda.size(); x++) {
                                if (agenda.get(x).getNome().contains(nome)) {
                                    System.out.println("Nome: " + agenda.get(x).getNome() + " || Telefone: " + agenda.get(x).getNumero());
                                    contador ++;
                                }
                            }
                            if(contador == 0){
                                System.out.println("Não foi encontrado nenhum contato com o nome procurado");
                            }
                            if(contador == 1){
                                System.out.println("Você tem certeza que deseja excluir " + agenda.get(contador).getNome() + "?");
                                escolha = tec.next();
                                if (escolha.equals("sim") || escolha.equals("s") || escolha.equals("Sim") || escolha.equals("S")) {
                                    agenda.remove(contador);
                                    grava(agenda);
                                }
                                System.out.println("Agenda atualizada com sucesso!! ENTER para continuar");
                                System.in.read();
                                terminou = true;
                            }
                            if(contador >= 2){
                                System.out.println("Caso queria excluir apenas um numero informe o mesmo, caso queira excluir todos digite \"todos\":");
                                numero = tec.next();
                                if (numero.equals("todos") || numero.equals("Todos")){
                                    System.out.println("Você tem certeza que deseja excluir todos?");
                                    escolha = tec.next();
                                    if (escolha.equals("sim") || escolha.equals("s") || escolha.equals("Sim") || escolha.equals("S")) {
                                        for (int x = 0; x <= agenda.size(); x++) {
                                            if (agenda.get(x).getNome().contains(nome)) {
                                            agenda.remove(x);
                                            System.out.println(agenda);
                                            }
                                        }
                                        grava(agenda);
                                        System.out.println("Agenda atualizada com sucesso!! ENTER para continuar");
                                        System.in.read();
                                        terminou = true;
                                    }
                                    else{
                                        System.out.println("Deseja tentar novamente?");
                                        escolha = tec.next();
                                        if (escolha.equals("sim") || escolha.equals("s") || escolha.equals("Sim") || escolha.equals("S")){
                                            terminou = false;
                                        }
                                        else{
                                            terminou = true;
                                        }
                                    }
                                }
                                else {
                                    for (int x = 0; x < agenda.size(); x++) {
                                        if (agenda.get(x).getNome().contains(nome)) {
                                            if (agenda.get(x).getNumero().equals(numero)) {
                                                contador = x;
                                                System.out.println("Você tem certeza que deseja excluir " + agenda.get(contador).getNome() + "?");
                                                escolha = tec.next();
                                                if (escolha.equals("sim") || escolha.equals("s") || escolha.equals("Sim") || escolha.equals("S")) {
                                                    agenda.remove(contador);
                                                    terminou = true;
                                                } else {
                                                    terminou = false;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        terminou = false;

 */


