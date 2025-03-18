# MKS-Bolos
Um sistema em Java de gerenciamentos de dados de uma casa de bolos.


```
                                      * 
         *                                             * 
                                              * 
                   * 
                                 * 
                                                           * 
        * 
                                                 * 
            * 
                          *             * 
                                                    * 
     *                                                               * 
              * 
                              (             ) 
                      )      (*)           (*)      ( 
             *       (*)      |             |      (*) 
                      |      |~|           |~|      |          * 
                     |~|     | |           | |     |~| 
                     | |     | |           | |     | | 
                    ,| |a@@@@| |@@@@@@@@@@@| |@@@@a| |. 
               .,a@@@| |@@@@@| |@@@@@@@@@@@| |@@@@@| |@@@@a,. 
             ,a@@@@@@| |@@@@@@@@@@@@.@@@@@@@@@@@@@@| |@@@@@@@a, 
            a@@@@@@@@@@@@@@@@@@@@@' . `@@@@@@@@@@@@@@@@@@@@@@@@a 
            ;`@@@@@@@@@@@@@@@@@@'   .   `@@@@@@@@@@@@@@@@@@@@@'; 
            ;@@@`@@@@@@@@@@@@@'     .     `@@@@@@@@@@@@@@@@'@@@; 
            ;@@@;,.aaaaaaaaaa       .       aaaaa,,aaaaaaa,;@@@; 
            ;;@;;;;@@@@@@@@;@      @.@      ;@@@;;;@@@@@@;;;;@@; 
            ;;;;;;;@@@@;@@;;@    @@ . @@    ;;@;;;;@@;@@@;;;;;;; 
            ;;;;;;;;@@;;;;;;;  @@   .   @@  ;;;;;;;;;;;@@;;;;@;; 
            ;;;;;;;;;;;;;;;;;@@     .     @@;;;;;;;;;;;;;;;;@@a; 
        ,%%%;;;;;;;;@;;;;;;;;       .       ;;;;;;;;;;;;;;;;@@;;%%%, 
     .%%%%%%;;;;;;;a@;;;;;;;;     ,%%%,     ;;;;;;;;;;;;;;;;;;;;%%%%%%, 
    .%%%%%%%;;;;;;;@@;;;;;;;;   ,%%%%%%%,   ;;;;;;;;;;;;;;;;;;;;%%%%%%%, 
    %%%%%%%%`;;;;;;;;;;;;;;;;  %%%%%%%%%%%  ;;;;;;;;;;;;;;;;;;;'%%%%%%%% 
    %%%%%%%%%%%%`;;;;;;;;;;;;,%%%%%%%%%%%%%,;;;;;;;;;;;;;;;'%%%%%%%%%%%% 
    `%%%%%%%%%%%%%%%%%,,,,,,,%%%%%%%%%%%%%%%,,,,,,,%%%%%%%%%%%%%%%%%%%%' 
      `%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%' 
          `%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%' 
                 """"""""""""""`,,,,,,,,,'""""""""""""""""" 
                                `%%%%%%%' 
                                 `%%%%%' 
                                   %%% 
                                  %%%%% 
                               .,%%%%%%%,. 
                          ,%%%%%%%%%%%%%%%%%%%, 
              ---------------------------------------------
```

## Requisitos
- JDK 23.0.1
- inntelij IDEA
- MySQL
- MySQL Workbench 8.0

## Como executar?
### Criação do banco de dados
Acesse a pasta [dataBase](/dataBase). Nessa pasta você encontrará um arquivo [dataBaseJmxBolos](/dataBase/dataBaseJmxBolos.sql), esse arquivo contém as 
especifícações necessárias para o banco de dados que será usado no programa. 
Abra o arquivo dataBaseJmxBolos no MySQL Workbench e execute o script. Agora você já deve ter a base de dados pronta para se usada.

### Configurações de conexão ao banco de dados
Acessando a pasta [src/dataBase](src/dataBase) você encontrará um arquivo de conexão do tipo java. Abra esse arquivo e modifique a seguinte linha
```java
private static final String PASSWORD = ""; // Insira sua senha do MySQL aqui
```
Colocando sua senha de banco de dados MySQL dentro das aspas(" ")