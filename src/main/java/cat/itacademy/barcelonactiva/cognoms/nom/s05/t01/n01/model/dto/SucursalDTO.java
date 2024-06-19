package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto;

import java.util.Arrays;
import java.util.List;

public class SucursalDTO {
    private Integer pkSucursalID;
    private String nameSucursal;
    private String countrySucursal;
    private String typeSucursal;

    private static final List<String> UE_COUNTRIES = Arrays.asList(
            "Romania", "Sweden", "Germany", "Austria", "Belgium",
            "Cyprus", "Slovakia", "Slovenia", "Spain", "Estonia",
            "Finland", "France", "Greece", "Netherlands", "Hungary",
            "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg",
            "Malta", "Poland", "Portugal", "Czech Republic");

    public SucursalDTO() {
        this.typeSucursal = calcTypeSucursal();
    }

    public SucursalDTO(Integer pkSucursalID, String nameSucursal, String countrySucursal) {
        this.pkSucursalID = pkSucursalID;
        this.nameSucursal = nameSucursal;
        this.countrySucursal = countrySucursal;
        this.typeSucursal = calcTypeSucursal();
    }

    private String calcTypeSucursal() {
        if (UE_COUNTRIES.contains(countrySucursal)) {
            return "UE";
        } else {
            return "NOT UE";
        }
    }

    public Integer getPkSucursalID() {
        return pkSucursalID;
    }

    public void setPkSucursalID(Integer pkSucursalID) {
        this.pkSucursalID = pkSucursalID;
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

    public String getTypeSucursal() {
        return typeSucursal;
    }

    public void setTypeSucursal(String typeSucursal) {
        this.typeSucursal = typeSucursal;
    }
}
