package classes;

import interfaces.Contato;
import interfaces.ICrudGeneric;
import interfaces.Local;

import java.util.List;

public class DaoLocaisGeneric implements ICrudGeneric<Local> {

    @Override
    public boolean salvar(Local local) {
        return false;
    }

    @Override
    public boolean alterar(Local local) {
        return false;
    }

    @Override
    public List<Local> consultar() {
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
