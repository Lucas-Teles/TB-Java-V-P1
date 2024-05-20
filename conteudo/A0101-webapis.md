# WEB APIs

## Índice
- [API X Web APIs](#api-x-web-api)
    - [API](#apis)
    - [Web API](#web-api)
    - [Comparação](#comparação)
- [Consumindo Web APIs](#consumindo-web-apis)
    - [Ferramentas ](#ferramentas-para-consumir-apis)

### API X Web API

> 📝 **TL;DR** 
*API* é um termo genérico que se refere a qualquer interface que permite a comunicação entre diferentes partes de um software ou entre diferentes sistemas. 
*Web API* é um tipo específico de API projetada para ser acessível via web, utilizando a infraestrutura da web para permitir a comunicação entre clientes (como navegadores web, aplicativos móveis) e servidores.

#### API
Uma API é um conjunto de regras e definições que permitem que uma aplicação ou serviço interaja com outras aplicações ou serviços. As APIs facilitam a comunicação entre diferentes partes de um software ou entre diferentes softwares.

- **Contexto de Uso:** APIs podem ser usadas em diversos contextos, não apenas na web. Elas são amplamente utilizadas em sistemas operacionais, bibliotecas de software, frameworks e dispositivos de hardware.

- **Meios de Comunicação:** A comunicação pode ocorrer de várias maneiras, incluindo chamadas de função, trocas de mensagens, chamadas de sistema operacional, etc.

- **Exemplos:**
    - APIs de bibliotecas gráficas como OpenGL.
    - APIs de sistemas operacionais como Windows API.
    - APIs de bibliotecas de machine learning como TensorFlow.

#### Web API
Uma Web API é um tipo específico de API que é acessível via protocolos da web, como HTTP ou SOAP. Elas permitem que aplicações se comuniquem através da internet.

- **Contexto de Uso:** Web APIs são especificamente projetadas para serem usadas na web, facilitando a interação entre diferentes sistemas através da internet.

- **Meios de Comunicação:** A comunicação é feita através de requisições HTTP/HTTPS. As respostas são frequentemente no formato JSON ou XML.

- **Exemplos:**
    - RESTful APIs: APIs que seguem o estilo arquitetural REST (Representational State Transfer).
    - SOAP APIs: APIs que utilizam o protocolo SOAP (Simple Object Access Protocol).
    - GraphQL APIs: APIs que utilizam a linguagem de consulta GraphQL.


#### Comparação

| Característica            | API                             | Web API                          |
|---------------------------|---------------------------------|----------------------------------|
| **Definição**             | Interface para comunicação entre softwares. | Interface baseada na web para comunicação via HTTP/HTTPS. |
| **Contexto de Uso**       | Diversos (SO, bibliotecas, frameworks, etc.) | Especificamente na web (internet). |
| **Meios de Comunicação**  | Chamadas de função, mensagens, chamadas de sistema, etc. | Requisições HTTP/HTTPS. |
| **Formatos de Resposta**  | Vários, dependendo do contexto (binário, texto, etc.) | Principalmente JSON ou XML. |
| **Exemplos**              | Windows API, OpenGL, TensorFlow. | RESTful APIs, SOAP APIs, GraphQL APIs. |

### Consumindo APIs
Consumir uma API envolve fazer solicitações a esses endpoints e processar as respostas recebidas. Esse processo pode ser realizado em diversas linguagens de programação e usando várias ferramentas.

#### Ferramentas para consumir APIs
- **Insomnia/Postman:** Ferramentas de teste de APIs que permitem enviar solicitações HTTP e ver as respostas.
- **Curl:** Utilitário de linha de comando para transferir dados de ou para um servidor.
- **Bibliotecas/Frameworks:** Muitas linguagens de programação possuem bibliotecas/frameworks para facilitar o consumo de APIs (fetch em JavaScript, HttpURLConnection no Java ou frameworks como Spring RestTemplate).

**Exemplo com Curl**
```sh
curl https://api.coindesk.com/v1/bpi/currentprice.json
```

---
**Exemplo com JavaScript**
muito usado no front-end

```js
// Consumindo a API pública do CoinDesk para obter o preço do Bitcoin
fetch('https://api.coindesk.com/v1/bpi/currentprice.json')
  .then(response => response.json())
  .then(data => {
    console.log(`O preço atual do Bitcoin é ${data.bpi.USD.rate}`);
  })
  .catch(error => {
    console.error('Erro ao consumir a API:', error);
  });
```
---
**Exemplo com Java Puro**

```java
public class BitcoinPrice {

    public static void main(String[] args) {
        try {
            // URL da API do CoinDesk
            URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");

            // Abrir conexão HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Ler a resposta da API
            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            // Extrair o preço do Bitcoin da resposta JSON
            String jsonResponse = response.toString();
            String price = extractBitcoinPrice(jsonResponse);

            // Imprimir o preço do Bitcoin
            System.out.println("O preço atual do Bitcoin é " + price);

            // Fechar a conexão
            connection.disconnect();
        } catch (IOException e) {
            System.err.println("Erro ao consumir a API: " + e.getMessage());
        }
    }

    // Método para extrair o preço do Bitcoin da resposta JSON
    private static String extractBitcoinPrice(String jsonResponse) {
        return jsonResponse.split("\"rate\":\"")[1].split("\"")[0];
    }

```
---
**Exemplo com Spring**
vamos aprender nas proximas aulas
```java

@SpringBootApplication
@RestController
public class BitcoinPrice {

    public static void main(String[] args) {
        SpringApplication.run(BitcoinPrice.class, args);
    }

    @GetMapping("/bitcoin-price")
    public String getBitcoinPrice() {
        // Fazer a chamada GET para a API do CoinDesk
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        String jsonResponse = new RestTemplate().getForObject(url, String.class);

        // Extrair o preço do Bitcoin da resposta JSON
        String price = jsonResponse.split("\"rate\":\"")[1].split("\"")[0];

        // Retornar o preço do Bitcoin
        return "O preço atual do Bitcoin é " + price;
    }
}
```

### Pra testar
Aqui estão algumas APIs gratuitas e úteis no nosso curso:


**CoinDesk API**
- URL: https://api.coindesk.com/v1/bpi/currentprice.json
- Descrição: Fornece o preço atual do Bitcoin em várias moedas.

```sh
curl https://api.coindesk.com/v1/bpi/currentprice.json
```
**ExchangeRate-API**
- URL: https://open.er-api.com/v6/latest/USD
- Descrição: Fornece taxas de câmbio de várias moedas em relação ao dólar americano.

```sh
curl https://open.er-api.com/v6/latest/USD
```

**Open Movie Database (OMDb) API**
- URL: http://www.omdbapi.com/?s=Batman
- Descrição: Retorna informações sobre filmes, como títulos, anos de lançamento e mais detalhes. (Nota: A API requer uma chave de API gratuita, mas você pode encontrar endpoints de teste que não exigem autenticação)

```sh
curl http://www.omdbapi.com/?s=Batman
```

**Studio Ghibli API**
- URL: https://ghibliapi.herokuapp.com/films
- Descrição: Fornece informações sobre filmes do Studio Ghibli.

```sh
curl https://ghibliapi.herokuapp.com/films
```

**TVMaze API**
- URL: https://api.tvmaze.com/search/shows?q=girls
- Descrição: Retorna informações sobre programas de TV, como títulos, sinopses e horários de exibição.

```sh
curl https://api.tvmaze.com/search/shows?q=girls
```