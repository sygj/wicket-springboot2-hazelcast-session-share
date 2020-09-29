package koal.wicket.springboot.session.share;

import org.apache.wicket.Session;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.session.hazelcast.HazelcastIndexedSessionRepository;
import org.springframework.session.hazelcast.PrincipalNameExtractor;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.giffing.wicket.spring.boot.starter.app.WicketBootStandardWebApplication;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapAttributeConfig;
import com.hazelcast.config.MapIndexConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import koal.wicket.springboot.session.share.session.MySession;

@EnableHazelcastHttpSession
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy=true)
public class WicketApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder()
			.sources(WicketApplication.class)
			.run(args);
	}
	 @Bean
     public HazelcastInstance hazelcastInstance() {
             MapAttributeConfig attributeConfig = new MapAttributeConfig()
                             .setName(HazelcastIndexedSessionRepository.PRINCIPAL_NAME_ATTRIBUTE)
                             .setExtractor(PrincipalNameExtractor.class.getName());

             Config config = new Config();

             config.getMapConfig("spring:session:sessions") 
                             .addMapAttributeConfig(attributeConfig)
                             .addMapIndexConfig(new MapIndexConfig(
                            		 HazelcastIndexedSessionRepository.PRINCIPAL_NAME_ATTRIBUTE, false));

             return Hazelcast.newHazelcastInstance(config); 
     }
	 
	 
	 @Bean
	 public WicketBootStandardWebApplication wicketBootStandardWebApplication() {
		 return new WicketBootStandardWebApplication() {
			 //自定义session
			 @Override
		        public Session newSession(Request request, Response response) {
		            return new MySession(request);
		        }
		 }; 
	 }

}
