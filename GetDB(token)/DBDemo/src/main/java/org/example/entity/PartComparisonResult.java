package org.example.entity;

import java.util.List;

public class PartComparisonResult {
    private List<String> onlyInList1;
    private List<String> onlyInList2;

    public PartComparisonResult() {
    }
    private int id;
    private int modelPointCount;
    private int databasePointCount;
    private String onlyModelPoints;
    private String onlyDatabasePoints;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModelPointCount() {
        return modelPointCount;
    }

    public void setModelPointCount(int modelPointCount) {
        this.modelPointCount = modelPointCount;
    }

    public int getDatabasePointCount() {
        return databasePointCount;
    }

    public void setDatabasePointCount(int databasePointCount) {
        this.databasePointCount = databasePointCount;
    }

    public String getOnlyModelPoints() {
        return onlyModelPoints;
    }

    public void setOnlyModelPoints(String onlyModelPoints) {
        this.onlyModelPoints = onlyModelPoints;
    }

    public String getOnlyDatabasePoints() {
        return onlyDatabasePoints;
    }

    public void setOnlyDatabasePoints(String onlyDatabasePoints) {
        this.onlyDatabasePoints = onlyDatabasePoints;
    }

    public PartComparisonResult(List<String> onlyInList1, List<String> onlyInList2) {
        this.onlyInList1 = onlyInList1;
        this.onlyInList2 = onlyInList2;
    }

    public List<String> getOnlyInList1() {
        return onlyInList1;
    }

    public void setOnlyInList1(List<String> onlyInList1) {
        this.onlyInList1 = onlyInList1;
    }

    public List<String> getOnlyInList2() {
        return onlyInList2;
    }

    public void setOnlyInList2(List<String> onlyInList2) {
        this.onlyInList2 = onlyInList2;
    }

    public ComparisonSummary getComparisonSummary() {
        ComparisonSummary summary = new ComparisonSummary();
        summary.setName("点位总数");
        summary.setModelPoint(Integer.toString(modelPointCount));
        summary.setDatabasePoint(Integer.toString(databasePointCount));
        return summary;
    }

    public ComparisonDiff getComparisonDiff() {
        ComparisonDiff diff = new ComparisonDiff();
        diff.setName("点位差异(独有点位)");
        diff.setModelPoint(onlyModelPoints);
        diff.setDatabasePoint(onlyDatabasePoints);
        return diff;
    }
}
