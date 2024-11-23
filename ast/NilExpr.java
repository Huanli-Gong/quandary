package ast;

import java.util.HashMap;

public class NilExpr extends Expr {

    final QRefVal value = new QRefVal(null);

    public NilExpr(Location loc) {
        super(loc);
    }

    @Override
    public String toString() {
        return "nil";
    }

    @Override
    QVal eval(HashMap<String, QVal> env) {
        return value;
    }
}
