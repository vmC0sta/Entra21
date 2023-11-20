import com.agenda.dominio.Contato;
import com.agenda.persistencia.DBConnection;
import com.agenda.persistencia.MySQL;
import com.agenda.repositorio.ContatoRepositoryImpl;
import com.agenda.servico.ContatoService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DBConnection dbConnection = new MySQL();
        ContatoRepositoryImpl contatoRepository = new ContatoRepositoryImpl(dbConnection);
        ContatoService contatoService = new ContatoService(contatoRepository);
        List<Contato> contatos = new ArrayList<>();

//        Contato contato1 = new Contato("Contato1","contato1@gmail.com","(47) 99607-5616");
//        Contato contato2 = new Contato("Contato2","contato2@gmail.com","(47) 94544-5516");
//
//        contatoService.salvar(contato1);
//        contatoService.salvar(contato2);

        contatos = contatoService.listarTodos();

        for(Contato contato : contatos){
            System.out.println(contato.toString());;
        }

        Contato contato = contatoService.listarPorId(22L);
        System.out.println(contato.toString());

        contatoService.excluir(19L);
        contatoService.excluir(20L);
    }
}