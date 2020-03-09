# Context-Free Grammars

* The formalism for defining the lexical grammar -  the rule for how characters get grouped into tokens is called **regular language**.

We need a bigger hammer, and that hammer is a ***context-free grammar (CFG)***. It is the heaviest tool in the toolbox of formal grammars. A fromal grammar takes a set of atomic pieces it calls it "alphabet". The it defines a set of strings that are in the grammer. Each string is a sequence of letters in the alphabet.

There is (obviously) a difference between lexical and syntactic grammars. In the syntactic grammar, each "letter" in the alphabet is an entire token and a string is a sequence of tokens - an entire expression. 

[Grammar]("../images/context-free-table.png")

* A formal grammars job is to specify whic strigns are valid and whic arent. If we were defining a grammar of English sentences, "eggs are tasty for breakfast" would be in the grammar. but "tasl breaksfast for are eggs" would probably not be. 

1. Rules for grammars
If you stat wull rules you can use them to generate strings that are in the grammar. String created this way are called **derivations** because each is dervied from the rules of the grammar.

Rules are called **productions** because they produce strings in the grammar. Each production in a context-free grammar has a head -its names - and a body which describes what it generates. In its pure form a body is a sequence of symbols. Symbols come in two flavors:
* terminal: individual lexemes, or tokens comming from a scanner.
* non-terminal: a named reference to another rule.


