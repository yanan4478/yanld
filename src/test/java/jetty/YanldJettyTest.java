package jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.Map;
import java.util.Properties;

/**
 * Created by yanan on 16/6/22.
 */
public class YanldJettyTest {

    public static void doStart() {
        System.setProperty("log4j.configuration", "file:/Users/yanan/gitHub/yanld/src/main/resources/config/log4j.properties");

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        webAppContext.setDescriptor("./webapp/WEB-INF/web.xml");
        webAppContext.setResourceBase("./webapp");
        webAppContext.setClassLoader(Thread.currentThread().getContextClassLoader());
        Server server = new Server(8888);
        server.setHandler(webAppContext);
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        doStart();
    }
}
