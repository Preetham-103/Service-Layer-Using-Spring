package com.cts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="bks31")
public class Books {
	
	@Id
	private int bookid;
	private String title;
	private String description;
	private String publisher;
	private int price;
	
}
