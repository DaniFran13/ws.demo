package com.fertisa.ec.ws.demo.model;
import java.sql.Date;

import javax.persistence.*;
@Entity
@Table(name = "tb_NavisVisitDetails")
public class NavisVisitDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "driverName")
	private String driverName;
	@Column(name = "idDriver")
	private String idDriver;
	@Column(name = "gateIn")
	private Date gateIn;
	@Column(name = "gateOut")
	private Date gateOut;
	@Column(name = "cargoType")
	private String cargoType;
	@Column(name = "weight")
	private float weight;
	@Column(name = "idTruck")
	private String idTruck;
	public NavisVisitDetails() {
	}
	public NavisVisitDetails(String driverName, String idDriver, Date gateIn, Date gateOut, String cargoType, float weight, String idTruck) {
		this.driverName = driverName;
		this.idDriver = idDriver;
		this.gateIn = gateIn;
		this.gateOut = gateOut;
		this.cargoType = cargoType;
		this.weight = weight;
		this.idTruck=idTruck;
	}
	

	
	
	public String getIdTruck() {
		return idTruck;
	}
	public void setIdTruck(String idTruck) {
		this.idTruck = idTruck;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getIdDriver() {
		return idDriver;
	}
	public void setIdDriver(String idDriver) {
		this.idDriver = idDriver;
	}
	public Date getGateIn() {
		return gateIn;
	}
	public void setGateIn(Date gateIn) {
		this.gateIn = gateIn;
	}
	public Date getGateOut() {
		return gateOut;
	}
	public void setGateOut(Date gateOut) {
		this.gateOut = gateOut;
	}
	public String getCargoType() {
		return cargoType;
	}
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "NavisVisitDetails [id=" + id + ", driverName=" + driverName + ", idDriver=" + idDriver + ", gateIn=" + gateOut + ", gateIn=" + gateOut + ", cargoType=" + cargoType + ", published=" + weight + "]";
	}
}
