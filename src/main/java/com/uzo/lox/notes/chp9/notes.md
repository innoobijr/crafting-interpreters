# Chapter 9: Control Flow

## Turing Machines
* "Can all true statements be proven?"
* "Can we compute all functions that we can define?"
* "What do we mean when we claim a function is 'computable'?"

In trying to proving the the first two are false, Aln Turing and Alonzo Church devied a precise answer to the last question  - a definition of what kinds of functions are computable. they each crafted a tiny system with a minimum set of machinery that is stil lpowerful enought to compute any of a (very) large class of functions.

These are now considered the "computable functions". Turings systems is called a Turing machine. Church'es is the lambda calculus. 

## Conditional Execution
* Conditional or branching contorl flow is used ot not execute some piece of code. Imperatively you can thing of it as junmping ahead over a region of code
* Looping control flow executes a chuck of code mroe than once. It jumps bavk so that you can do something again. Since you dont usuaully wnat inifinte loops, it typically has some conditional logic to know when to stop looping as well.

## Logical Operators
```
assignment → identifier "=" assignment
           | logic_or ;
logic_or   → logic_and ( "or" logic_and )* ;
logic_and  → equality ( "and" equality )* ;
```
## While Loops
```
statement → exprStmt
          | ifStmt
          | printStmt
          | whileStmt
          | block ;

whileStmt → "while" "(" expression ")" statement ;
```

## For Loops
```
          | forStmt
          | ifStmt
          | printStmt
          | whileStmt
          | block ;

forStmt   → "for" "(" ( varDecl | exprStmt | ";" )
                      expression? ";"
                      expression? ")" statement ;
```

