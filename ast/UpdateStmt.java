package ast;

import java.util.HashMap;

public class UpdateStmt extends Stmt{

    final String ident;
    final Expr expr;

    public UpdateStmt(String ident, Expr expr, Location loc) {
        super(loc);
        this.ident = ident;
        this.expr = expr;
    }

    @Override
    QVal exec(HashMap<String, QVal> env){
        QVal value =expr.eval(env);
        env.remove(ident);
        env.put(ident,value);
        return null;
    }
}
