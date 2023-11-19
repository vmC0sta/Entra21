package generic;

import java.util.List;

public interface Generic<T> {
    void inserir(T t);
    void getById(int id);
    List<T> getAll();
    void atualizar(T t);
    void excluir(int id);
}
