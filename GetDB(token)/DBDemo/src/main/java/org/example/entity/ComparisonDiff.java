package org.example.entity;

public class ComparisonDiff {
    private String name;
    private String modelPoint;
    private String databasePoint;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelPoint() {
        return modelPoint;
    }

    public void setModelPoint(String modelPoint) {
        this.modelPoint = modelPoint;
    }

    public String getDatabasePoint() {
        return databasePoint;
    }

    public void setDatabasePoint(String databasePoint) {
        this.databasePoint = databasePoint;
    }
}
