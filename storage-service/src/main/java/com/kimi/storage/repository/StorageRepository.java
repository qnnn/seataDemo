package com.kimi.storage.repository;

import com.kimi.storage.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author 郭富城
 */
@Repository
public interface StorageRepository extends JpaRepository<Storage,Long>, JpaSpecificationExecutor<Storage> {
    /**
     * 通过商品号查找
     * @param commodityCode 商品号
     * @return 商品
     */
    Storage findByCommodityCode(String commodityCode);
}
