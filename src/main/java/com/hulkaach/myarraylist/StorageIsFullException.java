package com.hulkaach.myarraylist;

public class StorageIsFullException extends RuntimeException {
    public StorageIsFullException() {
    }

    public StorageIsFullException(String message) {
        super(message);
    }
}
