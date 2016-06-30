package jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created by yanan on 16/6/22.
 */
public class YanldJettyTest {
    private static final int PORT = 8888;

    private static ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

    public static void doStart() throws Exception {
        String webDefault = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "**/webdefault.xml";
        Resource web = resolver.getResources(webDefault)[0];
        String descriptor = web.getFile().getAbsolutePath();

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        webAppContext.setDefaultsDescriptor(descriptor);
        webAppContext.setResourceBase(descriptor.replaceAll("target.*$", "webapp"));
        //webAppContext.setWar("/usr/local/jetty/webapps/yanld-1.0-SNAPSHOT.war");
        webAppContext.setClassLoader(Thread.currentThread().getContextClassLoader());

        Server server = new Server(PORT);
        server.addLifeCycleListener(new AbstractLifeCycle.AbstractLifeCycleListener() {
            @Override
            public void lifeCycleStarted(LifeCycle event) {
                System.out.println("------------------------YanldJetty started! Port:" + PORT + "------------------------");
            }
        });
        server.setHandler(webAppContext);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        doStart();
    }
}
