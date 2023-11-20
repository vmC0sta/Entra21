import com.agenda.dominio.Contato;
import com.agenda.dominio.Local;
import com.agenda.persistencia.DBConnection;
import com.agenda.persistencia.MySQL;
import com.agenda.repositorio.ContatoRepositoryImpl;
import com.agenda.repositorio.LocalRepositoryImpl;
import com.agenda.servico.ContatoService;
import com.agenda.servico.LocalService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DBConnection dbConnection = new MySQL();
//        ContatoRepositoryImpl contatoRepository = new ContatoRepositoryImpl(dbConnection);
//        ContatoService contatoService = new ContatoService(contatoRepository);
//        List<Contato> contatos = new ArrayList<>();
//        Contato contato1 = new Contato("Contato1","contato1@gmail.com","(47) 99607-5616");
//        Contato contato2 = new Contato("Contato2","contato2@gmail.com","(47) 94544-5516");
//        contatoService.salvar(contato1);
//        contatoService.salvar(contato2);
        
//        LocalRepositoryImpl localRepository = new LocalRepositoryImpl(dbConnection);
//        LocalService localService = new LocalService(localRepository);
//        List<Local> locais = new ArrayList<>();
//        Local local1 = new Local("Escola");
//        Local local2 = new Local("Trabalho");
//       localService.salvar(local1);
//        localService.salvar(local2);
//        locais = localService.listarTodos();
//       for(Local local : locais){
//           System.out.println(local.toString());
//       }
//        Local local = localService.listarPorId(3L);
//        System.out.println(local.toString());
//
    }
}