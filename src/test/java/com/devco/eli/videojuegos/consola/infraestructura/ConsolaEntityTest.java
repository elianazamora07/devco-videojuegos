package com.devco.eli.videojuegos.consola.infraestructura;

import org.junit.jupiter.api.Test;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ConsolaEntityTest {

    @Test
    void test_IdAnnotation() throws NoSuchFieldException {
        Field idField = ConsolaEntity.class.getDeclaredField("consolaId");
        Id idAnnotation = idField.getAnnotation(Id.class);
        GeneratedValue generatedValueAnnotation = idField.getAnnotation(GeneratedValue.class);

        assertNotNull(idAnnotation);
        assertNotNull(generatedValueAnnotation);
        assertEquals(GenerationType.IDENTITY, generatedValueAnnotation.strategy());
    }

    @Test
    void test_NombreConsolaAnnotation() throws NoSuchFieldException {
        Field nombreConsolaField = ConsolaEntity.class.getDeclaredField("nombreConsola");
        Column columnAnnotation = nombreConsolaField.getAnnotation(Column.class);

        assertNotNull(columnAnnotation);
        assertTrue(columnAnnotation.unique());
    }

    @Test
    void test_TableAnnotation() {
        Table tableAnnotation = ConsolaEntity.class.getAnnotation(Table.class);

        assertNotNull(tableAnnotation);
        assertEquals("tbl_consola", tableAnnotation.name());
    }

    @Test
    void test_GettersAndSetters() {
        ConsolaEntity consolaEntity = new ConsolaEntity();
        consolaEntity.setConsolaId(1L);
        consolaEntity.setNombreConsola("PlayStation");

        assertEquals(1L, consolaEntity.getConsolaId());
        assertEquals("PlayStation", consolaEntity.getNombreConsola());
    }

    @Test
    void test_EqualsAndHashCode() {
        ConsolaEntity consolaEntity1 = new ConsolaEntity();
        consolaEntity1.setConsolaId(1L);
        consolaEntity1.setNombreConsola("PlayStation");

        ConsolaEntity consolaEntity2 = new ConsolaEntity();
        consolaEntity2.setConsolaId(1L);
        consolaEntity2.setNombreConsola("PlayStation");

        assertEquals(consolaEntity1, consolaEntity2);
        assertEquals(consolaEntity1.hashCode(), consolaEntity2.hashCode());
    }

    @Test
    void test_ToString() {
        ConsolaEntity consolaEntity = new ConsolaEntity();
        consolaEntity.setConsolaId(1L);
        consolaEntity.setNombreConsola("PlayStation");

        String expectedToString = "ConsolaEntity(consolaId=1, nombreConsola=PlayStation)";
        assertEquals(expectedToString, consolaEntity.toString());
    }
}
