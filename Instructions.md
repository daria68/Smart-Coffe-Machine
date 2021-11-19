- Programul pe care voi îl dezvoltați ar trebui să fie „creierul” unui device smart. 
- Va prelua date „din mediul inconjurător” – informații despre lumină, temperatură, perioadă a anului, oră, umiditate ș.a.m.d.
- Va prelua date date/setate de utilizator – setări, sau date transmise de utilizator / de un hub central teoretic
- Va transmite starea în care dispozitivul se află, diferitele operațiuni pe care dispozitivul le face
- Programul trebuie scris în ```C++ / Java / Python / Golang ```
- Puteți folosi orice librărie de ```C++/Java/Python/Golang```, orice compilator, orice IDE.
- Programul va trebui să comunice folosind două protocoluri: ```HTTP```și ```MQTT```. 

# Programul trebuie să respecte următoarele cerințe (2.5p):
- Expune un Rest API HTTP – documentat folosind Open API (Swagger) 
- Expune un API MQTT – documentat folosind AsyncAPI
- Aplicația să aibă minim 5 funcționalități – puteți să vă gândiți la ele ca sell points ale aplicației. Depinde de aplicația pe care v-ați propus să o faceți, dar chestii de genul o funcționalitate e scăderea, o altă funcționalitate e adunarea, nu înseamnă chiar că sunt diferite 
- Tot ce faceți să se găsească într-un singur repo.

# Pentru puncte:
- Toate funcționalitățile și/sau toate endpoints au unit teste asociate. ```+1.5p```
- Documentația de analiză este up to date ```+ 1p```
- Documentația de utilizare reflectă aplicația reală ```+ 1p```
- Programul trebuie să respecte următoarele cerințe:
- Să prelucreze date reale (fie că accesează un alt api pentru a prelua date, fie că descărcați un set de date pe care îl dați apoi aplicației) ```+ 1p```
- Utilizarea unui tool de testare automată (gen RESTler) pentru a identifica buguri. ```+1.5p```
- Integration tests ```+1p```
- Coverage al testelor de 80%+ ```0.5p```
