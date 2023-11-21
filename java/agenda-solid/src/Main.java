    import com.agenda.dominio.Compromisso;
    import com.agenda.dominio.Contato;
    import com.agenda.dominio.Local;
    import com.agenda.persistencia.DBConnection;
    import com.agenda.persistencia.MySQL;
    import com.agenda.repositorio.CompromissoRepositoyImpl;
    import com.agenda.repositorio.ContatoRepositoryImpl;
    import com.agenda.repositorio.LocalRepositoryImpl;
    import com.agenda.servico.CompromissoService;
    import com.agenda.servico.ContatoService;
    import com.agenda.servico.LocalService;

    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) throws SQLException {
            DBConnection dbConnection = new MySQL();

            ContatoRepositoryImpl contatoRepository = new ContatoRepositoryImpl(dbConnection);
            ContatoService contatoService = new ContatoService(contatoRepository);
            LocalRepositoryImpl localRepository = new LocalRepositoryImpl(dbConnection);
            LocalService localService = new LocalService(localRepository);
            CompromissoRepositoyImpl compromissoRepository = new CompromissoRepositoyImpl(dbConnection);
            CompromissoService compromissoService = new CompromissoService(compromissoRepository);
            List<Compromisso> compromissos = new ArrayList<>();

            while (true) {
                System.out.println("=============================== ");
                System.out.println("1 - INSERIR COMPROMISSO         ");
                System.out.println("2 - EXCLUIR COMPROMISSO         ");
                System.out.println("3 - EXIBIR UM COMPROMISSO       ");
                System.out.println("4 - EXIBIR TODOS OS COMPROMISSOS");
                System.out.println("5 - SAIR                        ");
                System.out.println("=============================== ");
                int opcao = new Scanner(System.in).nextInt();
                switch (opcao) {
                    case 1:
                        Compromisso compromisso = new Compromisso();
                        Local local = new Local();

                        System.out.println("Digite a descrição do compromisso:");
                        String descricao_compromisso = new Scanner(System.in).nextLine();
                        compromisso.setDescricao(descricao_compromisso);
                        System.out.println("Digite o local do compromisso:");
                        String descricao_local = new Scanner(System.in).nextLine();
                        local.setDescricao(descricao_local);
                        localService.salvar(local);
                        compromisso.setLocal(local);
                        compromissoService.salvar(compromisso);
                        System.out.println("Digite quantos contatos participarão desse compromisso:");
                        int quantidade_contatos = new Scanner(System.in).nextInt();
                        for (int i=0;i<quantidade_contatos;i++){
                            Contato contato = new Contato();
                            System.out.println("Digite o nome do " + (i + 1) + "° contato:");
                            String nome_contato = new Scanner(System.in).nextLine();
                            contato.setNome(nome_contato);
                            System.out.println("Digite o e-mail do " + (i + 1) + "° contato:");
                            String email_contato = new Scanner(System.in).nextLine();
                            contato.setEmail(email_contato);
                            System.out.println("Digite o telefone do " + (i + 1) + "° contato:");
                            String telefone_contato = new Scanner(System.in).nextLine();
                            contato.setTelefone(telefone_contato);
                            contatoService.salvar(contato);
                            compromissoService.associarEntidades(compromisso.getId(),contato.getId());
                        }
                        System.out.println("Compromisso cadastrado");
                        break;
                    case 2:
                        System.out.println("Digite o ID do compromisso: ");
                        Long id_compromisso = new Scanner(System.in).nextLong();
                        compromissoService.excluir(id_compromisso);
                        break;
                    case 3:
                        System.out.println("Digite o ID do compromisso: ");
                        id_compromisso = new Scanner(System.in).nextLong();
                        Compromisso compromissoSelecionado = compromissoService.listarPorId(id_compromisso);
                        System.out.println(compromissoSelecionado.toString());
                        break;
                    case 4:
                        compromissos = compromissoService.listarTodos();
                        for(Compromisso i : compromissos){
                            System.out.println(i.toString());
                        }
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }

            }

        }
    }