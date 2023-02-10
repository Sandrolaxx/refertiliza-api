package org.aktie.entities.enums;

/**
 *
 * @author SRamos
 */
public enum EnumReceiverType {
    
    PONTO_COLETA("PONTO_COLETA"),
    GERADOR("GERADOR");  
    
    private final String value;

    private EnumReceiverType(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }
    public String getValue() {
        return value;
    }

}