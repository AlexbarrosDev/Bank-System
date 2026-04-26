# Bank System (Projeto de Estudo)

Projeto desenvolvido com foco em aprendizado de desenvolvimento back-end em Java, simulando operações bancárias básicas e aplicação de testes unitários.

---

## ⚠️ Status do projeto

Projeto em desenvolvimento para fins de estudo.

→ Funcionalidades ainda estão sendo implementadas
→ Algumas regras de negócio podem estar incompletas
→ Estrutura sujeita a melhorias conforme evolução do aprendizado

---

## Objetivo

→ Praticar orientação a objetos (OO)
→ Aplicar testes unitários de forma profissional
→ Simular regras de negócio reais
→ Evoluir na escrita de código limpo e organizado
→ Treinar uso de mocks em testes

---

## Tecnologias utilizadas

→ Java
→ Spring Boot
→ JUnit
→ Mockito

---

## Estrutura do projeto

```id="1e8x6g"
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── alexdev
│   │   │           ├── BankSystemApplication.java
│   │   │           ├── entities
│   │   │           │   ├── Account.java
│   │   │           │   ├── enums
│   │   │           │   │   └── TransactionalType.java
│   │   │           │   └── Transaction.java
│   │   │           ├── exceptions
│   │   │           │   ├── InsufficientBalanceException.java
│   │   │           │   └── InvalidAmountException.java
│   │   │           ├── repositories
│   │   │           │   └── AccountRepository.java
│   │   │           └── services
│   │   │               └── BankService.java
│   │   └── resources
│   │       ├── application.yaml
│   │       └── db
│   │           └── migration
│   └── test
│       └── java
│           └── com
│               └── alexdev
│                   ├── BankSystemApplicationTests.java
│                   ├── entities
│                   │   └── AccountTest.java
│                   └── services
│                       └── BankServiceTest.java
└── target
    ├── classes
    │   ├── application.yaml
    │   └── com
    │       └── alexdev
    │           ├── BankSystemApplication.class
    │           ├── entities
    │           │   ├── Account.class
    │           │   ├── enums
    │           │   │   └── TransactionalType.class
    │           │   └── Transaction.class
    │           ├── exceptions
    │           │   ├── InsufficientBalanceException.class
    │           │   └── InvalidAmountException.class
    │           ├── repositories
    │           │   └── AccountRepository.class
    │           └── services
    │               └── BankService.class
    ├── generated-sources
    │   └── annotations
    ├── generated-test-sources
    │   └── test-annotations
    └── test-classes
        └── com
            └── alexdev
                ├── BankSystemApplicationTests.class
                ├── entities
                │   └── AccountTest.class
                └── services
                    └── BankServiceTest.class

```

---

## Funcionalidades atuais

→ Criação de contas
→ Operações básicas (depósito, saque)
→ Validações simples de regras de negócio
→ Testes unitários para entidades e serviços

---

## Próximos passos (roadmap)

→ Melhorar validações de negócio
→ Aumentar cobertura de testes
→ Implementar tratamento de exceções mais robusto
→ Integrar com persistência (ex: banco de dados)

---

## Testes

O projeto possui testes unitários cobrindo:

→ Entidade Account
→ Serviço BankService

Foco dos testes:

→ Garantir regras de negócio
→ Evitar estados inválidos
→ Validar comportamento esperado

---

## Como executar o projeto

1. Clone o repositório:

```id="8mm01x"
git clone <URL_DO_REPOSITORIO>
```

2. Acesse a pasta do projeto:

```id="3vdb9q"
cd nome-do-projeto
```

3. Execute os testes:

```id="r7axlg"
./mvnw test
```

---

## Observações

Este não é um projeto finalizado ou pronto para produção.
O objetivo é demonstrar evolução técnica, organização de código e boas práticas.

---

## Autor

Desenvolvido por Alex Barros
