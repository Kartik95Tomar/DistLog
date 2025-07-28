package com.example.DistLog.service;

import com.example.DistLog.exceptions.OffsetNotFound;
import com.example.DistLog.models.Log;
import com.example.DistLog.models.Record;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private Log log;
    LogService(Log log) {
        this.log = log;
    }

    public Long handleProduce(Record record) {
        long offset = log.getRecords().size();
        record.setOffset(offset);
        log.append(record);
        return offset;
    }

    public Record handleConsume(Long offset) throws OffsetNotFound {
        if (offset == null || offset >= log.getRecords().size()) {
            throw new OffsetNotFound("Supplied Offset not found", new Exception());
        }
        return log.getRecords().get(offset.intValue());
    }
}
