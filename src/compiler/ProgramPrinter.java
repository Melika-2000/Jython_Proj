package compiler;

import gen.jythonListener;
import gen.jythonParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ProgramPrinter implements jythonListener {

    @Override
    public void enterProgram(jythonParser.ProgramContext ctx) {
        System.out.println("program start{");
    }

    @Override
    public void exitProgram(jythonParser.ProgramContext ctx) {
        System.out.println("}");
    }

    @Override
    public void enterImportclass(jythonParser.ImportclassContext ctx) {
        System.out.println("    import class: " + ctx.CLASSNAME());
    }

    @Override
    public void exitImportclass(jythonParser.ImportclassContext ctx) {
    }

    @Override
    public void enterClassDef(jythonParser.ClassDefContext ctx) {
        System.out.print("    class: " + ctx.CLASSNAME(0) + "/ class parents: ");
        if(ctx.CLASSNAME().size() == 2)
            System.out.print("object, ");
        else{
            for(int i=1; i<ctx.CLASSNAME().size(); i++){
                System.out.print(ctx.CLASSNAME(i)+", ");
            }
        }
        System.out.println("{");
    }

    @Override
    public void exitClassDef(jythonParser.ClassDefContext ctx) {
        System.out.println("    }");
    }

    @Override
    public void enterClass_body(jythonParser.Class_bodyContext ctx) {
        System.out.print("    ");
    }

    @Override
    public void exitClass_body(jythonParser.Class_bodyContext ctx) {

    }

    @Override
    public void enterVarDec(jythonParser.VarDecContext ctx) {

        //faghat vaghti az class_body ya statement seda zade shode chap beshe
        if(ctx.getParent().getClass().getName().contains("Parameter") ||
                ctx.getParent().getClass().getName().contains("Assignment"))
            return;

        //age dakhel method ha bashe matn ye tab dige bayad biad jolo
        if(!ctx.getParent().getClass().getName().contains("Class_body"))
            System.out.print("        ");
        System.out.println("    field: " + ctx.ID() + "/ type= " + ctx.getChild(0));

    }

    @Override
    public void exitVarDec(jythonParser.VarDecContext ctx) {

    }

    @Override
    public void enterArrayDec(jythonParser.ArrayDecContext ctx) {

        if(!ctx.getParent().getClass().getName().contains("Class_body"))
            System.out.println("    ");
        System.out.println("    field: " + ctx.ID() + "/ type= " + ctx.getChild(0));

    }

    @Override
    public void exitArrayDec(jythonParser.ArrayDecContext ctx) {

    }

    @Override
    public void enterMethodDec(jythonParser.MethodDecContext ctx) {

        System.out.print("    class method: " + ctx.ID());
        //farzand 1 ctx hamishe noe khurujie
        if(!ctx.getChild(1).getText().equals("void"))
            System.out.print("/ return type: " + ctx.getChild(1));
        System.out.println("{");

    }

    @Override
    public void exitMethodDec(jythonParser.MethodDecContext ctx) {
       System.out.println("        }");
    }

    @Override
    public void enterConstructor(jythonParser.ConstructorContext ctx) {
        System.out.println("    class constractor: " + ctx.getChild(1) + "{");
    }

    @Override
    public void exitConstructor(jythonParser.ConstructorContext ctx) {
        System.out.println("        }");
    }

    @Override
    public void enterParameter(jythonParser.ParameterContext ctx) {

        System.out.print("            ");
        System.out.print("parameter list: [");
        if(ctx.getChildCount() == 1) {
            System.out.println(ctx.getChild(0).getChild(0) + " " +
                    ctx.getChild(0).getChild(1) + "]");
            return;
        }
        for (int i=0 ; i<ctx.getChildCount(); i++) {
            if (ctx.getChild(i).getText().equals(","))
                continue;
            System.out.print(ctx.getChild(i).getChild(0) + " " +
                    ctx.getChild(i).getChild(1) + ", ");
        }
        System.out.println("]");

    }

    @Override
    public void exitParameter(jythonParser.ParameterContext ctx) {

    }

    @Override
    public void enterStatement(jythonParser.StatementContext ctx) {

    }

    @Override
    public void exitStatement(jythonParser.StatementContext ctx) {

    }

    @Override
    public void enterReturn_statment(jythonParser.Return_statmentContext ctx) {

    }

    @Override
    public void exitReturn_statment(jythonParser.Return_statmentContext ctx) {

    }

    @Override
    public void enterCondition_list(jythonParser.Condition_listContext ctx) {

    }

    @Override
    public void exitCondition_list(jythonParser.Condition_listContext ctx) {

    }

    @Override
    public void enterCondition(jythonParser.ConditionContext ctx) {

    }

    @Override
    public void exitCondition(jythonParser.ConditionContext ctx) {

    }

    @Override
    public void enterIf_statment(jythonParser.If_statmentContext ctx) {

    }

    @Override
    public void exitIf_statment(jythonParser.If_statmentContext ctx) {

    }

    @Override
    public void enterWhile_statment(jythonParser.While_statmentContext ctx) {

    }

    @Override
    public void exitWhile_statment(jythonParser.While_statmentContext ctx) {

    }

    @Override
    public void enterIf_else_statment(jythonParser.If_else_statmentContext ctx) {

    }

    @Override
    public void exitIf_else_statment(jythonParser.If_else_statmentContext ctx) {

    }

    @Override
    public void enterPrint_statment(jythonParser.Print_statmentContext ctx) {

    }

    @Override
    public void exitPrint_statment(jythonParser.Print_statmentContext ctx) {

    }

    @Override
    public void enterFor_statment(jythonParser.For_statmentContext ctx) {

    }

    @Override
    public void exitFor_statment(jythonParser.For_statmentContext ctx) {

    }

    @Override
    public void enterMethod_call(jythonParser.Method_callContext ctx) {

    }

    @Override
    public void exitMethod_call(jythonParser.Method_callContext ctx) {

    }

    @Override
    public void enterAssignment(jythonParser.AssignmentContext ctx) {

    }

    @Override
    public void exitAssignment(jythonParser.AssignmentContext ctx) {

    }

    @Override
    public void enterExp(jythonParser.ExpContext ctx) {

    }

    @Override
    public void exitExp(jythonParser.ExpContext ctx) {

    }

    @Override
    public void enterPrefixexp(jythonParser.PrefixexpContext ctx) {

    }

    @Override
    public void exitPrefixexp(jythonParser.PrefixexpContext ctx) {

    }

    @Override
    public void enterArgs(jythonParser.ArgsContext ctx) {

    }

    @Override
    public void exitArgs(jythonParser.ArgsContext ctx) {

    }

    @Override
    public void enterExplist(jythonParser.ExplistContext ctx) {

    }

    @Override
    public void exitExplist(jythonParser.ExplistContext ctx) {

    }

    @Override
    public void enterArithmetic_operator(jythonParser.Arithmetic_operatorContext ctx) {

    }

    @Override
    public void exitArithmetic_operator(jythonParser.Arithmetic_operatorContext ctx) {

    }

    @Override
    public void enterRelational_operators(jythonParser.Relational_operatorsContext ctx) {

    }

    @Override
    public void exitRelational_operators(jythonParser.Relational_operatorsContext ctx) {

    }

    @Override
    public void enterAssignment_operators(jythonParser.Assignment_operatorsContext ctx) {

    }

    @Override
    public void exitAssignment_operators(jythonParser.Assignment_operatorsContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
