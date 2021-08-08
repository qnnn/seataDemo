package com.kimi.storage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author 郭富城
 */
@Getter
@Setter
@Entity
@Table(name = "storage_tbl")
public class Storage implements Serializable {

    private static final long serialVersionUID = 4311814763497369162L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "commodity_code")
    private String commodityCode;

    @Column(name = "count")
    private Long count;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Storage storage = (Storage) o;
        return Objects.equals(id, storage.id);
    }

    /**
     * 重写hashcode防止死循环
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
