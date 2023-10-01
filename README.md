# Wex Project - Convert Amount to Other Currencies
This project is a challenge proposed by Wex company. The main goal is to create an order and convert the amount, which is in dollars, to other currencies from other countries. I used an external API to get different currency rates to convert the amount.<br><br>
Treasury Reporting Rates of Exchange: **https://fiscaldata.treasury.gov/datasets/treasury-reporting-rates-exchange/treasury-reporting-rates-of-exchange**

Language: Java <br>
Framework: Spring <br>
Test: JUnit 5, Mockito
Architecture: Hexagonal <br>
Communication: REST <br>

### API's Enpoints

#### Create an order

```http
  POST /v1/order
```
**RequestBody**

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `amount` | `double` | [NotNull] |
| `description` | `string` | [Max 50 caracters] |
| `transactionDate` | `LocalDate` | [Pattern "yyyy/MM/dd"] |

#### Return an order by Id

```http
  GET /v1/order/{id}
```
**PathParameter**
| Parameter   | Type       | Description                           |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` | *Required* |

#### Return converted amount by Order's Id

```http
  GET /v1/conversion/{id}
```
**PathParameter**
| Parameter   | Type       | Description                           |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` | *Required* |

#### Return converted amount by Order's Id and Country

```http
  GET /v1/conversion/{id}
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` PathParam | *Required* |
| `country`      | `String` QueryParam | *Required*. Name of the country |


