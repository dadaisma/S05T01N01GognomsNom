package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;

import java.util.List;

public interface Isucursal {

    SucursalDTO createSucursal(SucursalDTO sucursalDTO);

    SucursalDTO updateSucursal(Integer id, SucursalDTO sucursalDTO);

    boolean deleteSucursal(Integer id);

    SucursalDTO getSucursalById(Integer id);

    List<SucursalDTO> getAllSucursals();
}

