package tacos;

import java.util.List;
import javax.validation.constraints.Size;

import tacos.domains.Ingredient;

public class Taco {


  @Size(min=5, message="Name must be at least 5 characters long")

  private String name;
  
  @Size(min=1, message="You must choose at least 1 ingredient")
  
  private List<Ingredient> ingredients;
  
  
  public Taco(List<Ingredient> ingredients, String name) {
	  this.ingredients = ingredients;
	  this.name = name;
  }
  
  public Taco() {

  }

public List<Ingredient> getIngredients() {
	  return this.ingredients;
  }
  
  public String getName() {
	  return this.name;
  }

}