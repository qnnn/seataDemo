package com.kimi.storage.service;

import com.kimi.storage.entity.Storage;
import com.kimi.storage.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 郭富城
 */
@Service
public class StorageServiceImpl {
    @Autowired
    private StorageRepository storageRepository;

    @Transactional(rollbackFor = Exception.class)
    public void cut(String commodityCode,Long count){
        Storage storage = storageRepository.findByCommodityCode(commodityCode);
        storage.setCount(storage.getCount()-count);
        storageRepository.save(storage);
    }

}
