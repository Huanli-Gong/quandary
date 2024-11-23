package ast;

import java.util.HashMap;

public class IfStmt extends Stmt{

    final Cond cond;
    final Stmt ifStmt;
    final Stmt elseStmt;

    public IfStmt(Cond cond, Stmt ifStmt, Stmt elseStmt, Location loc) {
        super(loc);
        this.cond = cond;
        this.ifStmt = ifStmt;
        this.elseStmt = elseStmt;
    }

    QVal exec(HashMap<String, QVal> env){
        if (cond.eval(env)){
            return ifStmt.exec(env);
        }
        if (elseStmt != null){
            return elseStmt.exec(env);
        }
        return null;
    }
}
