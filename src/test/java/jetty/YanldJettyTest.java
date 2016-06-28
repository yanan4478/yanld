package jetty;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by yanan on 16/6/22.
 */
public class YanldJettyTest {

    public static void doStart() {
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
