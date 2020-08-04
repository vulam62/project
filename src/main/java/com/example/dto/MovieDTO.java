package com.example.dto;



public class MovieDTO extends AbstractDTO<MovieDTO> {
	private String content;
	private String shortDesciption;
	private String title;

	private String categoryCode;
	
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	private String thumbnail;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getShortDesciption() {
		return shortDesciption;
	}
	public void setShortDesciption(String shortDesciption) {
		this.shortDesciption = shortDesciption;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
}
