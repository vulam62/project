package com.example.entities;

import java.util.ArrayList;
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

@Entity
@Table(name="movie")
public class Movie {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@Column(name="content")
	private String content;
	@Column(name="shortDescription")
	private String shortDescription;
	@Column(name="title")
	private String title;
	@Column(name="thumbnail")
	private String thumbnail;
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(
	      name="movie_category",
	      joinColumns={@JoinColumn(name="MOVIE_ID", referencedColumnName="ID")},
	      inverseJoinColumns={@JoinColumn(name="CATEGORY_ID", referencedColumnName="ID")})
	private List<Category> categories;
	
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<schedule> schedules = new ArrayList<schedule>();
	
	public List<schedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<schedule> schedules) {
		this.schedules = schedules;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
}
