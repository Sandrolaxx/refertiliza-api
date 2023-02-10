package org.aktie.dto;

import java.util.List;

import org.aktie.entities.enums.EnumReceiverType;

public class ReceiverDTO {
    
    private Integer id;

    private String nome;

    private String latitude;

    private String longitude;

    private EnumReceiverType receiverType;

    private List<WasteDTO> wasteList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public EnumReceiverType getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(EnumReceiverType receiverType) {
        this.receiverType = receiverType;
    }

    public List<WasteDTO> getWasteList() {
        return wasteList;
    }

    public void setWasteList(List<WasteDTO> wasteList) {
        this.wasteList = wasteList;
    }

}
