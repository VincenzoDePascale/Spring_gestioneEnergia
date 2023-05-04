# Backend per gestionale di fatturazione energetica B2B

Questo progetto è un Backend sviluppato in Java Spring Boot per un gestionale di fatturazione energetica b2b.
L'obiettivo è quello di gestire le entità come comune, indirizzo e cliente e le loro interazioni all'interno del sistema.

## API REST

L'API REST (Application Programming Interface Representational State Transfer) è un'interfaccia che permette al frontend di comunicare con il backend attraverso una serie di richieste HTTP. In questo caso, l'API REST permette di effettuare operazioni di lettura e scrittura sulle entità gestite dal sistema di fatturazione.

L'utilizzo dell'API REST consente una maggiore flessibilità e scalabilità dell'applicazione, poiché permette la separazione tra la logica di business e la presentazione dei dati.

## Entità gestite tramite API REST

Il sistema di fatturazione gestisce le seguenti entità:

- Comune: rappresenta un comune e contiene informazioni quali nome, codice postale e provincia.
- Indirizzo: rappresenta un indirizzo e contiene informazioni quali via, civico, comune e cliente.
- Cliente: rappresenta un cliente e contiene informazioni anagrafiche.
- Fatture: rappresenta l'entita di fatturazione con relativo stato e anagrafica annessa
- Province: contiene sigla, nome e regione di appartenenza

I clienti possono avere più indirizzi e più fatture associate.

## Documentazione API

La documentazione dell'API è disponibile all'indirizzo "localhost:8080/v3/api-docs". La documentazione è in formato JSON e può essere facilmente visualizzata su Postman.

## CSV IMPORT

E' possibile importare dei CSV contenenti i Comuni o le Province, consulta le API-DOCS all'endpoint "/api/csv"