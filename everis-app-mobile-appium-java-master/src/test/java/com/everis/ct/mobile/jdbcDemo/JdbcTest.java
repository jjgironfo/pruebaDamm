package com.everis.ct.mobile.jdbcDemo;

import com.everis.ct.mobile.db.JDBCOperations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class JdbcTest {

    @Autowired
    private JDBCOperations jdbcOperations;

    public void getCountData() {
        var tableName = "demo";
        System.out.println("Registers in " + tableName + " table: " + jdbcOperations.countRow(tableName));
    }

    public void getDataByColumnName() {
        var tableName = "demo";
        var columName = "first";
        List<Map<String, Object>> valueFromColumnName = jdbcOperations.selectDataAsList(tableName, columName);
        System.out.println("valueFromColumnName : " + valueFromColumnName);
        for (Map<String, Object> values : valueFromColumnName) {
            System.out.println(values.get("first"));
        }
    }

    public void getDataByColumnsAndConditions() {
        var tableName = "demo";
        var columName = "*";
        var condition = "";
        List<Map<String, Object>> valueFromColumnName = jdbcOperations.selectDataAsList(tableName, columName, condition);
        System.out.println("valueFromColumnName : " + valueFromColumnName);
        for (Map<String, Object> values : valueFromColumnName) {
            System.out.println(values.get("first"));
        }
        for (Map<String, Object> values : valueFromColumnName) {
            System.out.println(values.get("last"));
        }
    }

    public void getDataByConditionsAsMap() {
        var tableName = "demo";
        var condition = "WHERE id = '2'";
        Map<String, Object> stringObjectMap = jdbcOperations.selectDataAsMap(tableName, condition);
        System.out.println("valueFromColumnName : " + stringObjectMap);
        System.out.println(stringObjectMap.get("id"));
        System.out.println(stringObjectMap.get("first"));
        System.out.println(stringObjectMap.get("last"));
        System.out.println(stringObjectMap.get("age"));
    }

    public void getDataByColumnsAndConditionsAsMap() {
        var tableName = "demo";
        var column = "first, last, age";
        var condition = "WHERE id = '2'";
        Map<String, Object> stringObjectMap = jdbcOperations.selectDataAsMap(tableName, column, condition);
        System.out.println("valueFromColumnName : " + stringObjectMap);
        System.out.println(stringObjectMap.get("id"));
        System.out.println(stringObjectMap.get("first"));
        System.out.println(stringObjectMap.get("last"));
        System.out.println(stringObjectMap.get("age"));
    }

    public void getDataByColumnsAndConditionsAsString() {
        var tableName = "demo";
        var columName = "first,last";
        var condition = "WHERE id = '1'";
        Map<String, Object> stringObjectMap = jdbcOperations.selectDataAsMap(tableName, columName, condition);
        System.out.println("valueFromColumnName : " + stringObjectMap);
    }

    public void selectDataAsString() {
        var tableName = "demo";
        var columName = "first";
        var condition = "WHERE last = 'Mendoza'";
        String value = jdbcOperations.selectDataAsString(tableName, columName, condition);
        System.out.println("valueFromColumnName : " + value);
    }

    public void selectDataAsObject() {
        var tableName = "demo";
        var columName = "first";
        var condition = "WHERE last = 'Mendoza'";
        String values = (String) jdbcOperations.selectDataAsObject(tableName, columName, condition);
        System.out.println("valueFromColumnName : " + values);
    }

    public void insertRow() {
        var tableName = "demo";
        var insertColumns = "(id, first, last, age)";
        var insertValues = "(3, 'Juana', 'Martinez', 70)";
        boolean values = jdbcOperations.insertNewRow(tableName, insertColumns, insertValues);
        System.out.println("valueFromColumnName : " + values);
    }

    public void insertRow2() {
        var tableName = "demo";
        var insertColumns = "(id, first, last)";
        var insertValues = "(3, 'Juana', 'Martinez')";
        boolean values = jdbcOperations.insertNewRow(tableName, insertColumns, insertValues);
        System.out.println("valueFromColumnName : " + values);
    }

    public void updateValues() {
        var tableName = "demo";
        var valuesToUpdate = "\"first\"='Pedro'";
        var condition = "WHERE id=0";
        boolean values = jdbcOperations.updateValue(tableName, valuesToUpdate, condition);
        System.out.println("valueFromColumnName : " + values);
    }

    public void deleteValues() {
        var tableName = "demo";
        var condition = "WHERE id=3";
        boolean values = jdbcOperations.deleteData(tableName, condition);
        System.out.println("valueFromColumnName : " + values);
    }


    public void createTable() {
        var schema = "public";
        var tableName = "demo3";
        var newTableProperties = "(id int, name varchar)";
        boolean values = jdbcOperations.createTable(schema, tableName, newTableProperties);
        System.out.println("se creo la tabla? " + values);
    }

    public void verifyTable() {
        var schema = "public";
        var tableName = "demo3";
        boolean values = jdbcOperations.isTableExist(null, schema, tableName, null);
        System.out.println("existe la tabla? " + values);
    }
}
