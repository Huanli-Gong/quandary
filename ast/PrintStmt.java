package ast;

import java.util.HashMap;

public class PrintStmt extends Stmt{

    final Expr expr;

    public PrintStmt(Expr expr, Location loc) {
        super(loc);
        this.expr = expr;
    }

    QVal exec(HashMap<String, QVal> env){
        System.out.println(expr.eval(env).toString());
        return null;
    }
}
