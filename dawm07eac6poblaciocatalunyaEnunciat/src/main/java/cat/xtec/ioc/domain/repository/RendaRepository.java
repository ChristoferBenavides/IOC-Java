package cat.xtec.ioc.domain.repository;

import cat.xtec.ioc.domain.Renda;
import java.util.List;

public interface RendaRepository {
    List<Renda> getAll();
    List<Renda> getByYear(int year);
    void add(Renda renda);
    void update(Renda renda);
    void delete(int any);
    List<Renda> getByOrigen(String origen);
}
