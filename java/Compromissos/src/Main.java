import entidades.Contato;
import persistencias.ContatoDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Contato contato = new Contato("aaa","aaa","aaaa");

        ContatoDAO contatoDAO = new ContatoDAO();

        contatoDAO.inserir(contato);
        contatoDAO.getById(15);

    }
}