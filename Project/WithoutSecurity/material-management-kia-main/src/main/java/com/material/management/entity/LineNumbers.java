package com.material.management.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="lineNumbers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineNumbers {
	@Id
	private int id;
	private String lineNumber;
}
