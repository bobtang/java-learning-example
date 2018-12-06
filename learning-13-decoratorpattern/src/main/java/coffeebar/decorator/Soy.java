package coffeebar.decorator;

import coffeebar.Drink;

/**
 *酱油酱油
 */
public class Soy extends Decorator {

	public Soy(Drink Obj) {
		super(Obj);
		// TODO Auto-generated constructor stub
		super.setDescription("Soy");
		super.setPrice(1.5f);
	}

}

