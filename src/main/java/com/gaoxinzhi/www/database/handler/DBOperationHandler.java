package com.gaoxinzhi.www.database.handler;

import com.gaoxinzhi.www.database.dao.Data;
import com.gaoxinzhi.www.database.service.DataService;
import com.gaoxinzhi.www.database.strategy.DataGenerateStrategy;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.Callable;
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
    private DataService dataService;
    @Value("${data.thread.use-num}")
    Long threadNum;
    public void GenerateDataToDB(){
        // 单线程插入数据量
        long singleInsertCount = this.generateCount / threadNum;
        // 提交线程
        for(int i = 0; i < threadNum; i++){
            long threadGenerateCount = Math.min(this.generateCount, singleInsertCount);
            this.generateCount -= threadGenerateCount;
            if(threadGenerateCount > 0){
                threadPoolExecutor.submit(new Callable<Object>() {
                    @Override
                    public Object call() {
                        LinkedList<Data> data = new LinkedList<>();
                        for (int j = 0; j < threadGenerateCount; j++) {
                            data.add(dataGenerateStrategy.generateData());
                            if(j % 100 == 0){
                                dataService.saveBatch(data);
                                data.clear();
                            }
                        }
                        if(!data.isEmpty()){
                            dataService.saveBatch(data);
                        }
                        return null;
                    }
                });
            }
        }
    }
}
