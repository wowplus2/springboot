package com.springboot.myjurnal.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Journal 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private Date created;
	private String summary;
	
	/* Transient 어노테이션을 선언하면 JPA 엔진은 해당 field를 저장하지 않고 넘어간다. */
	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
	
	public Journal(String title, String summary, String date) throws ParseException {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.summary = summary;
		this.created = format.parse(date);
	}
	
	public Journal() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getCreateAsShort() {
		return format.format(created);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder val = new StringBuilder("JournalEntry(");
		val.append("Id: ").append(id);
		val.append(", 제목: ").append(title);
		val.append(", 요약: ").append(summary);
		val.append(", 일자: ").append(getCreateAsShort());
		val.append(")");
		
		return val.toString();
	}
	
}
