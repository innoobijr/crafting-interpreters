package com.uzo.lox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// staic import
// save from having to sprinkle TokenType. all over the scaner and parser.
import static com.uzo.lox.TokenType.*;

class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int start = 0;
    private int current = 0;
    private int line = 1;

    Scanner(String source){
        this.source = source;
    }

    /**
     * We store thr raw source code as simple string, and we have a list ready to fill
     * with token's we're going to generate. The aforementioned loop that does that looks 
     * like this.
     */
    List<Token> scanTokens(){
        while(!isAtEnd()){
            // We are at the beginning of the next lexems.
            start = current;
            scanToken();
        }

        tokens.add(new Token(EOF, "", null, line));
        return tokens;
    }



    // Recognizing Lexemes
    private void scanToken(){
        char c = advance();
        switch (c){
            case '(': addToken(LEFT_PAREN); break;
            case ')': addToken(RIGHT_PAREN); break;
            case '{': addToken(LEFT_BRACE); break;
            case '}': addToken(RIGHT_BRACE); break;    
            case ',': addToken(COMMA); break;          
            case '.': addToken(DOT); break;            
            case '-': addToken(MINUS); break;          
            case '+': addToken(PLUS); break;           
            case ';': addToken(SEMICOLON); break;      
            case '*': addToken(STAR); break;
            //single character lexemes
            case '!':addToken(match('=') ? BANG_EQUAL : BANG); break;
            case '=': addToken(match('=') ? EQUAL_EQUAL : EQUAL); break;    
            case '<': addToken(match('=') ? LESS_EQUAL : LESS); break;      
            case '>': addToken(match('=') ? GREATER_EQUAL : GREATER); break;
            // longer lexemes
            case '/':
                if (match('/')){
                    while(peek() != '\n' && isAtEnd()) advance();
                } else {
                    addToken(SLASH);
                }
                break;
            case ' ':
            case '\r':
            case '\t':
                //Ignore withpace
                break;
            case '\n':
                line++;
                break;
            case '"': string(); break;
            // for characters that Lox doesnt like
            default:
                if(isDigit(c)){
                    numbers();
                } else {
                    Lox.error(line, "Unexpected character.");
                    break;
                }
        }
    }

    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }

    private void number(){
        while(isDigit(peek())) advance();

        //Look for a fractional part.
        if (peek() == '.' && isDigit(peekNext())){
            // Consume the '.'
            advance();

            while (isDigit(peek())) advance();
        }

        addToken(NUMBER, Double.parseDouble(source.substring(start, current)));
    }


    private char peekNext(){
        if (current + 1 >= source.length()) return '\0';
        return source.charAt(current + 1);
    }

    private void string(){
        while(peek() != '"' && !isAtEnd()){
            if(peek() == '\n') line ++;
            advance();
        }

        // Unterminated string.
        if (isAtEnd()){
            Lox.error(line, "Unterminated string.");
            return;
        }

        // The closing
        advance();

        // Trim the surrounding quotes
        String value = source.substring(start +1, current -1);
        addToken(STRING, value);
    }

    /**
     *  Like a conditional advance(). It only consumes the current character if its
     * what we're looking for.
     * @param expected
     * @return
     */
    private boolean match(char expected){
        if (isAtEnd()) return false;
        if (source.charAt(current) != expected) return false;

        current++;
        return true;
    }

    /**
     * After we detect the beginning of a long lexeme. we shunt off to some code specific to
     * that kind of lexeme that keeps eating characters until it sees the end.
     * Its liek advance(), but doesnt consume the character. This is a lookahead.
     * @return char
     */
    private char peek(){
        if (isAtEnd()) return '\0';
        return source.charAt(current);
    }

     /**
     * The scanner works it way throught the aoruce doe, adding tokens
     * until t runs out of cjaracters, When its done it appends one filen "end of file" token. That
     * isn't strictly needed, but it makes out parses a little cleaner.
     */
    private boolean isAtEnd(){
        return current >= source.length();
    }

    // Helper methods
    /**
     * advance() consumes the nexct character in the source file and returns it.
     * Where advance() is for input, addToken() is for output. It grabs the text of the current 
     * lexeme and creates a new token for it.
     */
    private char advance(){
        current++;
        return source.charAt(current - 1);
    }

    private void addToken(TokenType type){
        addToken(type, null);
    }

    private void addToken(TokenType type, Object literal){
        String text = source.substring(start, current);
        tokens.add(new Token(type, text, literal, line));
    }
}
