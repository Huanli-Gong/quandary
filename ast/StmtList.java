package ast;

import java.util.HashMap;

public class StmtList extends Stmt{

    final Stmt first;
    final StmtList rest;

    public StmtList(Stmt first,StmtList rest, Location loc) {
        super(loc);
        this.first = first;
        this.rest = rest;
    }


    public QVal exec(HashMap<String, QVal> env) {
        QVal result = first.exec(env);
        if(result!=null){
            return result;
        }
        if(rest!=null){
            return rest.exec(env);
        }
        return null;
    }
}
