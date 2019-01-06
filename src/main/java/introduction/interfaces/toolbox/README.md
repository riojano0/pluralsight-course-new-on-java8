# java.util.function

## Can be group 4 Categories

### Supplier

```
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```


### Consumer

```
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```

[Example system.out.print]

### Consumer/BiConsumer

```
public interface BiConsumer<T, U> {
    void accept(T t, U u);
}
```

### Predicate/BiPredicate

```
public interface Predicate<T> {
    boolean test(T t);
}
```

### Function/BiFunction/UnaryOperator

```
public interface Function<T, R> {
    R apply(T t);
}
```
