package com.te.ems.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "address_tbl")
public class Address {

	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int addressId;
	@Column(name = "address_city")
	private String addressCity;
	@Column(name = "address_state")
	private String addressState;

	@JoinColumn(name = "emp_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;

}
