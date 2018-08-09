package learning.factorymodel.factorymethodmodel.concretefactory;

import learning.factorymodel.factorymethodmodel.concreteproduct.BlackPenCore;
import learning.factorymodel.factorymethodmodel.factory.BallPen;
import learning.factorymodel.factorymethodmodel.product.PenCore;

/**
 * ConcreteFactory（具体工厂）
 */
public class BlackBallPen extends BallPen {
    public PenCore getPenCore(){
       return new BlackPenCore();
    }
}
