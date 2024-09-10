package cat.xtec.ioc.domain.repository.impl;

import cat.xtec.ioc.domain.Renda;
import cat.xtec.ioc.domain.repository.RendaRepository;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryRendaRepository implements RendaRepository {

    private List<Renda> rendes = new ArrayList<>();

    public InMemoryRendaRepository() {
        carregarDades("/dades/dades.csv");
    }

    @Override
    public List<Renda> getAll() {
        return rendes;
    }

    @Override
    public List<Renda> getByYear(int year) {
        List<Renda> result = new ArrayList<>();
        for (Renda renda : rendes) {
            if (renda.getAny() == year) {
                result.add(renda);
            }
        }
        return result;
    }
    
    @Override
    public List<Renda> getByOrigen(String origen) {
        List<Renda> result = new ArrayList<>();
        for (Renda renda : rendes) {
            if (renda.getOrigen().equals(origen)) {
                result.add(renda);
            }
        }
        return result;
    }

    
    @Override
    public void add(Renda renda) {
        rendes.add(renda);
    }

    @Override
    public void update(Renda renda) {
        for (Renda rendaToUpdate : rendes) {
            if (rendaToUpdate.getAny() == renda.getAny() && rendaToUpdate.getOrigen().equals(renda.getOrigen())) {
                rendaToUpdate.setHomes(renda.getHomes());
                rendaToUpdate.setDones(renda.getDones());
                rendaToUpdate.setTotal(renda.getTotal());
                System.out.println("update : " + renda);
                return;
            }
        }
   
    }      
    
    @Override
    public void delete(int any) {
        List<Renda> rendasToRemove = new ArrayList<>();
        for (Renda renda : rendes) {
            if (renda.getAny() == any) {
                rendasToRemove.add(renda);
            }
        }
        rendes.removeAll(rendasToRemove);
    }
    


    private void carregarDades(String filePath) {
        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath);
            if (resourceAsStream != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream));
                String line;

                while ((line = br.readLine()) != null) {                                      
                    String[] tempArr = line.split(";");
                    
                    /* Aquesta condicional és perquè tempArr[0] mostrava un llarg de 7, 
                    quan només hauria de ser 4, per la qual cosa em sortia un error, 
                    llavors ho he solucionat d'aquesta manera*/
                    if(tempArr[0].length()>4){
                        tempArr[0] = tempArr[0].substring(3);
                    }
                    
                    int any = Integer.parseInt(tempArr[0]);                  
                    int homes = Integer.parseInt(tempArr[1]);
                    int dones = Integer.parseInt(tempArr[2]);
                    int total = Integer.parseInt(tempArr[3]);
                    String origen = tempArr[4];

                    Renda renda = new Renda(any, homes, dones, total, origen);
                    rendes.add(renda);
                }
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


