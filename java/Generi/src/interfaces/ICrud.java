package interfaces;

import java.util.List;

public interface ICrud {
    boolean salvar(Contato contato);
    boolean alterar(Contato contato);
    List<Contato> consultar();
    Contato consultaPorId(int id);
    void deletar(int id);
}
