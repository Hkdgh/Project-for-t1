// src/main/java/com/project_name/aspects/LoggingAspect.java
package com.project_name.aspects;

import com.project_name.entities.DataSourceErrorLog;
import com.project_name.repositories.DataSourceErrorLogRepository;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private DataSourceErrorLogRepository errorLogRepository;

    @Pointcut("@annotation(com.project_name.aspects.LogDataSourceError)")
    public void logDataSourceErrorPointcut() {}

    @AfterThrowing(pointcut = "logDataSourceErrorPointcut()", throwing = "exception")
    public void logError(Exception exception) {
        String stackTrace = exception.toString();
        String message = exception.getMessage();
        String methodSignature = exception.getStackTrace()[0].toString();

        DataSourceErrorLog errorLog = new DataSourceErrorLog(stackTrace, message, methodSignature);
        errorLogRepository.save(errorLog);
    }
}
