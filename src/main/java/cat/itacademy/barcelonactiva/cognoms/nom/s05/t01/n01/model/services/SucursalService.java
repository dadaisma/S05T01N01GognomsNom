package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.repository.SucursalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public SucursalDTO crearSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNameSucursal(sucursalDTO.getNameSucursal());
        sucursal.setCountrySucursal(sucursalDTO.getCountrySucursal());

        sucursalRepository.save(sucursal);

        return  sucursalDTO;
    }

    @Transactional
    public Sucursal updateSucursal(Integer id, SucursalDTO sucursalDTO) {
        Optional<Sucursal> existingSucursal = sucursalRepository.findById(id);
        if (existingSucursal.isPresent()) {
            Sucursal sucursalToUpdate = existingSucursal.get();
            sucursalToUpdate.setNameSucursal(sucursalDTO.getNameSucursal());
            sucursalToUpdate.setCountrySucursal(sucursalDTO.getCountrySucursal());
            return sucursalRepository.save(sucursalToUpdate);
        } else {
            return null;
        }
    }
    @Transactional
    public boolean deleteSucursal(Integer id) {
        Optional<Sucursal> existingSucursal = sucursalRepository.findById(id);
        if(existingSucursal.isPresent()){
            sucursalRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    @Transactional
    public SucursalDTO getSucursalById(Integer id) {
        public Optional<Sucursal> getSucursalById(int id){
            return sucursalRepository.findById(id);
    }
    @Transactional(readOnly = true)
    public List<Sucursal> getAllSucursals() {
        public Iterable<Sucursal> getAllSucursals(){
            return sucursalRepository.findAll();
    }

}

    public SucursalDTO createSucursal(SucursalDTO sucursalDTO) {

    }
    }
    @Transactional(readOnly = true)
    public Iterable<Sucursal> getAllSucursals() {
        public Iterable<Sucursal> getAllSucursals(){
            return sucursalRepository.findAll();
    }

    }