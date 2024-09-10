
package cat.xtec.ioc.repository;

import cat.xtec.ioc.domain.Xollo;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author chris
 */
public interface XolloRepository {
    Set<Xollo> getXolloByFilter(Map<String, List<String>> filterParams);
    Xollo getXolloByCodi(String codi);
    void addXollo(Xollo xollo);
}
