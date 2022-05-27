package com.example.mkd.data.model;

public class RepairDataDTO {

	private Long id;
    private int substructure;
    private int facade;
    private int roof;
    private int elevator;
    private int energy;
    private int heating;
    private int watter;
    private int hotWatter;
    private int watterOut;
    private int other;
	private ObjectMkd object;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSubstructure() {
		return substructure;
	}

	public void setSubstructure(int substructure) {
		this.substructure = substructure;
	}

	public int getFacade() {
		return facade;
	}

	public void setFacade(int facade) {
		this.facade = facade;
	}

	public int getRoof() {
		return roof;
	}

	public void setRoof(int roof) {
		this.roof = roof;
	}

	public int getElevator() {
		return elevator;
	}

	public void setElevator(int elevator) {
		this.elevator = elevator;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getHeating() {
		return heating;
	}

	public void setHeating(int heating) {
		this.heating = heating;
	}

	public int getWatter() {
		return watter;
	}

	public void setWatter(int watter) {
		this.watter = watter;
	}

	public int getHotWatter() {
		return hotWatter;
	}

	public void setHotWatter(int hotWatter) {
		this.hotWatter = hotWatter;
	}

	public int getWatterOut() {
		return watterOut;
	}

	public void setWatterOut(int watterOut) {
		this.watterOut = watterOut;
	}

	public int getOther() {
		return other;
	}

	public void setOther(int other) {
		this.other = other;
	}

	public ObjectMkd getObject() {
		return object;
	}

	public void setObject(ObjectMkd object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "RepairDataDTO{" +
				"id=" + id +
				", substructure=" + substructure +
				", facade=" + facade +
				", roof=" + roof +
				", elevator=" + elevator +
				", energy=" + energy +
				", heating=" + heating +
				", watter=" + watter +
				", hotWatter=" + hotWatter +
				", watterOut=" + watterOut +
				", other=" + other +
				", object=" + object +
				'}';
	}
}
