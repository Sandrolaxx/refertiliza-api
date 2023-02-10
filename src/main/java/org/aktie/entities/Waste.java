package org.aktie.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.aktie.entities.enums.EnumWasteType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 *
 * @author SRamos
 */
@Entity
@Table(name = "RF_WASTE")
public class Waste extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "ID_RF_WASTE", sequenceName = "GEN_RF_WASTE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_RF_WASTE")
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private Integer id;

    @Column(name = "SIZE_LIMIT")
    private Integer sizeLimit;

    @Column(name = "QUANTITY")
    private Integer wasteQuantity;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "WASTE_TYPE")
    @Enumerated(EnumType.STRING)
    private EnumWasteType wasteType;
    
    @Column(name = "PAY_TO")
    private boolean payTo;

    @CreationTimestamp
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_RECEIVER", referencedColumnName = "ID")
    private Receiver receiver;

    public static Waste findById(Integer id) {
        return find("id", id).firstResult();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSizeLimit() {
        return sizeLimit;
    }

    public void setSizeLimit(Integer limit) {
        this.sizeLimit = limit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isPayTo() {
        return payTo;
    }

    public void setPayTo(boolean payTo) {
        this.payTo = payTo;
    }

    public EnumWasteType getWasteType() {
        return wasteType;
    }

    public void setWasteType(EnumWasteType wasteType) {
        this.wasteType = wasteType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Integer getWasteQuantity() {
        return wasteQuantity;
    }

    public void setWasteQuantity(Integer wasteQuantity) {
        this.wasteQuantity = wasteQuantity;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

}