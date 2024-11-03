// DataSourceErrorLog.java
package com.project_name.entities;

public class DataSourceErrorLog {
    private String stackTraceText;      // Текст стектрейса исключения
    private String message;             // Сообщение об ошибке
    private String methodSignature;     // Сигнатура метода, в котором возникла ошибка

    // Конструктор
    public DataSourceErrorLog(String stackTraceText, String message, String methodSignature) {
        this.stackTraceText = stackTraceText;
        this.message = message;
        this.methodSignature = methodSignature;
    }

    // Геттеры и сеттеры
    public String getStackTraceText() {
        return stackTraceText;
    }

    public void setStackTraceText(String stackTraceText) {
        this.stackTraceText = stackTraceText;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMethodSignature() {
        return methodSignature;
    }

    public void setMethodSignature(String methodSignature) {
        this.methodSignature = methodSignature;
    }
}
