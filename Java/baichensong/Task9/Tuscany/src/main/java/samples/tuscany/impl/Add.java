package samples.tuscany.impl;

import samples.tuscany.IAdd;

public class Add  implements IAdd {
    @Override
    public double add(double n1,double n2){
        return n1 + n2;
    }
}
