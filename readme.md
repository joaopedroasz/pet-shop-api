# **Pet Shop API:**

## Requirements and Use Cases:
 - [x] Create animals;
 - [x] Update amount of animal baths;
 - [x] Delete Animals;
 - [x] List all animals by ID or Name;

## Entities:

   ### Animal:
    - Id;
    - Name;
    - Tag;
    - totalOfBaths;
   
   ### Tag:
    - Id;
    - Name;

   ### Pet Shop:
    - Id;
    - Animals;
    - Description;

## To study:
 - Camadas da aplicação:
    - [x] Model, Controller, Service, Repository no Spring Boot;
    - [x] @Component in Spring Boot;
    - [x] DTO in Java;

## To do:
 - [x] Change from *OneToOne* to *OneToMany* in [Animals](./src/main/java/br/com/api/models/Animal.java);
 - [x] Abstract *controller* methods to a *service* layer; 
 - [x] Try to abstract the *controllers* further;
 - [x] Abstract the *controllers* answers to a *utils* layer;
 - [x] Register of Pet Shops;
 - [x] Add animals in Pet Shops;
 - [x] List animals per Pet Shop;
 - [x] Add field *price* in *Tag*;
    - [x] Return the price multiplied by the number of baths;