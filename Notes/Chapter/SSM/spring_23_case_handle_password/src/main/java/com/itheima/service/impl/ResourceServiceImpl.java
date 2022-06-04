package com.itheima.service.impl;

import com.itheima.dao.ResourceDao;
import com.itheima.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public boolean openUrl(String url, String password) {

        return resourceDao.readResource(url,password);
    }
}
