# The Expression Problem
An object oriented language like Java assume that all the code in one row naturally hangs together. It figures all the things you do with a type are likely related to each other, and the language makes it easy to define them together as methods inside the same class. 

This makes it easy to extednt the table by adding new rows. Simply define a new class. No existing code has to be touched
But imaging if you want ot add a new operation - a new column. In Java, that means cracking open each of those exisiting classes and adding a method to it. 

Funtional paradigm languages in the ML family flip that around. There, you dont have classes with methods. Type and functions are totally distinct. To implement an operation for a number of different types, you define a single function. In the body of that you use ***pattern matching*** sort of a type-based switch on steriods - to implement the operation for each type all in one place.

Each style has a certain "grain" to it. That what the paradigm literrally means - an object-oriented langauge wants you to orient your code along the rows of types. A functional language instead encourages you to lump each columns's worth of code together into functions. 

### The Visitor Pattern
The pattern isn't about "visiting": and the "accept" methods in it doesnt conjure up any helpful imagert either. Many thing the pattern has to do with traversing trees, which isnt the case at all. We are going to use it on a set of classes that are tree-like, but thats a coincidence. As you'll see, the pattern works as well on a single object.

 The Visitor pattern is really about approximating the functional style within an OOP language. It lets us add new columns to that table easily. We can define all of the behavior for a new operation on a set of types in one place, without having to touch the types themselves. It does this the same way we solve almost every problem in computer sciecne: by adding a layer of indirection. 

 Beofre we apply it to our auto-generated `Expr` classes, we'll walk through a simpler example. Say we have two kinds of pastries: beignets and crullers. 
