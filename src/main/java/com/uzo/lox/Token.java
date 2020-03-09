package com.uzo.lox;

/**
 * Back when I was preaching the gospel about error handling, we saw that
 * we need to tell users where errors occured. Tracking that starts here. In our
 * simple interpreter, we only note which line the token appears on, but 
 * more sophisticated implmementations include the column and length too.
 */
class Token {
    /**
     * A `Token` is a bundle containing the raw lexeme along with other things the scanner
     * learned about it.
     */
    final TokenType type;
    final String lexeme;
    final Object literal;
    final int line;

    Token(TokenType type, String lexeme, Object literal, int line){
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }

    public String toString(){
        return type + " " + lexeme + " " + literal;
    }
}