package com.account.service.factory;

import com.account.service.client.DataSource1Client;
import com.account.service.util.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataSourceFactory {

    @Autowired
    DataSource1Client dataSource1Client;
//Only one Data sources been added for the ease of the implementation
// but multiple can be added based on the requirement
    public DataSource getDataSource(SourceType sourceType) {
        switch (sourceType) {
            case SOURCE1:
            case SOURCE2:
            case SOURCE3:
                return dataSource1Client;
            default:
                return null;
        }
    }
}
