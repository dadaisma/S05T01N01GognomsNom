package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ISucursal {

    void createSucursal(SucursalDTO sucursalDTO);

    @Transactional
    void updateSucursal(SucursalDTO sucursalDTO);

    boolean deleteSucursal(Integer id);

    SucursalDTO getSucursalById(Integer id);

    List<SucursalDTO> getAllSucursals();


}

