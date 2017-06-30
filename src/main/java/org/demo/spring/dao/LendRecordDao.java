package org.demo.spring.dao;

import org.demo.spring.model.Lend;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
public interface LendRecordDao {
    Long saveLend(Lend lendd);
    String getLendRecordById(String id);
}
