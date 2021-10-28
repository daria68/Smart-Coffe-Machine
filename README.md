# LazyCoffe - Automat de cafea pentru cei lenesi :coffee:
Document de analiză a cerințelor clientului :clipboard:

## Scopul aplicației
Contextul actual panedmic aduce cresterea numarului de persoane care lucrează remote, mari iubitoare de cafea și care isi doresc să cumpere un astfel de automat. Clientul va avea o experiență plăcută cu diferite tipuri de espresso, cappuccino si alte bauturi din confortul propriei locuințe sau chiar din afara acesteia. Acest protoptip isi propune sa usureze munca celor indeajuns de lenesi sa faca mai multe drumuri pana la automatul de cafea din bucatarie: sa verifice cantitatea de materie prima inaintea fiecarei folosiri, sa il porneasca, apoi sa se intoarca dupa cafea, sa uite ca l-au pornit si sa bea cafea rece. De asemenea, isi propune sa contribuie si la preventia bolilor datorate de consumului excesiv de cafea la ore tarzii, prin analizarea continua a factorilor externi, de mediu. 
 
## Obiectivele aplicației
- posibilitatea transformării într-o boxă de la distanță
- selectarea tipului de băutură 
- prepararea rețetelor personalizate
- prepararea programată de la distanță, băutura fiind gata când utilizatorul ajunge acasă
- selectarea din mai multe tipuri de lapte
- selectarea cantității de zahăr dorit (de la 0 la 5 lingurițe, în funcție de pahar)
- selectarea tipului de pahar (mic/mediu/mare)
- curățare programată automată (ex - pe timp de noapte când nu este folosit) 
- log off și log in pentru a oferi fiecarui utilizator posibilitatea creării unui program de folosire personalizat

## Grupul țintă
- Ca student îmi doresc
  - sa pot sa-l transform intr-o boxa portabila
  - pe perioada sesiunii sa pot sa-mi prepar cafea si pe timpul noptii
- Ca angajat full time îmi doresc să
  - sa am cafea gata dupa ce termin o sedinta/ cand ma trezesc
  - sa-l pot programa cu diverse tipuri de cafea in functie de ziua saptamanii
  - curatare automata(programata) pe timpul noptii
- Ca iubitor de cafea îmi doresc să
  - sa pot sa-mi personalizez retele
  - sa selecteze gradul de macinare
- Ca iubitor de cafea (cu diabet/diverse probleme de sănătate), îmi doresc să
  - sa controlez nivelul de zahar din băutură
  - dupa o anumita oră sa nu ma mai lase sa-mi prepar cafea 
- Ca persoană care nu bea deloc cafea, dar iubeste ceaiurile/ciocolata caldă, îmi doresc să
  - pot alege dintr-o varietate de sortimente de ceai
- Ca persoană vegană/vegetariană, îmi doresc să
  - pot sa aleg tipul de lapte pe care il vreau in bautura
  - daca se prepara batura cu lapte sau apa

## Colectarea cerințelor
- Pregătirea cafelei de la distanță 
- Posibilitatea alegerii dintr-o gama variată de arome/ tipuri de lichide/ ceaiuri
- Realizare a unor rețete personalizate 
- Selectarea gradului de macinare 
- Salvaree a rețetelor compuse pentru a putea fi folosite ulterior
- Control asupra cantitatilor (zahar, lapte, apa)
- Autosesizare zi-noapte
- Functionarea dupa un program personlizat de-a lungul unei saptamani
- Incarcare melodie/ playlist 
- Notificari de tipul - ready
- Curatare automata
- Personalizarea functiilor care interactioneaza cu mediul inconjurator

## Interpretarea și prioritizarea cerințelor 

### Cerințe funcționale
Nevoi care au reieșit dintr-un user story, și răspund la întrebarea: ce trebuie aplicația să facă?

- sistem de login
- meniu pentru diverse categorii
- notificari in bara de stare
- interfata sugestiva
 
### Cerințe nonfuncționale
Descriu calitati de sistem, răspund întrebărilor de tipul cum trebuie să fie un anumit feature sau aplicația cu totul?

- automatul trebuie sa aiba o boxa incorporata
- automatul trebuie sa aiba senzori de lumina
- automatul trebuie sa aiba posibilitatea reglarii gradului de macinare
- automatul trebuie sa aiba functia de curatare automata
- automatul trebuie sa aiba container pentru stocarea paharelor de diferite dimensiuni
- automatul trebuie sa aiba functie pentru reglarea cantitatii de indulcitor
- automatul trebuie sa aiba posibilitatea alegerii din diverse tipuri de ceaiuri

### Cerințe care țin de sănătate, securitate, modificări fizice ale automatului

### Cerințe care țin de software, quality of life, control din driver

# Alocarea rolurilor
:ghost: Oana: design aplicatie

:space_invader: Viju: server, comunicarea cu internetul

:alien: Daria: design aplicatie

:robot: Vero: server, comunicarea cu internetul
