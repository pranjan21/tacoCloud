package tacos.domains;

public class Ingredient {
  
  public Ingredient(String id, String name, Type type) {
	  this.id = id;
	  this.name = name;
	  this.type = type;
  }

  private final String id;
  private final String name;
  private final Type type;
  
  public static enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }

public Object getType() {
	return this.type;
}

public String getName() {
	return this.name;
}

public String getId() {
	return this.id;
}
}