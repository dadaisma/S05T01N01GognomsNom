package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services.SucursalServiceImpl;


import jakarta.persistence.EntityNotFoundException;
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


    // get all in web


    @GetMapping("/")
    public  String homePage(Model model) {
        model.addAttribute("sucursals", sucursalServiceImpl.getAllSucursals());
        return "/home";
    }


    // add new in web

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

        //

    // edit one in web

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable(value="id") Integer id, Model model) {
        model.addAttribute("sucursal", sucursalServiceImpl.getSucursalById(id));
        return "edit";
    }

    @PostMapping("/editone/{id}")

        public String updateSucursalEdit(@ModelAttribute("sucursalToUpdate") SucursalDTO sucursalDTO, Model model){
        try {
            sucursalServiceImpl.updateSucursal(sucursalDTO);
            return "redirect:/"; // Redirect on success
        } catch (EntityNotFoundException e) {

            model.addAttribute("errorMessage", e.getMessage());
            return "edit";
        }
    }

//




    // delete one in web

    @PostMapping("/delete/{id}")
    public String deleteSucursalForm(@PathVariable(value="id") Integer id){
        sucursalServiceImpl.deleteSucursal(id);
        return "redirect:/";
    }


    }















