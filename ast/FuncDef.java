package ast;

import java.util.HashMap;

public class FuncDef extends ASTNode{

    final String var;
    final FormalDeclList params;
    final StmtList body;
    
    public FuncDef(String var,FormalDeclList params,StmtList body, Location loc) {
        super(loc);
        this.var = var;
        this.body = body;
        this.params = params;
    }
    
    public QVal execBody(HashMap<String, QVal> newEnv) {
        return body.exec(newEnv);
    };
}
