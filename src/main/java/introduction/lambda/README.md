# What is the type of a introduction.lambda expression?

Answer: A functional interface
Is an interface with only one ABSTRACT method
* Methods from the Object class don't count [Example: equals(object o)]


# Can a introduction.lambda be put in a variable?

Answer:  Yes


# Is a introduction.lambda expression an object?

Answer: No, but is a not clear no, is an object without and identity. That is why you don't call toString, equals because you don't whant to use like a method.

A introduction.lambda expression is created without using **new**
Creating a new object is not free, when a new object is created
- I need to get some memory
- I need to clean up that memory
- Then execute Static initializer
- Then execute Static blocks
- Then execute Non-static initializer
- Then execute Non-static blocks
- Then execute the constructor from the object class
- Then execute the constructor from all the inheritance from the object class to class instancing

We don't paid this overhead when is create a introduction.lambda expression, and the JVM not create a new object every time I use a introduction.lambda
So is much less work to the JVM use the introduction.lambda expression and the performance is better when they are declare in isntance of anonymous classes.


