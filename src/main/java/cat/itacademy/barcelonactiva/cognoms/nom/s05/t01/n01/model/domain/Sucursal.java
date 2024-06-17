package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Sucursal {
    @Id
    private int pk_SucursalID;
    private String nameSucursal;
    private String countrySucursal;

    public int getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(int pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
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
