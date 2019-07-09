package tacos.web;

import org.springframework.stereotype.Component;

@Component
public class Chicken {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Chicken() {
		super();
		this.name = "unknown";
	}

	public Chicken(String name) {
		this.name = name;
	}

}
