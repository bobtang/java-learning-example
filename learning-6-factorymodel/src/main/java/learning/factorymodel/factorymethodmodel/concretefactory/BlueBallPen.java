package learning.factorymodel.factorymethodmodel.concretefactory;

import learning.factorymodel.factorymethodmodel.concreteproduct.BluePenCore;
import learning.factorymodel.factorymethodmodel.factory.BallPen;
import learning.factorymodel.factorymethodmodel.product.PenCore;

/**
 * ConcreteFactory（具体工厂）
 */
public class BlueBallPen extends BallPen {
    public PenCore getPenCore(){
       return new BluePenCore();
    }
}
