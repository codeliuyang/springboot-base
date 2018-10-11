package com.lerr.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

public class DataSourceDemoTest extends SpringbootBaseDemoApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceDemoTest.class);

    @Autowired
    DataSource dataSource;

    @Test
    public void showDataSource(){
        // the output info will show the dataSource implemention
        logger.info(dataSource.toString());
    }

}
