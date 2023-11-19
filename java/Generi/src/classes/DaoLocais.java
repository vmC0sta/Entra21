package classes;

import interfaces.Contato;
import interfaces.ICrud;

import java.util.List;

public class DaoLocais implements ICrud {

    @Override
    public boolean salvar(Contato contato) {
        return false;
    }

    @Override
    public boolean alterar(Contato contato) {
        return false;
    }

    @Override
    public List<Contato> consultar() {
        return null;
    }

    @Override
    public Contato consultaPorId(int id) {
        return null;
    }

    @Override
    public void deletar(int id) {

    }
}
