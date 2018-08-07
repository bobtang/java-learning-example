package learning.factorymodel.factorymethodmodel.concretecreator;

import learning.factorymodel.factorymethodmodel.concreteproduct.RedPenCore;
import learning.factorymodel.factorymethodmodel.creator.BallPen;
import learning.factorymodel.factorymethodmodel.product.PenCore;

/**
 * 具体构造者（ConcreteCreator）
 */
public class RedBallPen extends BallPen {
    public PenCore getPenCore() {
        return new RedPenCore();
    }
}
