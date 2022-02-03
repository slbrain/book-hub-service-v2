package bookshub.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookShopDto {
	
	private Integer id;
	private String location;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="HH:mm, dd MMM yyyy")
	private Date showopenDate;
	
	public BookShopDto(Integer id, String location) {
		super();
		this.id = id;
		this.location = location;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getShowopenDate() {
		return showopenDate;
	}
	public void setShowopenDate(Date showopenDate) {
		this.showopenDate = showopenDate;
	}
	
	

}
