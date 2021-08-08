package com.kimi.account.entity;

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
@Table(name = "account_tbl")
public class Account implements Serializable {

    private static final long serialVersionUID = 5825645381047197580L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "user_id")
    private String userId;

    @Column(name = "money")
    private Long money;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(id, account.id);
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
