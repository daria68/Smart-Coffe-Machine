# Documentatie de utilizare :rocket:

### 1. Proiect:
- ```git clone https://github.com/daria68/Smart-Coffe-Machine.git```
  
  :diamonds: ```JavaSE-11```

  :diamonds: Spring Tools ```v. 4.13.1```


### 2. Configurarea bazei de date ```MySQL DB```

Pentru ca proiectul sa functioneze corespunzator trebuie sa setati parametrii specifici bazei de date.

In ```application.proprieties```:
- Url baza de date: 
  
  ```spring.datasource.url``` 
- Credentialele bazei de date:
```
spring.datasource.username
spring.datasource.password
```
### 3. Mosquitto 
   
- Download: https://mosquitto.org/download/
- Instalati
- Mergeti in foldeul pe care l-ati descarcat local
- Faceti o copie a fisierului ```mosquito.conf``` si denumiti-o ```broker.conf```
- Deschideti ```broker.conf```, inlocuiti urmaoarele:
```
listener 1883
allow_anonymous true
```
- Rulati in CMD/ terminal (in folderul in care este instalat mosquito):

```mosquitto -v -c broker.conf```

- Faceti o copie a fisierului ```pwdfille.example``` si denumiti-o ```passFile```

- Scrieti in ```passFile```: ```Admin: 12345678```
- CMD/ terminal: ```Mosquito_passwd -U passFile ```

*Aceasta comanda va ajuta la criptarea parolei*

- In ```broker.conf``` scrieti urmatorele:
 ```
 listener 18883
 password_file passFile
 allow_anonymous false
 ```
- CMD/ terminal: 
```mosquitto_pub -t mytopic -m "Make Caffe" -u admin -P 12345678```

*Veti observa in terminalul aplicatiei de SprinBoot afisat mesajul ```Make Caffe```*

- Postman 
```POST - localhost:8080/sendMessage```

JSON body: 
```JSON body
{
    "topic": "mytopic",
    "message":{
        "data": "Ana are mere"
    }
}
```
### 4. RESTLER test
- ```mkdir restler_bin```
- ```git clone https://github.com/microsoft/restler-fuzzer.git```
- Instalare python3
- ```python3 ./build-restler.py --dest_dir <Full Path for restler_bin dir>```
- ```cd <Path to restler-fuzzer dir>```
- ```python3 restler-quick-start.py --api_spec_path <Full path to openapi.yml> --restler_drop_dir <Full path to restler_bin dir>```

```
G:\Cursuri_FMI_an3\IP\restler-fuzzer>>>
python3 restler-quick-start.py --api_spec_path "G:\Cursuri_FMI_an3\IP\openapi.yaml"  --restler_drop_dir "G:\Cursuri_FMI_an3\IP\restler_bin"
>>>
G:\Cursuri_FMI_an3\IP\restler-fuzzer>python3 restler-quick-start.py --api_spec_path "G:\Cursuri_FMI_an3\IP\openapi.yaml"  --restler_drop_dir "G:\Cursuri_FMI_an3\IP\restler_bin"
dotnet "G:\Cursuri_FMI_an3\IP\restler_bin\restler\Restler.dll" compile --api_spec "G:\Cursuri_FMI_an3\IP\openapi.yaml"
Starting task Compile...
Task Compile succeeded.
Collecting logs...
dotnet "G:\Cursuri_FMI_an3\IP\restler_bin\restler\Restler.dll" test --grammar_file "Compile\grammar.py" --dictionary_file "Compile\dict.json" --settings "Compile\engine_settings.json" --no_ssl
Starting task Test...
Using python: 'python.exe' (Python 3.9.5)
Request coverage (successful / total): 3 / 6
No bugs were found.
Task Test succeeded.
Collecting logs...
Test complete.
See G:\Cursuri_FMI_an3\IP\restler-fuzzer\restler_working_dir for results.

```
