package com.zbor.pgTest.service.impl;

import com.zbor.pgTest.mapper.test.tUserMapper;
import com.zbor.pgTest.mapper.test2.tUser2Mapper;
import com.zbor.pgTest.model.test.tUser;
import com.zbor.pgTest.service.MulDatasOptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class MulDatasOptServiceImpl implements MulDatasOptService {
    @Autowired
    private tUserMapper mapper;
    @Autowired
    private tUser2Mapper mapper2;

    @Transactional(transactionManager = "test2TransactionManager")
    @Override
    public void migrateDataFromAToB() {
        List<tUser> tUserList = mapper.selectAll();
        tUserList.forEach(tUser -> {
            System.out.println(tUser.toString());
        });
                tUserList.forEach(tUser -> {
            Long tmpId = tUser.getId();
            if(tUser.getId() != 50)
                tUser.setId(tUser.getId() + 200L);
            com.zbor.pgTest.model.test2.tUser tUser2 = new com.zbor.pgTest.model.test2.tUser();
            tUser2.setId(tUser.getId());
            tUser2.setAge(tUser.getAge());
            tUser2.setName(tUser.getName());
            tUser2.setGender(tUser.getGender());
            if( mapper2.insert(tUser2) == 1)
                System.out.println("test表id为" + tmpId + "：插入test2成功");
        });
    }



}
