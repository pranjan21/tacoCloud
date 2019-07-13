package tacos.domains;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
@Entity
@Table(name="Taco_Order")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date placedAt;
	
	@ManyToMany(targetEntity=Taco.class)
	private List<Taco> tacos = new ArrayList<>();
	
	@Size(min = 5, message = "Name should be atleast 5 characters long")
	private String name;
	
	@Size(min = 2, message = "Streeet should be atleast 5 characters long")
	private String street;

	@Size(min = 2, message = "city should be atleast 5 characters long")
	private String city;
	
	@Size(min = 2, message = "state should be atleast 5 characters long")
	private String state;
	
	@Size(min = 2, message = "zip should be atleast 5 characters long")
	private String zip;
	
	private String ccNumber;
	
	private String ccExpiration;
	
	@Digits(integer = 3, fraction = 0, message = "cVV number should be only digits")
	private String ccCVV;
	
	public Order(Long id, 
			Date placedAt,
			String name, 
			String street, 
			String city,
			String state, 
			String zip,
			String ccNumber,
			String ccExpiration,
			String ccCVV) {
		this.id = id;
		this.placedAt = placedAt;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.ccNumber = ccNumber;
		this.ccExpiration = ccExpiration;
		this.ccCVV = ccCVV;
	}
	
	public Order() {

	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(long orderId) {
		this.id = orderId;
	}

	public Date getPlacedAt() {
		return this.placedAt;
	}
	
	public void setPlacedAt(Date date) {
		this.placedAt = date;
	}

	@PrePersist
	public void placedAt() {
		this.placedAt = new Date();
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getStreet() {
		return this.street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	
	public String getCity() {
		return this.city;
	}
	
	
	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getState() {
		return this.state;
	}
	
	public String getZip() {
		return this.zip;
	}

	public String getccNumber() {
		return ccNumber;	
	}
	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcExpiration() {
		return ccExpiration;
	}

	public void setCcExpiration(String ccExpiration) {
		this.ccExpiration = ccExpiration;
	}

	public String getCcCVV() {
		return ccCVV;
	}

	public void setCcCVV(String ccCVV) {
		this.ccCVV = ccCVV;
	}


	public String getccExpiration() {
		return ccExpiration;
	}
	
	public String getccCVV() {
		return ccCVV;
	}

	public List<Taco> getTacos() {
		return this.tacos;
	}

	public void setTacos(List<Taco> tacos) {
		this.tacos = tacos;
	}
	
	 
	public void addTaco(Taco taco) {
		this.tacos.add(taco);
	}

}

