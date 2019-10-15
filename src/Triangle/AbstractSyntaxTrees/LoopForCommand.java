/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author andpi
 */
public class LoopForCommand extends Command {

    public LoopForCommand(Identifier iAST, Expression eAST, Expression e2AST, Command cAST, SourcePosition thePosition) {
        super(thePosition);
        I = iAST;
        E1 = eAST;
        E2 = e2AST;
        C = cAST;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitLoopForCommand(this, o);
    }
    
    public Identifier I;
    public Expression E1, E2;
    public Command C;
    
}
