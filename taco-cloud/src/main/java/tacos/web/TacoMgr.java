package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tacos.domains.Taco;

public class TacoMgr {
	
	private Chicken chicken;
	 
	public TacoMgr() {
		this.chicken = new Chicken();
	}
	
	@Autowired
	public TacoMgr (Chicken chicken) {
		this.chicken = chicken;
	}

	public void manageTaco(Taco taco) {
		System.out.println(taco.toString() + chicken.toString());
	}

}
