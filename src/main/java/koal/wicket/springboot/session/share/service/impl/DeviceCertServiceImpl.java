package koal.wicket.springboot.session.share.service.impl;

import java.sql.Connection;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import koal.wicket.springboot.session.share.aop.anotation.TransactionalSelf;
import koal.wicket.springboot.session.share.service.DeviceCertMidService;
import koal.wicket.springboot.session.share.service.DeviceCertService;
import koal.wicket.springboot.session.share.service.DeviceService;
import koal.wicket.springboot.session.share.service.OrderService;
import koal.wicket.springboot.session.share.service.PlateCertService;



@Service
public class DeviceCertServiceImpl implements DeviceCertService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8776392262831490737L;

	@Resource
	private OrderService orderService;

	@Resource
	private PlateCertService plateCertService;

	@Resource
	private DeviceService deviceService;

	@Resource
	private DeviceCertService deviceCertService;

	@Resource
	private DeviceCertMidService deviceCertMidService;

	@Override
	@TransactionalSelf
	public Map<String, Object> getDataByCertId(Connection conn, Object certId, boolean isView) throws Exception {
		return null;
	}
	
	
	
	
	

}
