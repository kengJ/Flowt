package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OrderBy;

import lombok.Data;

@Entity
@Table
@Data
public class VueTable {

	@Id
	@GeneratedValue
	private Long Id;
	
	@Column(name="Title")
	private String Title;
	
	@Column(name="Icon")
	private String Icon;

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="VueTable_id")
	@OrderBy(clause="OrderNo,Id")
	private List<VueMenuItem> VueMenuItems;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTtile() {
		return Title;
	}

	public void setTtile(String title) {
		Title = title;
	}

	public String getIcon() {
		return Icon;
	}

	public void setIcon(String icon) {
		Icon = icon;
	}

	public List<VueMenuItem> getVueMenuItems() {
		return VueMenuItems;
	}

	public void setVueMenuItems(List<VueMenuItem> vueMenuItems) {
		VueMenuItems = vueMenuItems;
	}

	@Override
	public String toString() {
		return "VueTable [Id=" + Id + ", Ttile=" + Title + ", Icon=" + Icon + ", VueMenuItems=" + VueMenuItems + "]";
	}

	public VueTable(Long id, String title, String icon, List<VueMenuItem> vueMenuItems) {
		super();
		Id = id;
		Title = title;
		Icon = icon;
		VueMenuItems = vueMenuItems;
	}

	public VueTable() {
		super();
		// TODO Auto-generated constructor stub
	} 

}
