
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Xollo;
import cat.xtec.ioc.domain.Vol;
import cat.xtec.ioc.domain.Lloguer;
import cat.xtec.ioc.domain.Hotel;
import cat.xtec.ioc.repository.XolloRepository;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author chris
 */
@Repository
public class InMemoryXolloRepository implements XolloRepository {
    
    private List<Xollo> llista = new ArrayList< Xollo >();
    
    public InMemoryXolloRepository() throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2023-04-15";
        String dateString2 = "2023-05-22";
        String dateString3 = "2023-05-26";
        Date date = dateFormat.parse(dateString);
        Date date2 = dateFormat.parse(dateString2);
        Date date3 = dateFormat.parse(dateString3);
        
        Vol vol1 = new Vol("vol0", "volTitol0", "volDescripcio0", 10, 10,
                "desti0", date, 2);
        Vol vol2 = new Vol("vol1", "volTitol1", "volDescripcio1", 5, 4,
                "desti1", date2, 3);
        Vol vol3 = new Vol("vol2", "volTitol2", "volDescripcio2", 7, 3,
                "desti2", date3 , 1);

        Hotel hotel1 = new Hotel("hotel0", "hotelTitol0", "hotelDescripcio0", 10, 10,
                "nom0", "habitacio0","direccio0");
        Hotel hotel2 = new Hotel("hotel1", "hotelTitol1", "hotelDescripcio2", 7, 4,
                "nom1", "habitacio1","direccio1");
        Hotel hotel3 = new Hotel("hotel2", "hotelTitol2", "hotelDescripcio3", 12, 5,
                "nom2", "habitacio2","direccio2");

        Lloguer lloguer1 = new Lloguer("lloguer0", "lloguerTitol0", "lloguerDescripcio0", 8, 4,
                "1234ABC", false, "Renault");
        Lloguer lloguer2 = new Lloguer("lloguer1", "lloguerTitol1", "lloguerDescripcio1", 25, 15,
                "5678DEF", true, "Honda");
        Lloguer lloguer3 = new Lloguer("lloguer3", "lloguerTitol2", "lloguerDescripcio2", 15, 10,
                "9012GHI", true, "Brompton");

        llista.add(vol1);
        llista.add(vol2);
        llista.add(vol3);
        llista.add(hotel1);
        llista.add(hotel2);
        llista.add(hotel3);
        llista.add(lloguer1);
        llista.add(lloguer2);
        llista.add(lloguer3);
    }

    public Xollo getXolloByCodi(String codi){
        Xollo xolloCodi = null;
        for (Xollo xollo : llista) {
            if (xollo != null && xollo.getCodi() != null
                    && xollo.getCodi().equals(codi)) {
                xolloCodi = xollo;
                break;
            }
        }
        if (xolloCodi == null) {
            throw new IllegalArgumentException(
                    "No s'han trobat xollo amb el codi: " + codi);
        }
        return xolloCodi;
    }

    public Set<Xollo> getXolloByFilter(Map<String, List<String>> filterParams) {
        Set<Xollo> xolloToAdd = new HashSet<Xollo>();       
        Set<String> criterias = filterParams.keySet();
                
        if (criterias.contains("tipus") & (criterias.contains("title"))) {           
            for (String tipo : filterParams.get("tipus")) { 
                for (String titol : filterParams.get("title")){
                    for (Xollo xollo : llista) {
                        try {
                            if (Class.forName("cat.xtec.ioc.domain." + tipo).isInstance(xollo) & (titol.equalsIgnoreCase(xollo.getTitol()))) {
                                xolloToAdd.add(xollo);                                                        
                            }
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(InMemoryXolloRepository.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }                          
            }    
        } 
                  
        return xolloToAdd;        
    }

     public void addXollo(Xollo xollo) {
        llista.add(xollo);
    }
    
}
