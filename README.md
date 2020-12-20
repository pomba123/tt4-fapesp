# Seleção Bolsista FAPESP
# Projeto: Um Estudo sobre o Impacto de Anotações de Código na Evolução de Software

Exercício Sobre Reflexão


Resumo da atividade:
* Criar e implementar a classe AnnotationReader
* Criar a anotação @NumberToSum

# Sobre a Solução

Para solução do problema foram utilizadas as classes Method e Field do pacote java.lang.reflect e Annotation do pacote java.lang.annotation.
* Atributos
  * private Class c - recebe Class<?> clazz passado como argumento no método construtor.
  * private Annotation[] ant - recebe as anotacoes contidas em uma classe Class
  * private Method[] methods - recebe os métodos contidos em uma classe Class
  * private Field[] fields - recebe os atributos contidos em uma classe Class
  * private NumberToSum num; - serve para armazenar temporariamente uma Annotation do tipo NumberToSum 
  * private int soma; - armazena a soma de todas as Annottions do tipo NumberToSum em uma classe Class
* Métodos
  * Método construtor (AnnotationReader(Class<?> clazz)) - Nela são inicializadas a soma total (0) e uma instância de Class, que será utilizada para ler os métodos e atributos das classes de exemplo.
  * Método readAnnotations() - São estraídos do objeto Class<?> clazz os métodos e atributos, através dos métodos getDeclaredMethods() e getDeclaredFields() da classe Class.
  * Método getTotalSum() - Neste método são percorridos os métodos e atributos exraídos a partir do método readAnnotations(), enquanto os valores de cada Annotation do tipo @NumberToSum(int n) é acumulado no atributo soma da classe AnnotationReader;
  
# Executando.
  
  Basta executar, no terminal,
  
  ```
    git clone https://github.com/pomba123/tt4-fapesp.git
    cd tt4-fapesp
    mvn package  
  ```
