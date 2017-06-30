package org.demo.spring.service;

import org.apache.ibatis.annotations.Mapper;
import org.demo.spring.model.Lend;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
@Mapper
@Component
public interface LendService {
    Long saveLend(Lend lend);
    List<Lend> queryLends(String lendName);
    Lend getLendById(String id);
}
