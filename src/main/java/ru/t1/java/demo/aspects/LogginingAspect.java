package ru.t1.java.demo.aspects;

import ru.t1.java.demo.entities.DataSourceErrorLog;
import ru.t1.java.demo.repository.DataSourceErrorLogRepository;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
class LoggingAspect {

    private final DataSourceErrorLogRepository errorLogRepository;

    public LoggingAspect(DataSourceErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

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
