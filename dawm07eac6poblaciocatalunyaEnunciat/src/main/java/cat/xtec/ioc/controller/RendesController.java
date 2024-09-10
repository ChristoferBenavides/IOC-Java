package cat.xtec.ioc.controller;

import cat.xtec.ioc.domain.Renda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cat.xtec.ioc.domain.repository.RendaRepository;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class RendesController {

    @Autowired
    private RendaRepository rendaRepository;

    public RendesController() {
    }

    public RendesController(RendaRepository rendaRepository) {
        this.rendaRepository = rendaRepository;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/origen/{origen}")
    @ResponseBody
    public List<Renda> getRendaByOrigen(@PathVariable String origen) {
        return rendaRepository.getByOrigen(origen);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/rendes")
    @ResponseBody
    public List<Renda> getAllRendes() {
        return rendaRepository.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rendes/{any}")
    @ResponseBody
    public List<Renda> getRendaByYear(@PathVariable int any) {
        return rendaRepository.getByYear(any);
    }
    
   @RequestMapping(method = RequestMethod.POST, value = "/rendes")
    @ResponseBody
    public ResponseEntity<Renda> create(@RequestBody String stryany) {
        try {

            JSONArray array = new JSONArray(stryany);
            JSONObject object = array.getJSONObject(0);
            /* No he utilitzat Integer.parseInt(object.getString("any")), 
            perquè no em funcionava i he llegit que json ja em feia la conversió corresponent */
            int any = object.getInt("any");
            int total = object.getInt("total");
            int homes = object.getInt("homes");
            int dones = object.getInt("dones");
            String origen = object.getString("origen");

            Renda renda = new Renda(any, homes, dones, total, origen);
            rendaRepository.add(renda);

            return new ResponseEntity<>(renda, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/rendes")
    @ResponseBody
    public ResponseEntity<Renda> update(@RequestBody String stryany) {
        try {           
            JSONObject object = new JSONObject(stryany);

            int any = object.getInt("any");
            int total = object.getInt("total");
            int homes = object.getInt("homes");
            int dones = object.getInt("dones");
            String origen = object.getString("origen");

            Renda renda = new Renda(any, homes, dones, total, origen);
            rendaRepository.update(renda);

            return new ResponseEntity<>(renda, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



    @RequestMapping(method = RequestMethod.DELETE, value = "/rendes/{any}")
    @ResponseBody
    public ResponseEntity<Void> delete(@PathVariable int any) {
        rendaRepository.delete(any);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

