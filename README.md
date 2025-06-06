
# 💱 Conversor de Moedas

Projeto de conversor de moedas desenvolvido em Java, utilizando a **ExchangeRate API** para obter cotações em tempo real. Ideal para praticar consumo de APIs, manipulação de JSON com Gson e criação de menus interativos no console ou interface gráfica com Swing.

## 📸 Demonstração

![Demonstração CLI](https://img.shields.io/badge/Modo-Console-blue)
![Demonstração GUI](https://img.shields.io/badge/Modo-Interface--Gráfica-green)

> Modo console:
```
=== Conversor de Moedas ===
1 - Real para Dólar
2 - Real para Euro
...
Digite o valor a converter: 100
Valor convertido: 18.75 USD
```

---

## 🚀 Funcionalidades

- ✅ Conversão em tempo real entre moedas
- ✅ Integração com a [ExchangeRate API](https://www.exchangerate-api.com/)
- ✅ Leitura e parsing de JSON com Gson
- ✅ Interface via console e GUI com Swing
- ✅ Tratamento de erros de API

---

## 🔧 Tecnologias utilizadas

- Java 17+
- Java HttpClient
- Gson (Google JSON library)
- ExchangeRate API
- Swing (interface gráfica)

---

## 🧠 Como funciona?

1. O usuário escolhe a moeda de origem, destino e valor.
2. A API retorna a taxa de câmbio.
3. O valor convertido é calculado e exibido.

---

> 📌 Lembre-se de baixar a biblioteca [Gson](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/) e adicioná-la ao classpath.

---

## 🔑 Obtenha sua API Key

1. Cadastre-se em [https://www.exchangerate-api.com](https://www.exchangerate-api.com)
2. Copie sua chave
3. Atualize a classe `Key`:

```java
public class Key {
    public static String getMyApiKey() {
        return "SUA_API_KEY_AQUI";
    }
}
```

---

## 🧪 Testes com Postman

Exemplo de requisição no Postman ou navegador:

```
GET https://v6.exchangerate-api.com/v6/SUA_API_KEY/pair/BRL/USD/100
```

---

## 🌍 Moedas disponíveis

- 🇧🇷 BRL - Real brasileiro  
- 🇺🇸 USD - Dólar americano  
- 🇪🇺 EUR - Euro  
- 🇬🇧 GBP - Libra esterlina  
- 🇦🇷 ARS - Peso argentino  
- 🇨🇱 CLP - Peso chileno  

---


## 📄 Licença

Este projeto está licenciado sob a Licença MIT.

---

Feito com 💙 por [Márcia Escolástico da Silva](https://www.linkedin.com/in/marcia-escolastico/)
