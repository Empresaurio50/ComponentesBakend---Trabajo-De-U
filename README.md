# Backend – Sistema de Gestión de Ayuda Social Parroquial

## Descripción general

Este repositorio contiene **exclusivamente el backend** de un sistema de ayuda social desarrollado para parroquias de la provincia de **Cartago**, cuyo objetivo es apoyar a personas y familias de escasos recursos mediante la entrega de **canastas de alimentos** y otros tipos de asistencia social.

Las ayudas alimentarias se entregan **cada quincena**, con un **máximo de dos ayudas por mes por beneficiario**. Para recibir una ayuda, el solicitante debe pasar previamente por un **proceso de entrevista y validación**. En caso de solicitar una nueva ayuda, el beneficiario debe volver a pasar por este proceso.

El sistema también permite llevar un **control centralizado entre parroquias**, evitando que una misma persona reciba ayudas duplicadas solicitándolas en distintas parroquias.

> [!IMPORTANT]
>  La capa de **frontend no está incluida** en este repositorio. Será desarrollada posteriormente utilizando **Angular**. Si se realizó en la entrega del proyecto pero fue un punto de mejora que menciono el profesor

---

##  Problema

Las parroquias de Cartago gestionan la entrega de ayudas sociales mediante procesos **manuales y descentralizados**, lo que limita:

* La validación efectiva de beneficiarios
* La detección de duplicidades entre parroquias
* El seguimiento histórico de las ayudas otorgadas

La ausencia de un sistema centralizado provoca **ineficiencia operativa** y un **uso no óptimo de los recursos disponibles**, afectando la equidad en la atención a las poblaciones vulnerables.

---

##  Objetivo general

Desarrollar un **sistema centralizado de gestión de beneficiarios** que permita a las parroquias de Cartago **registrar, validar y dar seguimiento** a las ayudas sociales otorgadas, garantizando la **trazabilidad de la información** y el **uso eficiente de los recursos**.

---

##  Alcance del backend

Este backend se encarga de:

* Gestión de usuarios del sistema
* Registro y administración de expedientes de beneficiarios
* Gestión de entrevistas y validaciones
* Asignación y control de ayudas
* Verificación de ayudas previas (parroquia y diócesis)
* Control de privacidad de la información
* Gestión de eventos, archivos y anexos (adendum)

---

## Metodología de desarrollo

El proyecto fue desarrollado utilizando la **metodología ágil SCRUM**, organizada en los siguientes sprints:

###  Sprint 1

* Registrar usuarios
* Ingreso al sistema
* Crear expediente
* Listar expedientes

### Sprint 2

* Entrevistar al solicitante
* Verificar solicitante en la parroquia
* Asignar tipo de ayuda
* Firmar consentimiento

### Sprint 3

* Gestionar la privacidad de la información
* Filtrar expedientes
* Listar entregas asociadas a ayudas
* Agregar adendum al expediente

### Sprint 4

* Agregar archivos al expediente
* Crear eventos
* Verificar última ayuda recibida
* Verificar solicitante a nivel de diócesis

---

## Arquitectura del sistema

El backend está estructurado siguiendo una arquitectura en capas bien definida:

* **Presentación** (exposición de servicios / endpoints)
* **Controller** (lógica de control)
* **Entidades** (modelo de dominio)
* **Acceso a datos**

### Acceso a datos

* Se utilizó **JDBC** junto con mecanismos de **persistencia**.
* Las **tablas del esquema** y sus **relaciones** se crean directamente desde el código.
* No se requiere manipulación manual de la base de datos.
* Las relaciones están definidas a través de las **entidades del sistema**.

---

## Consideraciones importantes

* El sistema garantiza que un beneficiario **no reciba más de dos ayudas mensuales**.
* Permite detectar si un solicitante ha recibido ayuda en **otra parroquia o en la diócesis**.
* Se prioriza la **seguridad, privacidad y trazabilidad** de la información socioeconómica.

---

## Futuro desarrollo

* Implementación del **frontend en Angular**.
* Finalizar de implementar funciones que no dieron tiempo de realizar o que están a media.
---

##  Proyecto académico

Este proyecto fue desarrollado como una solución tecnológica orientada a mejorar la **gestión social parroquial**, promoviendo la **equidad**, la **transparencia** y el **uso responsable de los recursos comunitarios**.
>[!IMPORTANT]
> ESTE PROYECTO SE REALIZO CON FINES EDUCATIVOS

>[IMPORTANT]
> ESTE PROYECTO SE REALIZO CON FINES EDUCATIVOS
