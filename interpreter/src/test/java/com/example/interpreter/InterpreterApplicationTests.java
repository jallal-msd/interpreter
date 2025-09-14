package com.example.interpreter;

import com.example.interpreter.service.Lexer;
import com.example.interpreter.service.Token;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class InterpreterApplicationTests {


	@Test
	public void lexerTest(){
		String example = "Create   sam 25 liam 22";
		Lexer lexere= new Lexer(example);
		List<Token> tokens = lexere.tokenize();

		for(Token token : tokens){
			System.out.println(token);
		}
	}
}
