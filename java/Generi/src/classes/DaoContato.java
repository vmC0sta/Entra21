package classes;

import interfaces.Contato;
import interfaces.ICrud;
import interfaces.ICrudGeneric;

import java.util.List;

public class DaoContato implements ICrudGeneric<Contato>{

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


//public class DaoContato implements ICrud {
//
//    @Override
//    public boolean salvar(Contato contato) {
//        return false;
//    }
//
//    @Override
//    public boolean alterar(Contato contato) {
//        return false;
//    }
//
//    @Override
//    public List<Contato> consultar() {
//        return null;
//    }
//
//    @Override
//    public Contato consultaPorId(int id) {
//        return null;
//    }
//
//    @Override
//    public void deletar(int id) {
//
//    }
//}
