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

//            Local local1 = new Local("Escola");
//            localService.salvar(local1);
//
//            Compromisso compromisso1 = new Compromisso("Estudar", local1);
//            compromissoService.salvar(compromisso1);
//            Contato contato1 = new Contato("contato1", "duda.cv2404@gmail.com", "44444444");
//            contatoService.salvar(contato1);
//            Contato contato2 = new Contato("contato2", "contato2@gmail.com", "333333333333");
//            contatoService.salvar(contato2);
//
//            Local local2 = new Local("Trabalho");
//            localService.salvar(local2);
//            Compromisso compromisso2 = new Compromisso("Estudar", local2);
//            compromissoService.salvar(compromisso2);
//            Contato contato3 = new Contato("contato3", "contato3@gmail.com", "555555555");
//            contatoService.salvar(contato3);
//            compromissoService.associate(compromisso1.getId(), contato1.getId());
//            compromissoService.associate(compromisso1.getId(), contato2.getId());
//            compromissoService.associate(compromisso2.getId(), contato3.getId());

            compromissoService.excluirAssociate(21L,27L);
            compromissos = compromissoService.listarTodos();
            for (Compromisso compromisso : compromissos) {
                System.out.println(compromisso.toString());
            }

        }
    }