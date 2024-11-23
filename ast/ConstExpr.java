package ast;

import java.util.HashMap;

public class ConstExpr extends Expr {

    final QIntVal value;

    public ConstExpr(long value, Location loc) {
        super(loc);
        this.value = new QIntVal(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    
    QVal eval(HashMap<String, QVal> env) {
        return value;
    }
}
