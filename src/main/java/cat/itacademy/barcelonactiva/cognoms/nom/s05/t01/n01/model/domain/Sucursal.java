package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkSucursalId;
    private String nameSucursal;
    private String countrySucursal;

    // Default constructor
    public Sucursal(){}
    public Sucursal(Integer pkSucursalID, String nameSucursal, String countrySucursal) {
    }

    // Parameterized constructor
    public Sucursal(String nameSucursal, String countrySucursal) {
        this.nameSucursal = nameSucursal;
        this.countrySucursal = countrySucursal;
    }

    public Integer getPkSucursalId() {
        return pkSucursalId;
    }

    public void setPkSucursalId(Integer pkSucursalId) {
        this.pkSucursalId = pkSucursalId;
    }

    public String getNameSucursal() {
        return nameSucursal;
    }

    public void setNameSucursal(String nameSucursal) {
        this.nameSucursal = nameSucursal;
    }

    public String getCountrySucursal() {
        return countrySucursal;
    }

    public void setCountrySucursal(String countrySucursal) {
        this.countrySucursal = countrySucursal;
    }
}