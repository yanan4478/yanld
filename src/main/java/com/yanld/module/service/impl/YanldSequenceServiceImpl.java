package com.yanld.module.service.impl;

import com.yanld.module.common.dal.dao.YanldSequenceDao;
import com.yanld.module.common.dal.dataobject.YanldSequenceDO;
import com.yanld.module.common.exception.TableNotExistException;
import com.yanld.module.service.YanldSequenceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by yanan on 16/8/2.
 */
@Service
public class YanldSequenceServiceImpl implements YanldSequenceService {

    @Resource
    private YanldSequenceDao yanldSequenceDao;

    private static final int STEP_SIZE = 100;
    private ConcurrentHashMap<String, Long> seqMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, AtomicLong> idMap = new ConcurrentHashMap<>();
    private final Object LOCK = new Object();

    @Override
    public long getId(String tableName) throws TableNotExistException {
        Long seq = seqMap.get(tableName);
        if (seq == null) {
            synchronized (LOCK) {
                if (seqMap.get(tableName) == null) {
                    YanldSequenceDO yanldSequenceDO = yanldSequenceDao.selectSequence(tableName);
                    if (yanldSequenceDO == null) {
                        throw new TableNotExistException("table is not exist!!");
                    }
                    seq = yanldSequenceDO.getSeq();
                    yanldSequenceDao.updateSequence(new YanldSequenceDO(tableName, seq + 1));
                    seqMap.put(tableName, seq);
                    idMap.put(tableName, new AtomicLong(seq * STEP_SIZE));
                }
            }
        }
        AtomicLong lastId = idMap.get(tableName);
        long id = lastId.incrementAndGet();
        seq = seqMap.get(tableName);
        if (id > (seq + 1) * STEP_SIZE) {
            synchronized (LOCK) {
                if (seq.longValue() == seqMap.get(tableName)) {
                    yanldSequenceDao.updateSequence(new YanldSequenceDO(tableName, ++seq + 1));
                    seqMap.put(tableName, seq);
                    idMap.put(tableName, new AtomicLong(seq * STEP_SIZE));
                }
            }
            return getId(tableName);
        }
        return id;
    }

}
