package com.gaoxinzhi.www.database.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gaoxinzhi.www.database.dao.Data;
import com.gaoxinzhi.www.database.mapper.DataMapper;
import com.gaoxinzhi.www.database.service.DataService;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl extends ServiceImpl<DataMapper, Data> implements DataService {


}
