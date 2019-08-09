import com.cinglevue.data.db.Mongo;
import com.cinglevue.service.StudentService;
import com.cinglevue.service.impl.StudenServiceImpl;
import com.google.inject.AbstractModule;
import com.typesafe.config.Config;

import play.Environment;
import play.libs.akka.AkkaGuiceSupport;

/**
 * @author mhashendre
 *
 */
public class Module extends AbstractModule implements AkkaGuiceSupport{

	private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(getClass().getName());

	private final Config configuration;

	public Module(Environment environment, Config configuration) {
		logger.info("Module Started !");
		this.configuration = configuration;
		Mongo.setConfiguration(this.configuration);
	}

	@Override
	protected void configure() {
		logger.info("Module Configuration Started ");
		bind(StudentService.class).to(StudenServiceImpl.class);
		
	}
	
}
