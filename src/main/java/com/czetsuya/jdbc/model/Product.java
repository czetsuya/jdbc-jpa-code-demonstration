/**
 * Copyright 2020 - present, Edward P. Legaspi | czetsuya@gmail.com.
 * All rights reserved.
 * 
 * This source code is license under the license found in the 
 * License.md file in the root directory of this source tree.
 */
package com.czetsuya.jdbc.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 25)
    private String code;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "created_at", columnDefinition = "DATE")
    private LocalDate createdAt;

    @Column(name = "disabled")
    private boolean disabled;

    @Override
    public String toString() {
        return "Product [id=" + id + ", code=" + code + ", description=" + description + ", createdAt=" + createdAt + ", disabled=" + disabled + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
