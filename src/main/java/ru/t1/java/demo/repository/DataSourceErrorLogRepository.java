// src/main/java/com/project_name/repositories/DataSourceErrorLogRepository.java
package com.project_name.repositories;

import com.project_name.entities.DataSourceErrorLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSourceErrorLogRepository extends CrudRepository<DataSourceErrorLog, Long> {
}
