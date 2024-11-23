package ast;

import java.util.HashMap;

public class CallStmt extends Stmt{

    final CallExpr func;

    public CallStmt(String funcName, ExprList args, Location loc) {
        super(loc);
        this.func = new CallExpr(funcName, args, loc);
    }

    @Override
    QVal exec(HashMap<String, QVal> env){
        func.eval(env);
        return null;
    }
}
