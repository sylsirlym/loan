# Digital Lending
This a digital lending application
Fetch Offers Service
GET: http://<host>:8080/v1/loans/offer/{msisdn} - Use 254707123456

# Sample Response:

```json
{
    "statusCode": 200,
    "statusMessage": "Successfully completed request",
    "result": [
        {
            "loanOfferID": 1,
            "loanProductName": "Product A",
            "loanAmount": "12000.0",
            "interest": "10 %",
            "tenure": "15 Days"
        },
        {
            "loanOfferID": 2,
            "loanProductName": "Product B",
            "loanAmount": "20000.0",
            "interest": "13 %",
            "tenure": "30 Days"
        }
    ]
}
```

Loan Request Service
POST: http://localhost:8080/v1/loans/request
# Sample Request:
```json
{
    "loanOfferID":1,
    "principle":5001.00
}
```

# Sample Response:
```json
{
  "statusCode": 200,
  "statusMessage": "Successfully completed request",
  "result": {
    "loanName": "Product A",
    "principal": 5001.0,
    "loanStatus": "Disbursed",
    "loanDate": 1639233594627
  }
}
```
