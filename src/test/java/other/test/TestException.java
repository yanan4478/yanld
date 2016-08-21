package other.test;

import com.yanld.module.common.util.StackTraceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanan on 16/8/18.
 */
public class TestException {

    private static Logger logger = LoggerFactory.getLogger(TestException.class);

    public static void main(String[] args) throws Exception {
        try {
            ex();
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
        }
    }

    private static void ex() {
        List<String> list = new ArrayList<>();
        list.add(1+ "");
        list.get(1);
    }
}
