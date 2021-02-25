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
    - [x] @Component no Spring Boot;
    - [x] DTO no Java;

## Para implementar:
 - [x] Mudar de *OneToOne* para *OneToMany* em [Animals](./src/main/java/br/com/api/models/Animal.java)
 - [x] Abstrair métodos dos *controllers* para uma camada de *service*. 
 - [x] Tentar abstrair ainda mais os *controllers*;
 - [x] Abstrair a reposta dos *controllers*;
 - [x] Cadastro de lojas de Pet Shops;
 - [x] Adicionar animais em PetShops;
 - [x] Listar os animais de cada loja;
 - [x] Adicionar um campo **preço** em *TAG*;
    - [x] Retornar o preço multiplicado pela quantidade de banhos;