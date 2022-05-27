package com.example.mkd.data.model;

import org.json.JSONObject;

public class CommunicationDTO {

    private Long id;
    private String data;
    public CommincationDTODataField fields;

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CommunicationDTO{" +
				"id=" + id +
				", data='" + data + '\'' +
				'}';
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		if (data != null) {

		}
		this.data = data;
	}
}
