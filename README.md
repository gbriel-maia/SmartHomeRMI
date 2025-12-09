# Smart Home RMI
Cliente MQTT para controle e monitoramento de dispositivos inteligentes através de uma arquitetura distribuída.

## Funcionamento
O projeto implementa um sistema de comunicação entre cliente e servidor usando duas abordagens complementares:

### RMI (Remote Method Invocation)
- Estabelece conexão remota entre cliente e servidor
- Permite chamar métodos do servidor como se fossem locais
- Facilita a execução de operações complexas no servidor

### MQTT (Message Queuing Telemetry Transport)
- Protocolo leve de publicação/subscrição
- Cliente se conecta ao broker MQTT para trocar mensagens
- Publica comandos para controlar dispositivos
- Subscreve a tópicos para receber dados dos sensores em tempo real

## Fluxo de Operação
1. **Inicialização**: Cliente RMI se conecta ao servidor RMI
2. **Comunicação MQTT**: Cliente estabelece conexão com o broker MQTT
3. **Controle**: Envia mensagens para controlar dispositivos inteligentes
4. **Monitoramento**: Recebe atualizações em tempo real dos sensores

## Tecnologias
- **Java**: Linguagem principal
- **MQTT**: Protocolo de mensageria
- **RMI**: Invocação remota de métodos
- **Maven**: Gerenciador de dependências
