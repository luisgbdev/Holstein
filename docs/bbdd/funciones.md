# Funciones

Este documento contiene una descripción detallada de las funciones utilizadas en el sistema de gestión de mesas y comandas del restaurante.

## 1. Visualización de mesas y camareros asignados

La función `VerMesasYCamareros` devuelve un texto con la información de cada mesa y el camarero asignado a ella. 

```sql
DELIMITER //

CREATE FUNCTION VerMesasYCamareros() RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE resultado TEXT;

    SELECT CONCAT('Mesa ', Mesas.numero, ': ', Camareros.nombre, ' (ID Camarero: ', Camareros.ID_camarero, ')') INTO resultado
    FROM Mesas
    LEFT JOIN Camareros ON Mesas.ID_camarero = Camareros.ID_camarero;

    RETURN resultado;
END //

