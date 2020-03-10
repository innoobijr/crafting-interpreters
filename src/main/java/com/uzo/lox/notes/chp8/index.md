# Chapter 8: Statements and State

* To support bindings, our interpreter needs internal state. When you define a variable at the beginning od the program and use it at the ned, the interpreter has to hold on the value of that variable in the meantime. So in this chapter. we will give our interpreter a brains that can not just process, but remember.

* Statement and State go hand in hand. Since statements, by definition, dont evaluate to a value, they need to do something else ot be useful. That something is called a "side effect". It could mean producing user-visible output or modyfing some state in the interpreter that vcan be detected later. The latter makes them a great fit for defining variables or ther named entities.


