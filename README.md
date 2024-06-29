# Desafio projeto Reactor

Para começarmos a nos habituar com programação reativa criamos esse projeto com 3 desafios para serem solucionados utilizando o Project Reactor, cada desafio está localizado em uma classe diferente e cada classe tem testes unitários para ficar fácil de acompanhar se seu código está no caminho certo, os desafios são os seguintes:

* **Question 1**: Recebe uma lista de longs, incrementa 1 nos valores e retorna um flux dos resultados;

* **Question 2**: Recebe uma lista de usuários e retorna a quantos usuários admin tem na lista;

* **Question 3**: Verifica se o usuário passado é valido, caso seja retorna void, caso contrário deve disparar uma exception
    (para esse desafio vamos considerar que o usário é valido quando ele tem uma senha com mais de 8 caractéres).

Para fazer a verificação usando os testes rode o comando *gradle test* ( considerando que você tenha o gradle instalado em seu computador)

## RESULTADO APÓS CONCLUSÃO DO DESAFIO

## Desafio Projeto Reactor

Este projeto foi desenvolvido como parte do curso de Programação Reativa com Reactor. O objetivo é resolver três desafios utilizando o Project Reactor, com testes unitários para validar as soluções.

## Estrutura do Projeto

desafio-reactor-master
├── .gradle
├── .idea
├── bin
├── build
├── gradle
├── src
│ ├── main
│ │ └── java
│ │ └── br
│ │ └── com
│ │ └── dio
│ │ └── desafioreactor
│ │ ├── Question1.java
│ │ ├── Question2.java
│ │ ├── Question3.java
│ │ └── User.java
│ ├── test
│ └── java
│ └── br
│ └── com
│ └── dio
│ └── desafioreactor
│ ├── Question1Test.java
│ ├── Question2Test.java
│ └── Question3Test.java
├── build.gradle
├── gradlew
├── gradlew.bat
└── README.md

## Desafios

### Question 1

**Objetivo:** Receber uma lista de números longos, incrementar 1 em cada valor e retornar um Flux dos resultados.

    import reactor.core.publisher.Flux;
    import java.util.List;

    public class Question1 {
        public Flux<Long> inc(List<Long> numbers) {
            return Flux.fromIterable(numbers)
                    .map(number -> number + 1);
        }
    }

### Question 2

**Objetivo:** Receber uma lista de usuários e retornar quantos usuários são administradores.

    import reactor.core.publisher.Flux;
    import reactor.core.publisher.Mono;
    import java.util.List;

    public class Question2 {
        public Mono<Long> countAdmins(List<User> users) {
            return Flux.fromIterable(users)
                    .filter(User::isAdmin)
                    .count();
        }
    }

**Question 3:** Objetivo: Verificar se o usuário é válido (senha com mais de 8 caracteres), caso seja válido, retorna void, caso contrário, dispara uma exceção.

    import reactor.core.publisher.Mono;

    public class Question3 {
        public Mono<Void> userIsValid(User user) {
            return Mono.just(user)
                    .flatMap(u -> {
                        if (u.getPassword().length() > 8) {
                            return Mono.empty();
                        } else {
                            return Mono.error(new IllegalArgumentException("Invalid user"));
                        }
                    });
        }
    }

**User:** Classe de Usuário

    public class User {
        private long id;
        private String name;
        private String email;
        private String password;
        private boolean admin;

        public User(long id, String name, String email, String password, boolean admin) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
            this.admin = admin;
        }

        public boolean isAdmin() {
            return admin;
        }

        public String getPassword() {
            return password;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

## Execução dos Testes

Para executar os testes, siga os passos abaixo:

**Usando Gradle:**

    1. Navegar para o Diretório do Projeto:
    cd L:\VSCode\JAVA\DIO\desafio-reactor-master

    2.Executar os Testes:
    gradle test

**Usando o Gradle Wrapper:**

Se o projeto inclui o Gradle Wrapper (gradlew), você pode usar o wrapper para executar os testes:

    1.Windows:

    .\gradlew test

## Detalhamento da Saída do Gradle

Ao executar os testes, você verá uma saída semelhante a esta:

    Welcome to Gradle 7.4!

    Here are the highlights of this release:

        - Aggregated test and JaCoCo reports
        - Marking additional test source directories as tests in IntelliJ
        - Support for Adoptium JDKs in Java toolchains

    For more details see [https://docs.gradle.org/7.4/release-notes.html]

    > Task :compileTestJava

    Note: Some input files use or override a deprecated API.
    Note: Recompile with -Xlint:deprecation for details.

    BUILD SUCCESSFUL in 10s
    3 actionable tasks: 3 executed

**Explicação:**

    Boas-vindas ao Gradle 7.4:
        A mensagem inicial mostra que você está usando o Gradle 7.4 e destaca algumas das novas funcionalidades dessa versão.
        Inclui um link para as notas de lançamento para mais detalhes.

    Compilação dos Testes:
        > Task :compileTestJava: Indica que a tarefa de compilação dos arquivos de teste foi executada.
        A nota sobre o uso ou substituição de uma API depreciada sugere recompilar com a opção -Xlint:deprecation para obter mais detalhes. Isso é apenas uma advertência, não um erro.

    BUILD SUCCESSFUL:
        Confirma que todas as tarefas foram concluídas com sucesso.
        3 actionable tasks: 3 executed: Significa que três tarefas foram executadas durante a construção.

**Verificando Resultados dos Testes:**

Os relatórios de teste são gerados no diretório build/reports/tests/test do seu projeto. Você pode verificar esses relatórios para ver os resultados detalhados.
