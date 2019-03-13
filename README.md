# hibernate-objetos
> Tutorial con diferentes versiones del mapeo SQL - objetos. 

Este repositorio tiene varias versiones del mismo código, organizadas con [tags](https://git-scm.com/book/es/v1/Fundamentos-de-Git-Creando-etiquetas) de Git. Al descargar el repositorio se accede por defecto a la versión más completa, pudiendo moverse hacia atrás con el comando `git checkout`.

Se detalla a continuación el contenido de cada versión y cómo acceder a ella.

### Versión 1: XML

```
git checkout v1-xml
```

![image](https://user-images.githubusercontent.com/1585835/54321044-19351700-45ce-11e9-836e-c47e161ca944.png)

Versión inicial, utilizando un archivo de configuración XML para vincular la clase `Product` de Java con la tabla `Product` de la base de datos. Para correr esta versión es necesario crear la base de datos y la tabla, ejecutando los siguientes comandos SQL:

```sql
CREATE DATABASE `persist_db`;
USE `persist_db`;

CREATE TABLE `Product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

### Versión 2: JPA

```
git checkout v2-jpa
```

![image](https://user-images.githubusercontent.com/1585835/54321044-19351700-45ce-11e9-836e-c47e161ca944.png)

Se reemplaza el archivo XML por anotaciones JPA en la misma clase `Product`, aprovechando también las convenciones: 

* si la clase Java se llama exactamente igual que la tabla SQL;
* o los atributos de la clase Java se llaman igual en las columnas en SQL;

...no es necesario escribir ninguna anotación adicional.


### Versión 3: JPA, con una relación ManyToOne

```
git checkout v3-manytoone
```

![image](https://user-images.githubusercontent.com/1585835/54320995-cc514080-45cd-11e9-96c3-a728fe8b32c2.png)

Se agrega un segundo modelo, la `Category`, que se vincula con `Product` mediante una relación _one to many_ (uno a muchos). Además, Hibernate se encarga de crear las tablas y relaciones automáticamente.

### Versión 4: JPA, con una relación ManyToOne y otra ManyToMany

```
git checkout v4-manytomany
```

![image](https://user-images.githubusercontent.com/1585835/54320889-606ed800-45cd-11e9-821d-efa7789d7f5f.png)

Se agrega un tercer modelo, la `Brand`, que se vincula con `Product` mediante una relación _one to many_ (uno a muchos). Se modifica la `Category` para que se relacione con una relación _many to many_ (muchos a muchos).
