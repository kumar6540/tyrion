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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="brand")
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 45,unique = true,nullable = false)
	private String name;
	
	//@OneToMany
	//@JoinColumn(name="brand_id")
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Category_Brand", 
        joinColumns = { @JoinColumn(name = "brand_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "category_id") }
    )
	private List<Category> categories;
}
