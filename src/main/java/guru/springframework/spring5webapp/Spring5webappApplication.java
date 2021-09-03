package guru.springframework.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring5webappApplication {

    public static void main(String[] args) throws Exception {

        //se comenta código debido que se utilizará un servidor local
        /*Configuration config = new ConfigurationImpl();
        config.setPersistenceEnabled(false);
        config.setSecurityEnabled(false);
        config.setJournalDirectory("target/data/journal");
        config.getAcceptorConfigurations().add(new TransportConfiguration(NettyAcceptorFactory.class.getName()));
        ActiveMQServers.newActiveMQServer(config);*/

        SpringApplication.run(Spring5webappApplication.class, args);
    }
}
