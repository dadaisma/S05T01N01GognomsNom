package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/add")
    public ResponseEntity<SucursalDTO> createSucursal(@RequestBody SucursalDTO sucursalDTO) {
        SucursalDTO sucursalCreated = sucursalService.createSucursal(sucursalDTO);
        return new ResponseEntity<>(sucursalCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SucursalDTO> updateSucursal(@PathVariable Integer id, @RequestBody SucursalDTO sucursalDTO) {
        SucursalDTO sucursalUpdated = sucursalService.updateSucursal(id, sucursalDTO);
        if (sucursalUpdated != null) {
            return new ResponseEntity<>(sucursalUpdated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSucursal(@PathVariable Integer id) {
        boolean isDeleted = sucursalService.deleteSucursal(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<SucursalDTO> getSucursalById(@PathVariable Integer id) {
        SucursalDTO sucursalRequestedById = sucursalService.getSucursalById(id);
        if (sucursalRequestedById != null) {
            return new ResponseEntity<>(sucursalRequestedById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SucursalDTO>> getAllSucursals() {
        List<SucursalDTO> sucursals = sucursalService.getAllSucursals();
        return new ResponseEntity<>(sucursals, HttpStatus.OK);
    }
}
