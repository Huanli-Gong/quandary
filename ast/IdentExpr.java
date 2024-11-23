package ast;

import java.util.HashMap;

public class IdentExpr extends Expr {

    final String var;

    public IdentExpr(String var, Location loc) {
        super(loc);
        this.var = var;
    }

    @Override
    public String toString() {
        return var;
    }

    @Override
    QVal eval(HashMap<String, QVal> env) {
        return env.get(var);
    }
}
