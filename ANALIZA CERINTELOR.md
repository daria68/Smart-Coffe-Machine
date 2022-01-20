# LazyCoffe - Automat de cafea pentru cei lenesi :coffee:
Document de analiză a cerințelor clientului :clipboard:

## Scopul aplicației
Contextul actual panedmic aduce cresterea numarului de persoane care lucrează remote, mari iubitoare de cafea și care isi doresc să cumpere un astfel de automat. Clientul va avea o experiență plăcută cu diferite tipuri de espresso, cappuccino, ceaiuri si alte bauturi din confortul propriei locuințe sau chiar din afara acesteia. Acest protoptip isi propune sa usureze munca celor indeajuns de lenesi sa faca mai multe drumuri pana la automatul de cafea din bucatarie. De asemenea, isi propune sa contribuie si la preventia bolilor datorate de consumului excesiv de cafea la ore tarzii, prin analizarea continua a factorilor externi. 
 
## Obiectivele aplicației
- selectarea tipului de băutură 
- prepararea rețetelor personalizate
- prepararea programată de la distanță, băutura fiind gata când utilizatorul ajunge acasă
- program pe intreaga sapatamana
- selectarea tipului de lichid dorit
- selectarea cantității de zahăr dorit 
- sistem de login pentru a oferi fiecarui utilizator posibilitatea creării unui program de folosire personalizat

## Grupul țintă
- Ca student îmi doresc
  - pe perioada sesiunii sa pot sa-mi prepar cafea si pe timpul noptii
  - sa nu devin dependent de cafea
- Ca angajat full time îmi doresc să
  - sa am cafea gata dupa ce termin o sedinta/ cand ma trezesc
  - sa-l pot programa cu diverse tipuri de cafea in functie de ziua saptamanii
- Ca iubitor de cafea îmi doresc să
  - sa pot sa-mi personalizez retele
- Ca iubitor de cafea (cu diabet/diverse probleme de sănătate), îmi doresc să
  - sa controlez nivelul de zahar din băutură
  - dupa o anumita oră sa nu ma mai lase sa-mi prepar cafea (reduce dependenta de cafea) 
- Ca persoană care nu bea deloc cafea, dar iubeste ceaiurile/ciocolata caldă, îmi doresc să
  - pot alege dintr-o varietate de sortimente de ceai
- Ca persoană vegană/vegetariană, îmi doresc să
  - pot sa aleg tipul de lapte pe care il vreau in bautura
  - daca se prepara batura cu lapte sau apa

## Colectarea cerințelor
- Pregătirea cafelei de la distanță 
- Posibilitatea alegerii dintr-o gama variată de arome/ tipuri de lichide/ ceaiuri/ ciocolata calda
- Realizare a unor rețete personalizate 
- Salvaree a rețetelor compuse pentru a putea fi folosite ulterior
- Control asupra cantitatilor (zahar, lapte, apa)
- Autosesizare zi-noapte
- Functionarea dupa un program personlizat de-a lungul unei saptamani
- Personalizarea functiilor care interactioneaza cu mediul inconjurator

## Interpretarea și prioritizarea cerințelor 

### Cerințe funcționale
Ce trebuie aplicația să facă?

- sistem de login
- meniu pentru diverse categorii
- diverse notificari 
- interfata sugestiva
 
### Cerințe nonfuncționale
Cum trebuie să fie un anumit feature sau aplicația cu totul?

- automatul trebuie sa aiba functie pentru reglarea cantitatii de zahar
- automatomatul trebuie sa poate stoca mai multe tipuri de cafea in acelasi timp
-  automatomatul trebuie sa poate stoca mai multe tipuri de ceai in acelasi timp
- automatomatul trebuie sa poate stoca mai multe tipuri de ciocolata calda in acelasi timp
-  automatomatul trebuie sa poate stoca mai multe tipuri de lichide in acelasi timp
- automatomatul trebuie sa aiba un procesor integrat
- automatomatul trebuie sa se poate conecta la internet prin wifi

# Alocarea rolurilor
:ghost: Oana: endpoints God, design baza de date 

:space_invader: Viju: CRUD and documentatie God

:alien: Daria: testing dream team, design baza de date

:robot: Vero: testing dream team, design baza de date