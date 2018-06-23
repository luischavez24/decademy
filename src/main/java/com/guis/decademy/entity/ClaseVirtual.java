package com.guis.decademy.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="clasesVirtuales")
public class ClaseVirtual {
	
	@Id
	private String id;
	
	private byte[] video;

	public byte[] getVideo() {
		return video;
	}

	public void setVideo(byte[] video) {
		this.video = video;
	}

}
