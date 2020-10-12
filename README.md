# Design Patterns and Best Practices in Java

## Fontes

Estudo do livro: Design Patterns and Best Practices in Java

Código fonte do livro: [Github](https://github.com/PacktPublishing/Design-Patterns-and-Best-Practices-in-Java)

Imagens do livro: [Imagens](https://static.packt-cdn.com/downloads/DesignPatternsandBestPracticesinJava_ColorImages.pdf)

[Refactoring Guru](https://refactoring.guru/pt-br)

## Conteúdos

* [Conceitos e SOLID](conceitos-e-solid.md)
* [Design Patterns](design-patterns.md)

## Programação Funcional

Diferente do paradigma OOP, a construção de um programa é composto por funções ao invés de objetos. Isso é feito da maneira declarativa, por composição de funções, imutabilidade, e evitando *side-effects* em dados compartilhados.

Isso nos da um código mais consciso e mais resiliente à mudanças, previsível e mais fácil para manutenção.

### Conceitos e Príncipios

**Lambdas**

Vem do Lambda Calculus e é usada para identificar *functions expressions*, são mais simples e tem escrita reduzida do que declarações. No Java 8 foi disponibilizada e trabalha de uma maneira diferente, não gerando classes para serem carregadas, para evtiar problemas de performance.

Exemplo, cálculo do radio do círculo:
```java
(x, y) -> x*2 + y*2
```

**Pure Functions**

É uma função que não possui *side-effects*, se sua entrada é a mesma, sua saída também será(previsível e cacheável). *side-effect* é uma ação que modifica o funcionamento da função de fora do contexto dela.

Exemplos:
* Escrevendo em um arquivo/console/rede/tela
* Modificar uma variável/obejto de fora da função
* Chamar uma função não pura
* iniciar um processo

É inevitável um programa não possuir funções não puras, que causam *side-effects* por isso tente isolar essas funções das puras. Haskell e em outras linguagens funcionais isso é feito usando *Monads*

**Referential Transparency**

É a propriedade da função ser substítuível com o seu valor de retorno e o seu valor de input. Isso favorece caching o resultado para o mesmo input, paralelismo das chamadas e escrita de testes.

**First-class Functions**

São funções que podem ser tratadas como os objetos no OOP - criados, armarenados, usados como parâmetors, e retornado como valores.

**Higher-order Functions**

São funções que podem receber outras funções como parâmetros, criá-las e retorna-las. Promovem o reuso de código, utilizando funções menores e que já foram testadas.

Exemplo. cálculo da média do dobro dos números passados
```java
OptionalDouble avg = IntStream.of(4, 5, 6)
.map(x -> x*2) //higher-order function
.average();
```

**Composition**
 Na matemática, as funções são compostas/ligadas usando a saida de uma função como entrada para a próxima função. Mesma regra se aplica para *first-class functions* serem usadas pelas *higher-order functions*

 **Currying**

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

**Closure**

É uma tecnica para implementar o *lexical scoping*(permite nós acessarmos variáveis fora do contexto dentro do *inner scope*)

**Immutability**

Promover imutabilidade simplifica o código e permite que os desenvolvedores foquem no fluxo. O pior tipo de *side-effects* são os que mudam pouco em um ponto e produzem resultados catastróficos em outro(Efeito borboleta). São difícies de paralelizar e as vezes temos que trabalhar com *locks*.

**Functors**

Permitem aplicar funções dado o container. Eles sabem como *unwrap* o valor do *wrapped object*, aplicar a função e retornar um outro functor contendo o novo/transformado *wrapped object* como resultado. Ex de functors(Collections, futures(promises), e Optionals)

Exemplo, usando o Functor `Optional`, aplicando uma divisão em um Optional(5) vai retornar outro Optional(2,5)
```java
Optional<Float> a = Optional.of(5);
Optional<Float> b = a.map(x -> x/2);
b.get() ===> 2,5
```
**Applicatives**

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

**Monads**

aplica uma função que retorna um valor *wrapped* para um valor *wrapped*. Java tem exemplos como `Stream`, `CompletableFuture`, `Optional`.

Exemplo:
```java
Map<Integer, String> codesMapping = Map.of(400500, "Cluj-Napoca", 75001, "Paris", 10115, "Berlin", 10000, "New York");
List<Integer> codes = List.of(400501, 75001, 10115, 10000);
codes.stream().flatMap(x -> Stream.ofNullable(codesMapping.get(x))).collect(Collectors.toList()); //Paris, Berlin, New York
```
### Programação funcional no Java 8

**Lambda expressions**

são as funções para utilização que estão disponíveis no `java.util.functions` pacote de interfaces.

Interfaces funcionais: BiConsumer<T, U>, BiFunction<T, U, R>, BinaryOperator<T>, BiPredicate<T, U>, Consumer<T>, Function<T, R>

**Streams**

São uma pipeline de funções que tranformam, não mutam, os dados. eles possuem operações de crição, intermediárias e terminais. Para obter um valor de um Stream, deve-se chamar uma operação terminal. Eles não são estruturas de dados, eles não podem ser reusados, uma vez consumidos eles permanecem fechados. Se for chamado uma segunda vez é lançado `java.lang.IllegalStateException` 

* Operações de criação(Exemplos):
  * stream()
  * parallelStream()
  * generate()
  * of()
  * empty()
  * iterate()
  * concat()
  * range()
  * rangeClosed()

* Operações intermediárias:
  * sequential()
  * parallel()
  * unordered()
  * onClose()
  * filter()
  * map()
  * flatMap()
  * distinct()
  * sorted()
  * peek()
  * limit()
  * skip()

* Operações terminais:
  * iterator()
  * splititerator()
  * toArray()
  * collect()
  * findFirst()
  * findAny()
  * min()
  * max()
  * anyMatch()
  * allMatch()
  * noneMatch()
  * reduce()

### Functional Design Patterns

**MapReduce**

Usado para programação paralela massiva, desenvolvida pela Google, é uma forma de Monad.

Objetivo: Quebrar tasks e outras bem menores, executá-las em paralelo, e agregar o resultado(reduce).

**Loan**

Usado para liberar a aplicação de recursos que não serão mais utilizados. Geralmente são utilizados para liberar conexões de banco e etc.

**Tail Call Optimization**

Uma técnica utilizada por alguns compiladores para chamar uma função sem utilizar o *stack space*. Scala faz uso dessa técnica.

**Memoization**

Intenção é utilizar cache de funções puras para evitar o uso intensivo da CPU, assim tem mais rapidez e economizamos recurso.

## Programação Reativa

De acordo com o [Manifesto Reativo](https://www.reactivemanifesto.org/pt-BR), sistemas reativos possuem os seguintes atributos:
* **Responsivo**: O sistema responde em um tempo hábil se possível.
* **Resiliente**: O sistema continua respondendo em caso de falha.
* **Elástico**: O sistema continua responsivo mesmo sob variações de demanda.
* **Orientado a Mensagens**: Sistemas reativos usam passagem de mensagens assíncronas para estabelecer fronteiras entre componentes e garantir baixo acoplamento, isolamento, transparência na localização e provêem meios para delegar o tratamento de erros através de mensagens.

Paradigma de programação reativa de baseia em stream de dados assíncronos(asynchronous data streams). Programação Reativa é aplicada usando algumas abstrações, algumas do mundo funcional:
* Future/Promises: Uma maneira de agir nos valores que serão retornados em algum momento no futuro.
* Stream: é uma *data pipeline*, "é o trilho do trem que da suporte para o trem passar".
* Dataflow variables: esses são os resultados de funções aplicadas no stream.
* Throttling: Mecanismo usado em ambientes *real-time processing*, para regular a velocidade de *input*. É utilizado *back-pressure* como estratégia.
* Mecanismo de Push: Assim que a informação fica disponível a informação é passada(*pushed*) para os *Observers*, ao invés dos *Observers* ficarem consultando a fonte de dados(pull).

### RxJava

* Observables: Responsável por emitir os dados assim que disponível.
  * Hot: começa a emitir assim que possível mesmo que não possuir Subscribers ligados.
  * Cold: espera pelo menos um Subscriber se ligar antes de emitir dados. Também são chamados de *Connectable Observers* 
* Observer: Responsável por reagir/consumir e/ou transformar os dados disponíveis.

### Reactive Design Patterns

Patterns são focados nos 4 pontos da programação reativa

### Responsividade

**Request-response**

É um *core pattern*. O nosso serviço recebe uma requisição e retorna uma resposta.

**Asynchronous-communication**

Esse padrão faz com que a aplicação fique responsiva mesmo quando faz operações intensivas, como gerar relatórios, por exemplo. Imagine que gerar um relatório em tempo de execução é muito demorado e só pode ser feito no momento em que o usuário requisitar essa ação. Poderíamos tornar a geração e disponibilização do relatório assincrona, no momento da requisição enviando uma resposta que a requisição foi feita e que após de alguns minutos o relatório estará disponível via e-mail ou na tela de relatórios.

**Caching**

Outro padrão para garantir a responsividade é implementar sistema de cache, onde ele garante que requisições similares são respondidas mas rapidamente e sem utilizar processamento, já que ele é feito na primeira vez antes do sistema do cache gravar a informação. Ele pode ser implementado em diferentes níveis, controllers, services, repositories, clients. E até antes de chegar no serviço como em load-balancer

**Fan-out and quickest-reply**

Em aplicações em tempo real a velocidade em extremamente importante. Então podemos subir várias instâncias do mesmo serviço e quando recebermos a requisição enviar para todas as instências, ficamos com a resposta da instência que responder primeiro e descartâmos as outras respostas, isso tem uma desvantagem que é o custo de recursos, já que iremos consumir mais com mais instâncias em pé.

**Fail-fast**

Esse padrão fala sobre caso haja indisponibilidade nos serviços de terceiros(dependências) que a aplicação não fique esperando uma resposta por muito tempo, que ela já retorne um erro tratado para o usuário o mais rápido possível. Outro ponto que poderia melhorar a experiência é verificar se o serviço está disponível antes de iniciar o processo, se não tiver, já retorna o erro de indisponibilidade, falhar rápido contribui para experiência do usuário, mesmo sendo ruim retornar erros.

### Resiliência

**circuit-breaker**

Esse padrão se baseia no circuito elétrico, ao invês de deixar a falha propagar entre a chamada de serviços, implementando retentativas(em caso de instabilidade), e após esse número de tentativas não conseguir a resposta ele pode ir para um fallback ou avisar monitoração que a dependência se encontra disponível e parar de fazer chamadas para o serviço indisponível por um certo período de tempo, isso para ajudar o serviço instável a se recuperar e não ficar sofrendo um volume de requisições quando esta iniciando ainda.

**failure-handling**

Uma pergunta importante para manter a resiliência é se perguntar, se um serviço cair o sistema vai parar de funcionar? A ideia é que só componente que depende do serviço seja afetado, e que as outras funcionalidade continuem funcionando normalmente. E em caso de o usuário tentar utilizar o componente indisponível, podemos mostrar resultados utilizando cache das últimas pesquisas feitas, ou uma mensagem falando sobre a indisponibilidade e prazo para normalização do serviço.

**bounded-queue**

Um padrão onde controlamos o número de requisições que um serviço pode lidar, nessa abordagem os serviços devem lidar com as requisições utilizando uma fila(*queue*) de tamanho fixo assim o serviço vai executando essas requisições a partir do momento em que fica livre. O tamanho fixo serve para caso a fila fique cheia o serviço comece a recusar requisições para os serviços que o chamam, tem um gerenciamento melhor por parte do serviço que recebe as requsições, ele se torna mais resiliente

### Monitoramento

**Bulkhead**

É termo que foi pego dos navios de cargo, onde cada sessão é totalmente isolada uma da outra, assim se uma sessão for inundada ou pegar fogo não vai afetar as outras sessões do navio, isso se aplica um serviço ou grupo de serviços, se houver uma queda de um serviço ou grupos deles não deve deixar a aplicação totalmente indisponível. Para implementar esse padrão deve-se garantir que todos os serviços trabalhem de forma independente, e as falhas não serão propagadas, todos os padrões reativos descritos aqui ajudam a chegar nesse objetivo.

### Elasticidade

**Single responsibility**

Conhecido como *single-component* ou *microservice pattern*, mesma ideia do *single responsibility principle* da orientação á objetos, uma classe só deve possuir um único motivo para mudar. A mesma coisa se aplica a serviços e componentes.

**Stateless-services**

Para ter os serviços escaláveis eles devem ser construídos sem estados. Isso quer dizer que o serviço não guarda nenhum estado das chamadas anteriores, ele vai tratar todas as chamadas como se fossem novas. Para manter estado podemos guardar a sessão em um lugar compartilhado e acessível a todas as instâncias, como um banco. Só que é trabalhoso e ainda assim não escala rápido. A solução ideal pode utilizar para manter estado baseado em Token, como JWT.

**Autoscaling**

É mais um padrão baseado em deployment do que em desenvolvido. Existem dois tipos de Autoscaling. Vertical: Baseado em aumento de poder de uma máquina, é mais complexo e possui mais limites, e possui o horizontal, baseado em adicionar mais instâncias para compartilhar a carga. Pode utilizar gatilhos, como consumo de CPU/Memória, se ultrapassar o limite estipulado ele automaticamente cria uma outra instância.

**Self-containment**

Quer dizer que a aplicação ou serviço deve ser alto suficiente ou capaz de trabalhar sozinha, sem depender de outras dependências.

### Orientado a Mensagens


**Event-driven communication**

Quando dois ou mais componentes passam mensagem entre eles baseados em algum evento. Evento pode ser adicionar um novo registro, atualização, ou remover.

**Publisher-subscriber**

Pode ser pensado como uma extensão do *event-driven*. Imagine se multíplos componentes querem ler a mensagem? e se o mesmo componente quer ouvir vários tipos de mensagens? Isso é resolvido utilizando o conceito de tópico, podemos pensar em um evento como se fosse um tópico.

**Idempotency**

Quando miramos em *message-driven* e *asynchronous communication*, isso pode trazer alguns desafios. Por exemplo, imagine se uma mensagem duplicada é enviada, isso vai corromper o sistema? o que acontece com o estado daquele registro? Para evitar problemas como adicionar duas vezes a mesma quantia em dinheiro na conta de um cliente por exemplo, podemos utilizar algumas técnicas, como: 
* Colocar Ids únicos nas mensagens, para identificar o evento duplicado.
* Manter o estado anterior e o novo estado na mensagem(assim o sistema bate os dados que ele possui com o eviado na mensagem)


