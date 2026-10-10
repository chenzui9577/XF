package org.example.exception;

import org.example.entity.Sys_equideti;

import java.util.List;

public class DuplicateDataException extends Exception {
    private List<Sys_equideti> duplicateData;

    public DuplicateDataException(String message, List<Sys_equideti> duplicateData) {
        super(message);
        this.duplicateData = duplicateData;
    }

    public List<Sys_equideti> getDuplicateData() {
        return duplicateData;
    }
}
