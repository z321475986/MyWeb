package com.tainan.myweb;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="suggestion")
public class Suggestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String sugges;
	@Column
	private String time;
//	private Date time;
	
	public String getSugges() {
		return sugges;
	}
	public void setSugges(String sugges) {
		this.sugges = sugges;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	
	
	
	@Override
	public String toString() {
		return "Suggestion [sugges=" + sugges + ", time=" + time + "]";

	}

}