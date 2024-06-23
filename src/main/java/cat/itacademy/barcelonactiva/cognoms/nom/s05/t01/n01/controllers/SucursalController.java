package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services.SucursalServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/")
public class SucursalController {

    @Autowired
    private SucursalServiceImpl sucursalServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<SucursalDTO> createSucursal(@RequestBody SucursalDTO sucursalDTO) {
        SucursalDTO sucursalCreated = sucursalServiceImpl.createSucursal(sucursalDTO);
        return new ResponseEntity<>(sucursalCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SucursalDTO> updateSucursal(@PathVariable Integer id, @RequestBody SucursalDTO sucursalDTO) {
        SucursalDTO sucursalUpdated = sucursalServiceImpl.updateSucursal(id, sucursalDTO);
        if (sucursalUpdated != null) {
            return new ResponseEntity<>(sucursalUpdated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSucursal(@PathVariable Integer id) {
        boolean isDeleted = sucursalServiceImpl.deleteSucursal(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<SucursalDTO> getSucursalById(@PathVariable Integer id) {
        SucursalDTO sucursalRequestedById = sucursalServiceImpl.getSucursalById(id);
        if (sucursalRequestedById != null) {
            return new ResponseEntity<>(sucursalRequestedById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SucursalDTO>> getAllSucursals() {
        List<SucursalDTO> sucursals = sucursalServiceImpl.getAllSucursals();
        return new ResponseEntity<>(sucursals, HttpStatus.OK);
    }
    @GetMapping("/")
    public  String homePage(Model model) {
        model.addAttribute("sucursals", sucursalServiceImpl.getAllSucursals());
        return "Home";
    }



        @GetMapping("/form")
        public String showAddForm(Model model) {
            model.addAttribute("sucursal", new SucursalDTO());
            return "add";
        }

        @PostMapping("/addNew")
        public String createSucursalAdd(@ModelAttribute("sucursal") SucursalDTO sucursalDTO) {
            sucursalServiceImpl.createSucursal(sucursalDTO);
            return "redirect:/";
        }
    }









