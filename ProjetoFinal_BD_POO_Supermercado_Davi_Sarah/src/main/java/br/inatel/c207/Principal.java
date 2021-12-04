package br.inatel.c207;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        while (true) {
            //Pega o valor digitado e salva na variavel
            System.out.println("Entre com um numero:");
            System.out.println("1: Para Funcionários");
            System.out.println("2: Para Consumidores");
            System.out.println("3: Para Setores:");
            System.out.println("4: Para Compras:");

            int conceito = teclado.nextInt();
            FuncionarioDB fDB = new FuncionarioDB();
            ConsumidorDB cDB = new ConsumidorDB();
            CartaoDB carDB = new CartaoDB();
            SetorDB sDB = new SetorDB();
            CompraDB buyDB = new CompraDB();
            switch (conceito) {
                case 1:
                    System.out.println("1: Para cadastrar funcionário");
                    System.out.println("2: Para atualizar o salário de um funcionario");
                    System.out.println("3: Para excluir um funcionarios");
                    System.out.println("4: Para visualizar um funcionário");
                    System.out.println("5: Para cadastrar um funcionário em um setor");
                    conceito = teclado.nextInt();
                    switch (conceito) {
                        case 1:
                            Funcionario f = new Funcionario();
                            System.out.println("Entre com o CPF:");
                            f.setCpf(teclado.nextInt());
                            teclado.nextLine();
                            System.out.println("Entre com o nome:");
                            f.setNome(teclado.nextLine());
                            System.out.println("Entre com telefone:");
                            f.setTelefone(teclado.nextInt());
                            teclado.nextLine();
                            System.out.println("Entre com endereco:");
                            f.setEndereco(teclado.nextLine());
                            System.out.println("Entre com a data de nascimento :");
                            f.setData_nasc(teclado.nextLine());
                            System.out.println("Entre com o salario :");
                            f.setSalario(teclado.nextFloat());
                            fDB.insertFuncionario(f);
                            break;
                        case 2:
                            System.out.println("Entre com a matrícula e o salário");
                            fDB.updateFuncionario(teclado.nextInt(), teclado.nextInt());
                            break;
                        case 3:
                            System.out.println("Entre com a matrícula");
                            fDB.deleteFuncionario(teclado.nextInt());
                            break;
                        case 4:
                            System.out.println("Entre com a matrícula");
                            fDB.researtFuncionario(teclado.nextInt());

                        case 5:
                            System.out.println("Entre com a matricula do funcionário e o número do setor");
                            fDB.insertFuncionarioSetor(teclado.nextInt(), teclado.nextInt());
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1: Para cadastrar consumidor");
                    System.out.println("2: Para excluir um consumidor");
                    System.out.println("3: Para visualizar um consumidor");
                    conceito = teclado.nextInt();
                    switch (conceito) {
                        case 1:
                            Consumidor c = new Consumidor();
                            Cartao card = new Cartao();
                            System.out.println("Entre com o CPF:");
                            c.setCpf(teclado.nextInt());
                            teclado.nextLine();
                            System.out.println("Entre com o nome:");
                            c.setNome(teclado.nextLine());
                            System.out.println("Entre com telefone:");
                            c.setTelefone(teclado.nextInt());
                            teclado.nextLine();
                            System.out.println("Entre com endereco:");
                            c.setEndereco(teclado.nextLine());
                            System.out.println("Entre com a data de nascimento :");
                            c.setData_nasc(teclado.nextLine());
                            card.setLimite(1500f);
                            System.out.println("Entre com o numero do cartao:");
                            int temp = teclado.nextInt();
                            teclado.nextLine();
                            card.setN_cartao(temp);
                            c.setFk_cartao(temp);
                            System.out.println("entre com a data de vencimento:");
                            card.setData_venc(teclado.nextLine());
                            carDB.insertCartao(card);
                            cDB.insertConsumidor(c);


                            break;
                        case 2:
                            System.out.println("Entre com a matrícula do consumidor");
                            cDB.deleteConsumidor(teclado.nextInt());
                            break;
                        case 3:
                            System.out.println("Entre com a matrícula do consumidor");
                            cDB.researtConsumidor(teclado.nextInt());
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1: Para cadastrar um setor");
                    System.out.println("2: Para visualizar um setor");
                    System.out.println("3: Para excluir um setor");
                    conceito = teclado.nextInt();
                    switch (conceito) {
                        case 1:
                            Setor s = new Setor();
                            System.out.println("Entre com o código do setor:");
                            s.setCodigo(teclado.nextInt());
                            teclado.nextLine();
                            System.out.println("Entre com o nome do setor:");
                            s.setNome(teclado.nextLine());
                            System.out.println("Entre com a localidade do setor:");
                            s.setLocalidade(teclado.nextLine());
                            sDB.insertSetor(s);
                            break;
                        case 2:
                            System.out.println("Entre com o código do setor");
                            sDB.researtSetor(teclado.nextInt());
                            break;
                        case 3:
                            System.out.println("Entre com a código do setor");
                            sDB.deleteSetor(teclado.nextInt());
                            break;
                    }
                    break;
                case 4:
                    System.out.println("1: Para cadastrar uma compra");
                    System.out.println("2: Para visualizar os dados de uma compra");
                    System.out.println("3: Para vincular uma compra a um consumidor");
                    conceito = teclado.nextInt();
                    switch (conceito) {
                        case 1:
                            Compra buy = new Compra();
                            System.out.println("Entre com o número da compra:");
                            buy.setNum_compra(teclado.nextInt());
                            teclado.nextLine();
                            System.out.println("Entre com o código do consumidor:");
                            buy.setIdConsumidor(teclado.nextInt());
                            teclado.nextLine();
                            System.out.println("Entre com o valor da compra:");
                            buy.setValor(teclado.nextInt());
                            teclado.nextLine();
                            buyDB.insertCompra(buy);
                            break;
                        case 2:
                            System.out.println("Entre com o número da compra");
                            buyDB.researtCompra(teclado.nextInt());
                            break;
                        case 3:
                            System.out.println("Entre com o número da compra e o código do consumidor");
                            buyDB.updateCompra(teclado.nextInt(), teclado.nextInt());
                            break;
                    }
                    break;
                    default:
                        break;
                    }
            }
        }
    }