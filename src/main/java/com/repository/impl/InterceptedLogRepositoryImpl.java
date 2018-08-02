package com.repository.impl;

import org.springframework.stereotype.Repository;

import com.model.InterceptedLog;
import com.repository.InterceptedLogRepository;
@Repository(value="interceptedLogRepository")
public class InterceptedLogRepositoryImpl extends BasicRepositoryImpl<InterceptedLog> implements InterceptedLogRepository {

}
