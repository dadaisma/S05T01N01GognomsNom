package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.repository.ISucursalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain.Sucursal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SucursalServiceImpl implements ISucursal {
    private ISucursalRepository iSucursalRepository;
    @Autowired
    public SucursalServiceImpl(ISucursalRepository iSucursalRepository){
        this.iSucursalRepository = iSucursalRepository;
    }
    private Sucursal toEntity(SucursalDTO sucursalDTO){
        if(sucursalDTO.getPkSucursalID()==null){
            return new Sucursal(sucursalDTO.getNameSucursal(), sucursalDTO.getCountrySucursal());
        }
        return new Sucursal(sucursalDTO.getPkSucursalID(), sucursalDTO.getNameSucursal(), sucursalDTO.getCountrySucursal());

    }
    private SucursalDTO toDTO(Sucursal sucursal){
        return  new SucursalDTO(sucursal.getPkSucursalId(), sucursal.getNameSucursal(), sucursal.getCountrySucursal());
    }



    @Override
    public void createSucursal(SucursalDTO sucursalDTO) {
        
        iSucursalRepository.save(toEntity(sucursalDTO));
    }

    @Override
    @Transactional
    public void updateSucursal(SucursalDTO sucursalDTO) {
        if(!iSucursalRepository.findById(sucursalDTO.getPkSucursalID()).isPresent()){
            throw new EntityNotFoundException("Update Sucursal Failed: Invalid ID: "+ sucursalDTO.getPkSucursalID()+
                    " -> DOESN'T EXIST in DataBase");
        }

        iSucursalRepository.save(toEntity(sucursalDTO));
    }
    @Override
    @Transactional
    public boolean deleteSucursal(Integer sucursalId) {
        if(!iSucursalRepository.findById(sucursalId).isPresent()){
            throw new EntityNotFoundException("Update Sucursal Failed: Invalid ID: "+ sucursalId+
                    " -> DOESN'T EXIST in DataBase");
        }

        iSucursalRepository.deleteById(sucursalId);
    return true;}
    @Override
    @Transactional(readOnly = true)
    public SucursalDTO getSucursalById(Integer sucursalId) {
        Sucursal sucursal = iSucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new NoResultException("Get One Sucursal Failed: Invalid ID: "+ sucursalId
                        +" -> DOESN'T EXIST in DataBase"));

        return toDTO(sucursal);
    }


    @Override
    @Transactional(readOnly = true)
    public List<SucursalDTO> getAllSucursals() {
        List<Sucursal> sucursalList = iSucursalRepository.findAll();

        return sucursalList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
 /*
    @Override
    @Transactional(readOnly = true)
    public List<SucursalDTO> getAllSucursals() {
        Iterable<cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain.Sucursal> sucursals = iSucursalRepository.findAll();
        return StreamSupport.stream(sucursals.spliterator(), false)
                .map(s -> new SucursalDTO(s.getPkSucursalId(), s.getNameSucursal(), s.getCountrySucursal()))
                .collect(Collectors.toList());
    }
*/
}