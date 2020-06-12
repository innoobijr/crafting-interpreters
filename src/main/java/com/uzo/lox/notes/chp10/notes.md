#Chapter 10: Functions

## Call
```
unary → ( "!" | "-" ) unary | call ;
call  → primary ( "(" arguments? ")" )* ;
arguments → expression ( "," expression )* ;
```

## Funciton Declarations
```
declaration → funDecl
            | varDecl
            | statement ;

funDecl  → "fun" function ;
function → IDENTIFIER "(" parameters? ")" block ;

```
## REturn statement
```
statement  → exprStmt
           | forStmt
           | ifStmt
           | printStmt
           | returnStmt
           | whileStmt
           | block ;

returnStmt → "return" expression? ";" ;
```


