package koal.wicket.springboot.session.share.service;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Map;

import org.springframework.lang.NonNull;


public interface DeviceCertService extends  Serializable{
	Map<String, Object> getDataByCertId(Connection conn, @NonNull Object certId, boolean isView) throws Exception;

}
