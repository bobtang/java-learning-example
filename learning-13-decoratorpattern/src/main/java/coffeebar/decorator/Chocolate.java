package coffeebar.decorator;


import coffeebar.Drink;

/**
 * 巧克力
 */
public class Chocolate extends Decorator {

	public Chocolate(Drink Obj) {
		super(Obj);
		// TODO Auto-generated constructor stub
		super.setDescription("Chocolate");
		super.setPrice(3.0f);
	}

}
