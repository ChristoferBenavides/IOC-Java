/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

import org.springframework.stereotype.Controller;



@Controller
public class VendesController {
    
    @Autowired
    private VendaService vendaService;
    
    @RequestMapping(value = "/vendaXollo/{codi}",method = RequestMethod.GET)
    public String vendre(@PathVariable("codi") String codiXollo, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
       
            vendaService.processVenda(codiXollo);
            return "redirect:/getXollo/"+codiXollo;
        
    }
    
    
}
