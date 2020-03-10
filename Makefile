.DEFAULT_GOAL := build

all: generate_ast build

generate_ast:
	@echo "Compiling GenerateAst"
	javac -d target/classes src/main/java/com/uzo/tool/GenerateAst.java
	@echo "Generating AST classes"
	java -cp target/classes com.uzo.tool.GenerateAst src/main/java/com/uzo/lox

build:
	@echo "Compiling Lox"
	javac -d target/classes src/main/java/com/uzo/lox/*.java

clean:
	@echo "Cleaning project"
	rm -rf target/classes/*

