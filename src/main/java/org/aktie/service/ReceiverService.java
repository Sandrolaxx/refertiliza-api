package org.aktie.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.aktie.dto.ReceiverDTO;
import org.aktie.dto.WasteDTO;
import org.aktie.entities.Receiver;
import org.aktie.entities.Waste;
import org.aktie.entities.enums.EnumReceiverType;

@ApplicationScoped
public class ReceiverService {

    @Transactional()
    public void createReceiver(ReceiverDTO receiverDTO) {
        var receiver = toReceiverEntity(receiverDTO);

        receiver.persist();
    }

    public List<ReceiverDTO> listAll() {
        return Receiver.findAll()
                .list()
                .stream()
                .map(val -> receiverEntityToDTO((Receiver) val))
                .collect(Collectors.toList());
    }

    private Receiver toReceiverEntity(ReceiverDTO dto) {
        var entity = new Receiver();

        entity.setNome(dto.getNome());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setReceiverType(dto.getReceiverType());

        entity.setWasteList(dto.getWasteList().stream()
                .map(value -> toWasteEntity(value, entity))
                .collect(Collectors.toList()));

        return entity;
    }

    private Waste toWasteEntity(WasteDTO dto, Receiver receiver) {
        var entity = new Waste();

        entity.setSizeLimit(dto.getSizeLimit());
        entity.setWasteType(dto.getWasteType());
        entity.setAmount(dto.getAmount());
        entity.setPayTo(dto.isPayTo());
        entity.setWasteQuantity(dto.getWasteQuantity());

        entity.setReceiver(receiver);

        return entity;
    }

    private ReceiverDTO receiverEntityToDTO(Receiver entity) {
        var dto = new ReceiverDTO();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setReceiverType(entity.getReceiverType());

        dto.setWasteList(entity.getWasteList().stream()
                .map(this::wasteEntityToDTO)
                .collect(Collectors.toList()));

        return dto;
    }

    private WasteDTO wasteEntityToDTO(Waste entity) {
        var dto = new WasteDTO();

        dto.setId(entity.getId());
        dto.setSizeLimit(entity.getSizeLimit());
        dto.setWasteType(entity.getWasteType());
        dto.setAmount(entity.getAmount());
        dto.setPayTo(entity.isPayTo());
        dto.setWasteQuantity(entity.getWasteQuantity());

        if (entity.getReceiver().getReceiverType().equals(EnumReceiverType.GERADOR)) {
            switch (entity.getWasteType()) {
                case AVICOLA:
                    var finalValueAv = BigDecimal.valueOf((entity.getWasteQuantity() * 3));
                    finalValueAv = finalValueAv.divide(BigDecimal.valueOf(10000));

                    dto.setTonMonth(finalValueAv);
                    break;
                case BOVINO:
                    var finalValueCow = BigDecimal.valueOf(entity.getWasteQuantity() * 54);
                    finalValueCow = finalValueCow.divide(BigDecimal.valueOf(1000));

                    dto.setTonMonth(finalValueCow);
                    break;
                default:
                    var finalValue = BigDecimal.valueOf(entity.getWasteQuantity() * 147);
                    finalValue = finalValue.divide(BigDecimal.valueOf(1000));

                    dto.setTonMonth(finalValue);
                    break;
            }
        }

        return dto;
    }

}
