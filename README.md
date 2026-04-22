# 🧪 LabManager API — Gerenciamento de Laboratórios

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)

Este projeto é uma **API RESTful** robusta desenvolvida para automatizar o controle, agendamento e alocação de laboratórios em instituições de ensino. O sistema resolve o problema crítico de conflitos de horários, garantindo que a infraestrutura acadêmica seja utilizada de forma eficiente.

---

## 🚀 Tecnologias e Ferramentas

Para este projeto, utilizei uma stack moderna focada em performance e produtividade:

* **Linguagem:** Java 21 (LTS)
* **Framework:** Spring Boot 3.4+
* **Persistência:** Spring Data JPA
* **Banco de Dados:** H2 Database (em memória para desenvolvimento ágil)
* **Documentação:** Swagger UI (SpringDoc OpenAPI)
* **Produtividade:** Lombok (Clean Code)

---

## 🏗️ Arquitetura do Sistema

O projeto foi estruturado seguindo o padrão de **Camadas**, garantindo uma separação clara de responsabilidades e facilitando a manutenção futura:

1.  **`Domain` (Entidades):** Mapeamento objeto-relacional das tabelas `Usuario`, `Laboratorio` e `Reserva`.
2.  **`Repositories`:** Interfaces de persistência com métodos de consulta customizados (Ex: busca por e-mail e ID de laboratório).
3.  **`Services`:** Camada de inteligência onde residem as **Regras de Negócio**, como a validação de capacidade e o algoritmo de intersecção de horários.
4.  **`Controllers`:** Exposição dos endpoints REST para integração com front-end ou mobile.

---

## 💡 Funcionalidades Principais

* **[✅] Cadastro de Usuários:** Gestão de perfis com segurança e validação de e-mail único.
* **[✅] Gestão de Laboratórios:** Monitoramento de status (Ativo/Manutenção) e controle de capacidade máxima.
* **[✅] Reservas Inteligentes:**
    * **Bloqueio de Conflitos:** Algoritmo que impede que o mesmo laboratório seja reservado por usuários diferentes no mesmo intervalo de tempo.
    * **Validação Cronológica:** Impede reservas com data de fim anterior à data de início.
    * **Verificação de Disponibilidade:** Apenas laboratórios com status "ATIVO" permitem novas reservas.

---

## 🛠️ Como Executar

Se você deseja testar o projeto localmente:

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/luisveras-dev/gerenciamento-labs-spring.git](https://github.com/luisveras-dev/gerenciamento-labs-spring.git)
    ```
2.  **Importe no seu IDE** (IntelliJ IDEA, Eclipse ou VS Code).
3.  **Execute a aplicação** através da classe `GerenciamentolabsApplication.java`.
4.  **Explore a API:** Com o projeto rodando, acesse o link abaixo para ver a documentação interativa:
    > `http://localhost:8080/swagger-ui.html`

---

## 👨‍💻 Autor

**Luis Veras**
* Graduando em Ciência da Computação — UNIMA (Maceió-AL)
* Foco: Desenvolvimento Backend (Java / Python)
* [LinkedIn](https://www.linkedin.com/in/seu-perfil) | [GitHub](https://github.com/luisveras-dev)

---
*Projeto desenvolvido com foco em Clean Code e Organização Técnica.*
