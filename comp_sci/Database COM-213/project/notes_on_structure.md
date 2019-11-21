# Vending Machine

## Customer

- date of birth
- email-reference
- payment info reference
- phone number
- number verified

## Machine

- Owner ID
- Name <50 char
- Maker
- ID
- Address FK
- unique qr code
- product capacity
- status message

## Bank

- name
- connection string

## Machine Owner

- ID
- Name

## Prices

- machine
- product type
- currency from machine address
- amount
- datefrom NOT NULL
- dateto

## Currencies

- name
- ID

## Machine Address

- country
- city
- street
- number
- gps
- local currency
- additional info

## Payment Cards

- number
- bank
- cvc
- expiration date

## Email address

- user id
- address

## Product Category - Sandwich etc

- Name
- Description

## Product Type and Brand- Coca Cola

- Category
- Name
- brand
- Description
- picture

## categories to types

## Brands

- name
- id
- info

## Product Instance - particular bottle of coca cola

- product type
- supplier info
- unique id
- expiration date

## Supplier

- name
- id

## Purchases

- user id
- machine id
- products
- price of each product at the time of purchase
- sum total
- date and time
- payment reference

## payment

- amount owed
- paid / not paid
- chosen payment card

