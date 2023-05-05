# Backend per gestionale di fatturazione energetica B2B

Questo progetto è un Backend sviluppato in Java Spring Boot per un gestionale di fatturazione energetica b2b.
L'obiettivo è quello di gestire le entità come comune, indirizzo e cliente e le loro interazioni all'interno del sistema.

## API REST

L'API REST (Application Programming Interface Representational State Transfer) è un'interfaccia che permette al frontend di comunicare con il backend attraverso una serie di richieste HTTP.

In questo caso, l'API REST permette di effettuare operazioni di lettura e scrittura sulle entità gestite dal sistema di fatturazione.

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

La documentazione dell'API è disponibile all'indirizzo "localhost:8080/v3/api-docs".

Richiede l'autenticazione tramite Token JWT, vedi la sezione LOGIN/REGISTER.

La documentazione è in formato JSON e può essere facilmente visualizzata su Postman.

## LOGIN/REGISTER

Endpoint Login: POST /api/auth/signin

Accetta un body in formato JSON con username e password.

Endpoing Register: POST /api/auth/register

Accetta un body in formato JSON con username, password, name, surname, email, roles.

Tutti i campi sono in formato String, ad eccezione dei ROLES che sono un array di stringhe.

I ruoli disponibili sono "ROLE_ADMIN" e "ROLE_USER".

## Installazione di base veloce:

Importare il DB da DUMPDB.sql contenuto in 'src/main/resources/static'

Settare il file application.properties in base alle necessità, a partire da application.properties.template

## Installazione Manuale:

Eseguire in ordine i seguenti passaggi:

- CREARE UN DB su Postgres o MySql

- Settare il file application.properties in base alle necessità, a partire da application.properties.template

- Avviare il programma SpringBoot (che creerà le entità di default sul DB)

- Eseguire una volta la funzione 'setRoleDefault();' dal Runner (scommentare e riavviare e successivamente ricommentare)

- Eseguire la registrazione come ADMIN tramite l'endpoint (vedi login/register)

- Importare i Comuni tramite CSV, inoltrando il file "comuni" presente in 'src/main/resources/static'

- Eseguire una volta la funzione 'startedDB();' dal Runner (scommentare e riavviare e successivamente ricommentare).

## CSV IMPORT

E' possibile importare dei CSV contenenti i Comuni o le Province, consulta le API-DOCS all'endpoint "/api/csv"

## TESTS

In caso di utilizzo di Eclipse, la suite di test utilizzata è JUnit 5, quindi Jupiter, da importare.

Importare, attraverso le impostazioni di BuildPath, le librerie di Junit5 in ClassPath Modules.
