/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.service.VendaService;
import org.springframework.stereotype.Service;
import cat.xtec.ioc.repository.XolloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import cat.xtec.ioc.domain.Xollo;


@Service
public class VendaServiceImpl implements VendaService {
    @Autowired
    private XolloRepository xolloRepository;

    public void processVenda(String codiXollo) throws Exception {
        Xollo xollo = xolloRepository.getXolloByCodi(codiXollo);
        if (xollo.getNumeroUnitats() > 0) {
            xollo.setNumeroReserves(xollo.getNumeroReserves() + 1);
        } else {
            throw new Exception("No hi ha unitats disponibles per aquest xollo");
        }
    }
}

