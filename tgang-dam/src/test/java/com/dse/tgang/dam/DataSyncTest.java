package com.dse.tgang.dam;

import com.dse.tgang.dam.listener.DataSyncListener;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by wangxd on 2017/2/8.
 */
//@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class DataSyncTest {
    @Test
    public void testBuild(){
        DataSyncListener.start();
        try {
            Thread.sleep(1000 * 60 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

}
