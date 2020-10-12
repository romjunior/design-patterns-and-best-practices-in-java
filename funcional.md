# Programação Funcional

Diferente do paradigma OOP, a construção de um programa é composto por funções ao invés de objetos. Isso é feito da maneira declarativa, por composição de funções, imutabilidade, e evitando *side-effects* em dados compartilhados.

Isso nos da um código mais consciso e mais resiliente à mudanças, previsível e mais fácil para manutenção.

## Conceitos e Príncipios

### Lambdas
Vem do Lambda Calculus e é usada para identificar *functions expressions*, são mais simples e tem escrita reduzida do que declarações. No Java 8 foi disponibilizada e trabalha de uma maneira diferente, não gerando classes para serem carregadas, para evtiar problemas de performance.

Exemplo, cálculo do radio do círculo:
```java
(x, y) -> x*2 + y*2
```

### Pure Functions
É uma função que não possui *side-effects*, se sua entrada é a mesma, sua saída também será(previsível e cacheável). *side-effect* é uma ação que modifica o funcionamento da função de fora do contexto dela.

Exemplos:
* Escrevendo em um arquivo/console/rede/tela
* Modificar uma variável/obejto de fora da função
* Chamar uma função não pura
* iniciar um processo

É inevitável um programa não possuir funções não puras, que causam *side-effects* por isso tente isolar essas funções das puras. Haskell e em outras linguagens funcionais isso é feito usando *Monads*

### Referential Transparency
É a propriedade da função ser substítuível com o seu valor de retorno e o seu valor de input. Isso favorece caching o resultado para o mesmo input, paralelismo das chamadas e escrita de testes.

### First-class Functions
São funções que podem ser tratadas como os objetos no OOP - criados, armarenados, usados como parâmetors, e retornado como valores.

### Higher-order Functions
São funções que podem receber outras funções como parâmetros, criá-las e retorna-las. Promovem o reuso de código, utilizando funções menores e que já foram testadas.

Exemplo. cálculo da média do dobro dos números passados
```java
OptionalDouble avg = IntStream.of(4, 5, 6)
.map(x -> x*2) //higher-order function
.average();
```

### Composition
 Na matemática, as funções são compostas/ligadas usando a saida de uma função como entrada para a próxima função. Mesma regra se aplica para *first-class functions* serem usadas pelas *higher-order functions*

### Currying
 é o processo usado para transformar uma *n-ary function* em uma série ou *unary functions*

 Exemplo, forma *curried* da função f:: (x, y) -> z
```java
x -> y -> z
```

Exemplo, cálculo da raio quadrado:
```java
Function<Integer, Function<Integer, Integer>> square_radius = x -> y -> x*x + y*y;
List<Integer> squares = List.of(new Tuple<Integer, Integer>(1,5), new Tuple<Integer, Integer>(2,3))
.stream()
.map(square - > square_radius.apply(square.y).apply(square.x))
.collect(Collectors.toList());
===> [26, 13]
```

### Closure

É uma tecnica para implementar o *lexical scoping*(permite nós acessarmos variáveis fora do contexto dentro do *inner scope*)

### Immutability

Promover imutabilidade simplifica o código e permite que os desenvolvedores foquem no fluxo. O pior tipo de *side-effects* são os que mudam pouco em um ponto e produzem resultados catastróficos em outro(Efeito borboleta). São difícies de paralelizar e as vezes temos que trabalhar com *locks*.

### Functors

Permitem aplicar funções dado o container. Eles sabem como *unwrap* o valor do *wrapped object*, aplicar a função e retornar um outro functor contendo o novo/transformado *wrapped object* como resultado. Ex de functors(Collections, futures(promises), e Optionals)

Exemplo, usando o Functor `Optional`, aplicando uma divisão em um Optional(5) vai retornar outro Optional(2,5)
```java
Optional<Float> a = Optional.of(5);
Optional<Float> b = a.map(x -> x/2);
b.get() ===> 2,5
```
### Applicatives

Adicionam um novo nível de *wrapping*. Ao invés de aplicar a função no *wrapped object*, a função é *wrapped* também.

Exemplo, vamos criar um Optional que retorne uma função, e se não possuir uma função(Optional.Empty), ela vai executar a `Function.identity()`(tudo fica a mesma coisa).
```java
Optional<String> a = Optional.of("Hello!");
Optional<Function<String, String>> upper = Optional.of(String::toUpperCase);
a.map(x -> upper.get().apply(x)); // HELLO!
// mas caso o upper fosse empty
upper = Optional.empty();
Optional<Function<String, String>> identity = Optional.of(Function.identity());
a.map(x -> upper.or(() -> identity).get().apply(x)); //Hello!
```

### Monads

aplica uma função que retorna um valor *wrapped* para um valor *wrapped*. Java tem exemplos como `Stream`, `CompletableFuture`, `Optional`.

Exemplo:
```java
Map<Integer, String> codesMapping = Map.of(400500, "Cluj-Napoca", 75001, "Paris", 10115, "Berlin", 10000, "New York");
List<Integer> codes = List.of(400501, 75001, 10115, 10000);
codes.stream().flatMap(x -> Stream.ofNullable(codesMapping.get(x))).collect(Collectors.toList()); //Paris, Berlin, New York
```