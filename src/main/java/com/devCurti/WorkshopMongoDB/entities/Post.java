package com.devCurti.WorkshopMongoDB.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.devCurti.WorkshopMongoDB.DTO.AuthorDTO;

@Document(collection = "post")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date data;
	private String title;
	private String body;

	private AuthorDTO authorDTO;
	
	public Post() {}

	public Post(String id, Date data, String title, String body, AuthorDTO author) {
		this.id = id;
		this.data = data;
		this.title = title;
		this.body = body;
		this.authorDTO = author;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDTO getAuthorDTO() {
		return authorDTO;
	}

	public void setAuthorDTO(AuthorDTO author) {
		this.authorDTO = author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

}
