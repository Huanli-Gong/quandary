package ast;

import java.util.HashMap;

public class WhileStmt extends Stmt{

    final Cond cond;
    final Stmt stmt;


    public WhileStmt(Cond cond, Stmt stmt, Location loc) {
        super(loc);
        this.cond = cond;
        this.stmt = stmt;

    }

    QVal exec(HashMap<String, QVal> env){
        while(cond.eval(env)){
            if (stmt!=null){
                QVal result = stmt.exec(env);
                if (result!=null){
                    return result;
                }
            }
        }
        return null;
    }
}
