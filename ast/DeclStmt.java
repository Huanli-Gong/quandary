package ast;

import java.util.HashMap;

public class DeclStmt extends Stmt{

    final String var;
    final Expr expr;

    public DeclStmt(String var, Expr expr, Location loc) {
        super(loc);
        this.var = var;
        this.expr = expr;
    }

    @Override
    QVal exec(HashMap<String, QVal> env){
        env.put(var, expr.eval(env));
        return null;
    }
}
