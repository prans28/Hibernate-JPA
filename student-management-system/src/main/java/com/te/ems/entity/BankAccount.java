package com.te.ems.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "Bank_Account_tbl")
public class BankAccount {

	@Column(name = "bank_account_number")
	@Id
	private Integer bankAccountNumber;
	@Column(name = "bank_ifsc")
	private String bankIfsc;
	
	//Bidirectional
	@OneToOne(mappedBy="bankAccount",cascade = CascadeType.ALL)
	private Employee employee;

}
