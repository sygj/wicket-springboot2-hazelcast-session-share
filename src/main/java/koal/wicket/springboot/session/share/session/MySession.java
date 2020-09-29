package koal.wicket.springboot.session.share.session;

import org.apache.wicket.request.Request;

import com.giffing.wicket.spring.boot.starter.configuration.extensions.external.spring.security.SecureWebSession;

public class MySession extends SecureWebSession{
	private static final long serialVersionUID = 8902247204028086956L;

	public MySession(Request request) {
		super(request);
	}

}
