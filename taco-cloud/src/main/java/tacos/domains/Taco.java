package tacos.domains;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;

public class Taco {

	private Long id;
	private Date createdAt;

	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;

	@Size(min=1, message="You must choose at least 1 ingredient")
	private List<Ingredient> ingredients;


	public Taco(Long id, 
			Date createdAt, 
			List<Ingredient> ingredients, 
			String name) {
		this.id = id;
		this.createdAt = createdAt;
		this.ingredients = ingredients;
		this.name = name;
	}

	public Taco() {

	}

	public Long getId() {
		return this.id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public String getName() {
		return this.name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setCreatedAt(Date date) {
		this.createdAt = date;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
}