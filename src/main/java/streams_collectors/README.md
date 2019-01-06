# What is a Stream

* Technical answer: a typed interface
* New Concept, is not a collection, look like a collection
* An object on which one can define operations
* An object that does not hold any data (Different to Collections)
* An object that should NOT CHANGE THE DATA it processes, this is a rule, but not the compiler or JVM warning about this and can cause a lot of problems
* An object able to process data in "one pass"
* An object optimized from the algorithm point of view, and able to process data in parallel

## What doies it do?

* It gives ways to efficiently process large amounts oif data..and also smaller ones

## What does efficiently mean?

Two Things:
* In parallel, to leverage the computing power of multicore CPUs
* Pipelined, to avoid unnecessary intermediary computations

## Why can't a Collection be a Stream

* Because Steam is a new concepts, and we don't want to change the way the Collection API works


# Question: When I do Filter,  What do i Have in this new Steam?

* Answer: **Nothing**, since a Steam does not hold any data.

```
List<Person> list = ...;
Stream<Person> stream = list.steam();
Stream<Person> filteder = stream.filter(person -> person.getAge() > 20);
```

This call is only  a DECLARATION, not data is processed.
The call to the filter method is **lazy**, all the method of stream return another Stream are lazy

* An operation o a Stream that returns a Stream is called an intermediary operation
* Only a final Operation can trigger the Stream operations

# Reduction

* Reductions are **terminal** operations
* The trigger the processing of the data

## Two kinds of reduction in the Stream api

* 1 - Aggregation = min, max, sum, etc...
* 2 - Mutable reductions: collects, collectors

## Part of the reduction lambda

``` stream.reduce(0, (a1, a2) -> a1+a2); ```

* 1 Argument: Identity element of the reduction operation
* 2 Argument: Reduction operation, of type BinaryOperation<T> (BiFunction extension)

## What Happen if

### Stream is empty?
The reduction of a empty Stream is the identity element

## Stream has only one element?
Then the reduction is that element combine the identity

### Agregations Corner Case

* Suppose the reduction is the max

```
BinaryOperations<Integer> max = (i1, i2) -> i1 > i2 ? i1 : i2;
```

The problem is, there is no identity element for the max reduction, so the max of a empty Stream is undefined.

We can try
```
stream.max(Comparator.naturalOrder());
```

But have this results and are not the identity wanted
If it is and int, then the default value is 0
If it is and integer, then the default value is null

And how is handle? With Optional

```
Optional<Integer> max = stream.max(Comparator.naturalOrder());
```

* Is a Wrapper class
* Optional means "There might be no result"

# How to use an Optional?


The common way
```
Optional<String> opt = ...;
if (opt.isPresent()) {
    String s = opt.get();
} else { .... }
```

* The method isPresent() return true if there is something in the optional.

The orElse way that encapsulates both calls

```
String s = opt.orElse(""); // Defines a default value
```

Or elseThrow.
```
String s = opt.orElseThrow(MyException::new); // Lazy construct
```

# Collectors

* Another type of reduction
* Called "mutable" reduction
* Instead of aggregating elements, this reduction put them in a "Container"

# So What is a Stream?

An object that allow some to define processing on data. There is no limit on the amount of data that can be processed
Those processing are typically map/filter/reduce operations
A Stream cannot be **re-used*
Once it has been used ot process a set of data, it cannot be used again to process another set of data
