Restaurant sample restful web service application.

## usage
curl -X POST localhost:3001/api/restaurants -H "content-type:application/json" -d '{"name":"candc","rating":"5","country":"Finland"}'

## response
{
  "name": "candc",
  "rating": "5",
  "country": "Finland"
}

## query a restaurant
curl localhost:3001/api/restaurants/candc

## response
{
  "name": "candc"
}

# Query all restaurants

curl localhost:3001/api/restaurants

## response
[
  {
    "name": "candc"
  }
]