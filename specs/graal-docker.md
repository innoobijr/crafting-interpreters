## Creating an executable native-image of JLox with GraalVM

-------
* Install GraalVM
* Install Docker
-------

1. Find the directory where the Crafting Interpreters project is kept
2. Create a docker volume with the directory mounted 
	docker run -it -v [HOST-DIRECTORY]:[PATH_IN_CONTAINER] oracle/graalvm-ce:[GRALL-VERSION]
3. Either add the "target/classes" directory to path: (See here: https://javarevisited.blogspot.com/2015/04/error-could-not-find-or-load-main-class-helloworld-java.html) or include full directory path in following command

4. Compile teh Lox.class with javac "javac Lox.java"
5. Run: ```native-image com.uzo.lox.Lox jlox" :: [native image [class] [executable name]]```
6. Allow the use the execute the executable:
  ```chmod u+x jlox```

*7. Might need to added an alias in your bashrc or profile. 

*8. Add build task that takes the jar and produces the executable in this path.
