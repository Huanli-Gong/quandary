package ast;

import java.io.PrintStream;
import java.util.HashMap;

public class Program extends ASTNode {

    static HashMap<String, FuncDef> funcDefMap;

    public Program(FuncDefList funcDefList, Location loc) {
        super(loc);
        funcDefMap = new HashMap<>();
        funcDefList.buildMap(funcDefMap);
    }

    public void println(PrintStream ps) {
        // ps.println(sl);
    }

    public Object exec(long argument) {
        HashMap<String, QVal> env= new HashMap<>();
        FuncDef main=funcDefMap.get("main");
        env.put(main.params.first, new QIntVal(argument));
        return main.execBody(env);
    }
}
