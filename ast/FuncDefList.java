package ast;

import java.util.HashMap;

public class FuncDefList extends ASTNode{

    final FuncDef first;
    final FuncDefList rest;

    public FuncDefList(FuncDef first,FuncDefList rest, Location loc) {
        super(loc);
        this.first = first;
        this.rest = rest;
    }


    public void buildMap(HashMap<String, FuncDef> funcDefMap) {
        funcDefMap.put(first.var, first);
        if(rest!=null){
            rest.buildMap(funcDefMap);
        }
    }
}
