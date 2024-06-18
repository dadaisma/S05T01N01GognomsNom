package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public ResponseEntity<Void> deleteSucursal(@PathVariable Integer id) {
        sucursalService.deleteSucursal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
     try {
        Iterable<Sucursal> sucursalIterable = sucursalService.getAllSucursals();
        List<Sucursal> sucursals = StreamSupport.stream(sucursalIterable.spliterator(), false)
                .collect(Collectors.toList());
        return new ResponseEntity<>(sucursals, HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}