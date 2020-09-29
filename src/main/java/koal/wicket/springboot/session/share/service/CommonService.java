package koal.wicket.springboot.session.share.service;

import java.io.Serializable;
import java.util.Map;

public interface CommonService  extends Serializable {
	
	Map<String, Object> getDataByPk(Object pk,String... fields) throws Exception;

}
