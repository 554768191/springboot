package org.demo.spring.dao;

import org.demo.spring.model.Lend;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
public interface LendDao {
    Long saveLend(Lend lend);
    String getLenddById(String id);
    List<Lend> queryLends(String lendName);
}
