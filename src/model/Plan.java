package com.istihad.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "MyPlans")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Plan {
	@Id
	@GeneratedValue
	@Column(name="place_Id")
	private Integer placeId;
	@NotNull
	@Column(name="Place")
	private String place;
	@NotNull
	@Column(name="Address")
	private String address;
	@NotNull
	@Column(name="Hotel")
	private String hotel;
	@NotNull
	@Column(name="Dateoftravel")
	private Date dateTravel;
	@NotNull
	@Column(name="DateAdded")
	private Date dateAdded;

	@Column(name="Climate")
	private String climate;
	
	@Column(name="PlaceUrl")
	private String placeUrl;
	
	@Column(name="HotelUrl")
	private String hotelUrl;
	
	@ManyToOne
	@JoinColumn(name="userId", insertable=false, updatable=false)
	  private User user;
	
	private Integer userId;
	
	@Transient
	private String emailId;
	
	@Transient
	private List<Integer> idList;
	
	public Plan(){
	}

	/**
	 * @return the placeId
	 */
	public Integer getPlaceId() {
		return placeId;
	}

	/**
	 * @param placeId the placeId to set
	 */
	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the hotel
	 */
	public String getHotel() {
		return hotel;
	}