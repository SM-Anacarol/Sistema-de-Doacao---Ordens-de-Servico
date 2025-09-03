# 🛠 Sistema de Doação – Ordens de Serviço

![Java](https://img.shields.io/badge/Java-17+-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-brightgreen)
![H2 Database](https://img.shields.io/badge/H2-Database-orange)
![License](https://img.shields.io/badge/License-MIT-blue)

O **Sistema de Doação – Ordens de Serviço** é uma aplicação desenvolvida com **Spring Boot**, que tem como objetivo facilitar o gerenciamento de doações e serviços relacionados.  
Ele foi criado pensando em pequenas instituições, ONGs ou empresas que precisam organizar de forma prática e eficiente o fluxo de atendimento, controle de clientes, técnicos responsáveis e ordens de serviço.  

Este projeto combina uma **API REST robusta** com uma **interface web estática**, permitindo que usuários interajam de forma intuitiva com o sistema, realizando cadastros, consultas e atualizações de informações sem complicações.  
Além disso, utiliza um banco de dados em memória (H2), garantindo que seja fácil de configurar e rodar localmente, sem a necessidade de instalações complexas.

Entre os principais objetivos do projeto, destacam-se:

- **Gerenciamento de Clientes**: possibilita cadastrar, consultar e organizar informações de todos os clientes atendidos.  
- **Controle de Técnicos**: permite cadastrar e acompanhar os profissionais responsáveis pelas ordens de serviço.  
- **Ordens de Serviço**: facilita o registro, acompanhamento e atualização do status de cada serviço realizado.  
- **Interface Intuitiva**: página web estática que consome a API, permitindo operação simples e rápida mesmo para usuários sem conhecimento técnico avançado.  
- **Facilidade de Estudos**: ideal para quem deseja aprender sobre Spring Boot, JPA, H2 e desenvolvimento de APIs REST.

---

## 📌 Tecnologias

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (em memória)
- **API REST**
- **Frontend estático** (HTML/JS)

---

## 🚀 Como Rodar

### Windows (PowerShell)
```powershell
mvnw.cmd spring-boot:run
