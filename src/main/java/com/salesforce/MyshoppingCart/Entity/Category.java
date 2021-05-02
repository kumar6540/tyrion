package com.salesforce.MyshoppingCart.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45,unique = true,nullable = false)
	private String name;
	
	//@ManyToOne
	//@JoinColumn(name="brand_id")

	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Category_Brand", 
        joinColumns = { @JoinColumn(name = "category_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "brand_id") }
    )
	private List<Brand> brand; 
	
	
	public Category(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return  name ;
	}
	
	
	
	
	
}
