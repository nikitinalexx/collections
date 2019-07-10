package com.alex.nikitin.mvc;

import com.alex.nikitin.mvc.config.DataConfig;
import com.alex.nikitin.mvc.config.ServiceConfig;
import com.alex.nikitin.mvc.services.SingerService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceTestConfig.class, ServiceConfig.class, DataConfig.class})
@TestExecutionListeners(ServiceTestExecutionListener.class)
@ActiveProfiles("test")
public class SingerServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    SingerService singerService;
    
}
