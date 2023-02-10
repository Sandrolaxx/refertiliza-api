package org.aktie.entities.enums;

/**
 *
 * @author SRamos
 */
public enum EnumWasteType {
    
    PORCO("PORCO"),
    BOVINO("BOVINO"),
    AVICOLA("AVICOLA");  
    
    private final String value;

    private EnumWasteType(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }
    public String getValue() {
        return value;
    }

}