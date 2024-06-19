package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.repository.SucursalRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SucursalService implements Isucursal {

    @Autowired
    private SucursalRepository sucursalRepository;
@Override
    public SucursalDTO createSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNameSucursal(sucursalDTO.getNameSucursal());
        sucursal.setCountrySucursal(sucursalDTO.getCountrySucursal());

        Sucursal savedSucursal = sucursalRepository.save(sucursal);
        return new SucursalDTO(savedSucursal.getPkSucursalId(), savedSucursal.getNameSucursal(), savedSucursal.getCountrySucursal());
    }
    @Override
    @Transactional
    public SucursalDTO updateSucursal(Integer id, SucursalDTO sucursalDTO) {
        Optional<Sucursal> existingSucursal = sucursalRepository.findById(id);
        if (existingSucursal.isPresent()) {
            Sucursal sucursalToUpdate = existingSucursal.get();
            sucursalToUpdate.setNameSucursal(sucursalDTO.getNameSucursal());
            sucursalToUpdate.setCountrySucursal(sucursalDTO.getCountrySucursal());
            Sucursal updatedSucursal = sucursalRepository.save(sucursalToUpdate);
            return new SucursalDTO(updatedSucursal.getPkSucursalId(), updatedSucursal.getNameSucursal(), updatedSucursal.getCountrySucursal());
        } else {
            return null;
        }
    }
    @Override
    @Transactional
    public boolean deleteSucursal(Integer id) {
        Optional<Sucursal> existingSucursal = sucursalRepository.findById(id);
        if (existingSucursal.isPresent()) {
            sucursalRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    @Override
    @Transactional(readOnly = true)
    public SucursalDTO getSucursalById(Integer id) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        return sucursal.map(s -> new SucursalDTO(s.getPkSucursalId(), s.getNameSucursal(), s.getCountrySucursal())).orElse(null);
    }
    @Override
    @Transactional(readOnly = true)
    public List<SucursalDTO> getAllSucursals() {
        Iterable<Sucursal> sucursals = sucursalRepository.findAll();
        return StreamSupport.stream(sucursals.spliterator(), false)
                .map(s -> new SucursalDTO(s.getPkSucursalId(), s.getNameSucursal(), s.getCountrySucursal()))
                .collect(Collectors.toList());
    }}