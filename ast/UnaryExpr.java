package ast;

import java.util.HashMap;

public class UnaryExpr extends Expr {

    final Expr expr;

    public UnaryExpr(Expr expr, Location loc) {
        super(loc);
        this.expr= expr;
    }

    @Override
    public String toString() {
        return "(" + " - " + expr+ ")";
    }

    @Override
    QVal eval(HashMap<String, QVal> env) {
        return new QIntVal(-(long)expr.eval(env).val()) ;
    }
}
