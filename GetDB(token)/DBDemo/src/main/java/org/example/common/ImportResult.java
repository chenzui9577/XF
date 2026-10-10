package org.example.common;

import org.example.entity.Sys_equideti;

import java.util.List;

public class ImportResult {
    private int successCount;
    private List<Sys_equideti> duplicateData;


    public ImportResult(int successCount) {
        this.successCount = successCount;
    }

    public ImportResult(int successCount, List<Sys_equideti> duplicateData) {
        this.successCount = successCount;
        this.duplicateData = duplicateData;
    }

    // Getters
    public int getSuccessCount() {
        return successCount;
    }

    public List<Sys_equideti> getDuplicateData() {
        return duplicateData;
    }

    // Setters if needed
}
