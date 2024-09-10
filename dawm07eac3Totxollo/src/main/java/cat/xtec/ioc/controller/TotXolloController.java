package cat.xtec.ioc.controller;

import cat.xtec.ioc.domain.Hotel;
import cat.xtec.ioc.domain.Lloguer;
import cat.xtec.ioc.domain.Vol;
import cat.xtec.ioc.domain.Xollo;
import cat.xtec.ioc.repository.XolloRepository;
import cat.xtec.ioc.service.VendaService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TotXolloController {
    
    @Autowired
    private XolloRepository xolloRepository;
    
     
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homeRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("home");
        modelview.getModelMap().addAttribute("banner", "Busca un xollo!");
        modelview.getModelMap().addAttribute("tagline", "");
        List<Map<String, Object>> options = new ArrayList<Map<String, Object>>();
        options.add(createOption("Afegir", "Permet afegir un article al catàleg de la botiga", "/add", "glyphicon-plus-sign glyphicon"));
        options.add(createOption("Consultar", "Permet consultar els articles del catàleg de la botiga", "/get", "glyphicon-list-alt glyphicon"));
        options.add(createOption("Filtrar", "Permet cercar,dins del catàleg de la botiga,algun article", "/filter", "glyphicon-filter glyphicon"));
        options.add(createOption("Comprar", "Permet comprar un article del catàleg de la botiga", "/venda", "glyphicon-shopping-cart glyphicon"));
        modelview.getModelMap().addAttribute("options", options);
        return modelview;
    }

    private Map<String, Object> createOption(String title, String desc, String url, String icon) {
        Map<String, Object> option = new HashMap<String, Object>();
        option.put("title", title);
        option.put("desc", desc);
        option.put("url", url);
        option.put("icon", icon);
        return option;
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addXolloRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("home");
        modelview.getModelMap().addAttribute("banner", "Busca un xollo!");
        modelview.getModelMap().addAttribute("tagline", "Afegir un article al catàleg");
        List<Map<String, Object>> options = new ArrayList<Map<String, Object>>();
        options.add(createOption("Vols", "Permet afegir un vol al catàleg de la botiga", "/add/Vol", "glyphicon-plane glyphicon"));
        options.add(createOption("Hotel", "Permet afegir un hotel al catàleg de la botiga", "/add/Hotel", "glyphicon-bed glyphicon"));
        options.add(createOption("Lloguer", "Permet afegir un model de cotxe de lloguer al catàleg de la botiga", "/add/Lloguer", "glyphicon-road glyphicon"));
        
        modelview.getModelMap().addAttribute("options", options);
        return modelview;
    }
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView getXolloFormRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            ModelAndView modelview = new ModelAndView("getXolloForm");
            modelview.getModelMap().addAttribute("banner", "Busca un xollo!");
            
            return modelview;

    }
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ModelAndView getXolloByCodiRequest(@RequestParam String codi,HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException{
        Xollo xollo = xolloRepository.getXolloByCodi(codi);
        
        ModelAndView modelview = new ModelAndView("infoXollo");
        modelview.getModelMap().addAttribute("banner", "Busca un xollo!");
        modelview.getModelMap().addAttribute("tagline", "Dades d'un Xollo.");
        modelview.getModelMap().addAttribute("xollo", xollo);
        
        return modelview;
    }
    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public ModelAndView getXolloFilter(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException{
               
        ModelAndView modelview = new ModelAndView("helpFilter");
        modelview.getModelMap().addAttribute("banner", "Busca un xollo!");
        modelview.getModelMap().addAttribute("tagline", "Ajuda per la creació d'un filtre.");
               
        return modelview;
    }
    @RequestMapping(value = "/filter/{ByCriteria}",method = RequestMethod.GET)
    public ModelAndView getXolloByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("listXolloByFilter");
        modelview.getModelMap().addAttribute("banner", "Busca un xollo!");
        modelview.getModelMap().addAttribute("tagline", "Llistat d'articles que compleixen els requisits.");
        modelview.getModelMap().addAttribute("xollo",xolloRepository.getXolloByFilter(filterParams));
        return modelview;
    }
    
    @RequestMapping(value = "/venda", method = RequestMethod.GET)
    public ModelAndView getVenda(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException{
               
        ModelAndView modelview = new ModelAndView("helpVendes");
        modelview.getModelMap().addAttribute("banner", "Busca un xollo!");
        modelview.getModelMap().addAttribute("tagline", "Ajuda per la venda d'un article.");
               
        return modelview;
    }
    
     @RequestMapping(value = "/getXollo/{codi}",method = RequestMethod.GET)
    public ModelAndView getXolloByCodiVendaRequest(@PathVariable("codi") String codiXollo, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Xollo xollo = xolloRepository.getXolloByCodi(codiXollo);
        ModelAndView modelview = new ModelAndView("infoXollo");
        modelview.getModelMap().addAttribute("banner", "Busca un xollo!");
        modelview.getModelMap().addAttribute("tagline", "Dades d'un article");
        modelview.getModelMap().addAttribute("xollo",xollo);
        return modelview;
    }
    
    @RequestMapping(value = "/add/{tipus}",method = RequestMethod.GET)
    public ModelAndView addXolloForm(@PathVariable("tipus") String tipusXollo, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ModelAndView modelview = new ModelAndView("add"+tipusXollo);
        modelview.getModelMap().addAttribute("banner", "Busca un xollo!");
        modelview.getModelMap().addAttribute("tagline", "Afegir un article de tipus " + tipusXollo + " al catàleg");
        modelview.getModelMap().addAttribute("newXollo", Class.forName("cat.xtec.ioc.domain." + tipusXollo).newInstance());

        return modelview;
    }
    @RequestMapping(value = "/add/{tipus}", method = RequestMethod.POST)
    public String addXolloForm(@PathVariable("tipus") String tipusXollo, @ModelAttribute("newXollo") Xollo newXolloToAdd, BindingResult result) {
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Intentat accedir amb camps no permesos: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
            
            xolloRepository.addXollo(newXolloToAdd);
            return "redirect:/";
       
    }
    
}

