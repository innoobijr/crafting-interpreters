package com.uzo.lox;

import java.io.BufferedReader;                               
import java.io.IOException;                                  
import java.io.InputStreamReader;                            
import java.nio.charset.Charset;                             
import java.nio.file.Files;                                  
import java.nio.file.Paths;                                  
import java.util.List;  

import com.uzo.lox.*;

public class Lox {

    static boolean hadError = false;
    public static void main(String[] args) throws IOException {
        if (args.length > 1){
            System.out.println("Usage: jlox [script]");
            System.exit(64);
        } else if (args.length == 1){
            runFile(args[0]);
        } else {
            runPrompt();
        }
    }

    /**
     * Lox is a scripting language, which means it executes directly from source. 
     * There are actually two ways you can run some code. If you start jlox from the command line and give it a path to a file, 
     * it reads the file and executes it:
     */
    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));

        // Indicate an rror in the exit code
        if (hadError) System.exit(65);
    }

    private static void runPrompt() throws IOException{
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader =new BufferedReader(input);

        for (;;){
            System.out.println("> ");
            run(reader.readLine());
            // Reset error flag on interactive loop
            hadError = false;
        }
    }

    /**
     * Both the prompt and the file runner are thin wrappers around this core function:
     */
    private static void run(String source){
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        // For now, just print the tokens
        for (Token token: tokens){
            System.out.println(token);
        }
    }

    /**
     * Error handling
     */
    static void error(int line, String message){
        report(line, "", message);
    }

    private static void report(int line, String where, String message){
        System.err.println(""+
        "[line " + line + "] Error" + where + ": " + message);
        hadError = true;
    }


}