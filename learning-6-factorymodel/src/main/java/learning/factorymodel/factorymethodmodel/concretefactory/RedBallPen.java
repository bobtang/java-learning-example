package learning.factorymodel.factorymethodmodel.concretefactory;

import learning.factorymodel.factorymethodmodel.concreteproduct.RedPenCore;
import learning.factorymodel.factorymethodmodel.factory.BallPen;
import learning.factorymodel.factorymethodmodel.product.PenCore;

/**
 * ConcreteFactory（具体工厂）
 */
public class RedBallPen extends BallPen {
    public PenCore getPenCore() {
        return new RedPenCore();
    }
}
