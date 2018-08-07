package learning.factorymodel.factorymethodmodel.concretecreator;

import learning.factorymodel.factorymethodmodel.concreteproduct.BlackPenCore;
import learning.factorymodel.factorymethodmodel.creator.BallPen;
import learning.factorymodel.factorymethodmodel.product.PenCore;

public class BlackBallPen extends BallPen {
    public PenCore getPenCore(){
       return new BlackPenCore();
    }
}
