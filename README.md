# Hospitalv2
version mejorada CRUD

<img src="https://i.postimg.cc/Wzjs9xJ5/MENU.png" alt="consola" width="1000" height="500">

# USAR TERMINAL
Para usar el .jar llamado "HOSPITAL-CRUD" abrimos cualquier terminal, sugerencia usar PowerShell o BASH " cmd " 

en el terminal ingresamos:

```
cd "C:\Users\Usuario\Downloads\"
```

cd es para ubicar la carpeta donde este el jar 

luego ingresamos:

```
java -jar HOSPITAL-CRUD.jar
```

este es para ejecutar el jar


# Editar el proyecto  

el zip trae para usarse en eclipse , se ejecuta es el zip 

ademas de eso trae la carpeta Hospital-main para revisar como es que funciona o para otras modificaciones 

# EJECUCION DE LA BASE DE DATOS PostgreSQL 

<img src="https://i.postimg.cc/JnLDj6KJ/consulta-sql.png" alt="consola" width="1000" height="500">

en la terminal de PowerShell se ejecuta este comando:

```
& "C:\Program Files\PostgreSQL\18\bin\psql.exe" -U postgres -d hospital_db
```

para CMD usar:

```
"C:\Program Files\PostgreSQL\18\bin\psql.exe" -U postgres -d hospital_db
```

## comandos para mirar 

para ver en la base de datos usar

```
SELECT * FROM pacientes;

SELECT * FROM medicamntos;

SELECT * FROM administracion;
```

para eliminar , se elimina primero de la base de datos de administracion y despues de las 2 que quieras tanto de pacientes como de medicamentos 

EJEMPLO:

quiero eliminar el medicamento con id: 106 

para eso primero hacer:

eliminarlo desde administracion: 

```
DELETE FROM administracion

WHERE medicamento_id = 106;
```

Segundo ahora si se deja eliminar desde medicamentos:

```
DELETE FROM medicamentos

WHERE id = 106;
```

Para borrar universalmente una base de datos se usara esto:

```
DELETE FROM pacientes; 

DELETE FROM medicamentos; 

DELETE FROM administracion; 
```

# ARCHIVOS 

[Archivos del proyecto CRUD](https://github.com/shaylafool/Hospitalv2/tree/main/crudPacienteMedicamentoV2)

[ARCHIVO JAR](https://github.com/shaylafool/Hospitalv2/blob/main/HOSPITAL-CRUD.jar)

[ARCHIVO ZIP](https://github.com/shaylafool/Hospitalv2/blob/main/CRUD-HOSPITAL.zip)


# VERSIONES

[version 1.0](https://github.com/wilsonv-dev/Hospital)

[version 2.0](https://github.com/shaylafool/Hospitalv2/tree/main)

# TECNOLOGIAS USADAS 

IDE: [ECLIPSE](https://eclipseide.org/)
 
LIBRERIA: [postgresql-42.7.8.jar](https://github.com/shaylafool/Hospitalv2/tree/main/crudPacienteMedicamentoV2/lib)

SQL: [PostgreSQL](https://www.postgresql.org/)

# PREVIEW

<img src="https://i.postimg.cc/Wzjs9xJ5/MENU.png" alt="consola" width="1000" height="500">
<img src="https://i.postimg.cc/C1CgfJ68/2.png" alt="consola" width="1000" height="500">
<img src="https://i.postimg.cc/mZw4LXHw/34.png" alt="consola" width="500" height="600">

# Creas tablas en postgreSQL 

aqui un breve tutorial para la creacion de las tablas y la base de datos en postgre

la contraseña del proyecto de postgreSQL en el jar , debe ser " 12345 " ademas de tener el usuario por defecto de postgreSQL

[Creacion de la tablas](https://pastebin.com/raw/JASP3y4L)








