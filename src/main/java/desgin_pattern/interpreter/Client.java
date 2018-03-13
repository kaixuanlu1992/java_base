package desgin_pattern.interpreter;
/*
解释器模式：给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子
文法：即语法规则。在解释器模式中每一个语法都将对应一个解释器对象，用来处理相应的语法规则。
解释器模式描述了如何为简单的语言定义一个文法，如何在该语言中表示一个句子，以及如何解释这些句子。
在解释器模式中可以通过一种称之为抽象语法树(Abstract Syntax Tree, AST)的图形方式来直观地表示语言的构成，每一棵抽象语法树对应一个语言实例
 4个角色：
 抽象表达式：表达式存放的接口
 终结表达式
 非终结表达式
 环境：存放终结表达式
 */
public class Client {
    public static void main(String[] args) {
        Context ct=new Context();
        Variable ex=new Variable("kai");
        Expression expression=new Not(ex);
        ct.assign(ex,false);
        System.out.println(expression.interpret(ct));
    }
}
