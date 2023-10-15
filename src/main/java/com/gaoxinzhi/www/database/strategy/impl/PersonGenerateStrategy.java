package com.gaoxinzhi.www.database.strategy.impl;

import com.gaoxinzhi.www.database.dao.Data;
import com.gaoxinzhi.www.database.strategy.DataGenerateStrategy;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PersonGenerateStrategy implements DataGenerateStrategy {
    @Override
    public Data generateData() {
        Random random = new Random();
        Data data = new Data();
        data.setPersonId(random.nextInt());
        String nameMap = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder name = new StringBuilder();
        for(int i = 0; i < 4; i++){
            name.append(nameMap.charAt(random.nextInt(26)));
        }
        data.setPersonName(name.toString());
        StringBuilder phoneNumber = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        data.setPhone(phoneNumber.toString());
        data.setAge(random.nextInt(70));
        StringBuilder company = new StringBuilder();
        for (int i = 0; i < 20; i++) {
             company.append(nameMap.charAt(random.nextInt(26)));
        }
        data.setCompany(company.toString());
        return data;
    }
}
