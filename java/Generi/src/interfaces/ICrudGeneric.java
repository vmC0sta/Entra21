package interfaces;

import java.util.List;

public interface ICrudGeneric<T>{
    boolean salvar(T t);
    boolean alterar(T t);
    List<T> consultar();
    Contato consultaPorId(int id);
    void deletar(int id);
}
