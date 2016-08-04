package other.service;

import com.yanld.module.service.YanldSequenceService;
import org.junit.Test;
import other.BaseTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by yanan on 16/8/3.
 */
public class SequenceServiceTest extends BaseTest {
    @Resource
    private YanldSequenceService sequenceService;

    @Test
    public void test1(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        final String tableName = "yanld_article";
        final String tableName = "yanld_arle";
        List<Future<Long>> futureList = new ArrayList<>();
        long sum = 0;
        long index = 0;
        try {
            for (int i = 0; i < 10; i++) {
                Future<Long> future = executorService.submit(new Callable<Long>() {
                    @Override
                    public Long call() throws Exception {
                        return sequenceService.getId(tableName);
                    }
                });
                futureList.add(future);
            }

            sum = 0;
            index = 0;
            for(Future<Long> future : futureList) {
                Long result = future.get();
                System.out.println(result);
                sum += result;
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("hehe:" + Thread.currentThread().getName());
        }
        System.out.println(index);
        System.out.println(sum);
        System.out.println("end");
    }
}
