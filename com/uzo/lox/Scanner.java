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

    /**
     * The scanner works it way throught the aoruce doe, adding tokens
     * until t runs out of cjaracters, When its done it appends one filen "end of file" token. That
     * isn't strictly needed, but it makes out parses a little cleaner.
     */
    private boolean isAtEnd(){
        return current >= source.length();
    }
}