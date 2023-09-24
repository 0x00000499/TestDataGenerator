package com.gaoxinzhi.www.database.handler;

import com.gaoxinzhi.www.database.dao.Data;
import com.gaoxinzhi.www.database.service.DataService;
import com.gaoxinzhi.www.database.strategy.DataGenerateStrategy;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;

@Component
@Log4j2
public class DBOperationHandler {
    @Value("${data.generate-count}")
    Long generateCount;
    @Autowired
    ThreadPoolExecutor threadPoolExecutor;
    @Autowired
    private DataGenerateStrategy dataGenerateStrategy;
    @Autowired
    private DataService personService;
    @Value("${data.thread.use-num}")
    Long threadNum;
    public void GenerateDataToDB(){
        // 提交线程
        for(int i = 0; i < threadNum; i++){
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    LinkedList<Data> data = new LinkedList<>();

                }
            });
        }
    }
}
