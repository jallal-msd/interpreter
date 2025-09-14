package com.example.interpreter.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class Lexer {

    private String input;
    private int currentPos ;

    public Lexer() {
    }

    public Lexer(String input) {
        this.input = input;
        this.currentPos = 0;
    }

    public List<Token> tokenize(){
        List<Token> tokens = new ArrayList<>();

        while(currentPos < input.length()){
            char currentChar = input.charAt(currentPos);

            if(Character.isWhitespace(currentChar)){
                currentPos++;
                continue;
            }
            Token token = nextToken();
            if(token != null){
                tokens.add(token);
            }else {
                throw new RuntimeException("unkown character" + currentChar);
            }

        }

        return tokens;

    }

    private Token nextToken(){
        if(currentPos >= input.length()) return null;

        String[] tokenPatterns = {
                "CREATE|END", //KEYWORD
                "[a-zA-Z0-9]",  //LITERAL
                "cl_[a-zA-z]+" //IDENTIFIER
        };
        TokenType[] tokenTypes = {
                TokenType.KEYWORD,
                TokenType.LITERAL,
                TokenType.IDENTIFIER
        };
        for(int i= 0 ; i<tokenPatterns.length; i++){
            Pattern pattern = Pattern.compile("^" + tokenPatterns[i]);
            Matcher matcher = pattern.matcher(input.substring(currentPos));
            if(matcher.find()){
                String value = matcher.group();
                currentPos += value.length();
                return new Token(value, tokenTypes[i]);
            }
        }
        return null;

    }
}
