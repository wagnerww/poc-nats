# POC NATS com Java e Docker

Este projeto é uma POC de integração de uma aplicação Java com NATS utilizando Docker Compose.

## Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- Docker e Docker Compose

## Passos para Executar

### 1. **Subir o Ambiente NATS com Docker Compose**

Execute o script `run.sh` para compilar o projeto, subir o ambiente Docker e preparar tudo para a POC:

```bash
sh ./run.sh
```

### 2. **Verificar o ambiente**
```bash
docker ps
```

### 3. **Publicar mensagem SYNC**
```bash
sh ./publish.sh
```

### **Limpeza do Ambiente**
```bash
cd sandbox && docker-compose down
```