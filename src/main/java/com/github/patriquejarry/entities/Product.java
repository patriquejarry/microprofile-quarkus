package com.github.patriquejarry.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "PRODUCT")
public class Product extends PanacheEntity {

	public String name;

	public BigDecimal value;

	@CreationTimestamp
	public Date creationDate;

	@UpdateTimestamp
	public Date modificationDate;

}
