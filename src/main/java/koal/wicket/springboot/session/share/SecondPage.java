package koal.wicket.springboot.session.share;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.spring.injection.annot.SpringBean;

import koal.wicket.springboot.session.share.service.DeviceCertService;
import koal.wicket.springboot.session.share.service.UserService;
import koal.wicket.springboot.session.share.session.MySession;

public class SecondPage extends WebPage {
	@SpringBean
	private UserService userService;
	@SpringBean
	private DeviceCertService deviceCertService;
	private static final long serialVersionUID = 1052899690809221495L;

	public SecondPage() throws Exception {
		super();
		deviceCertService.getDataByCertId(null, 1, false);
		Request request = RequestCycle.get().getRequest();
		HttpServletRequest httpRequest = (HttpServletRequest) request.getContainerRequest();
		HttpSession session = httpRequest.getSession();
		Label sessionLabel = new Label("session", Model.of(session.getId()+" : hello="+userService.hello()));
		Session sessionWicket = Session.get();
		add(sessionLabel);
		System.out.println(sessionWicket.getId());
		Session session2 = getAppSession();
		System.out.println(session2);
		
	}
	public final MySession getAppSession() {
		return (MySession) getSession();
	}

	

}
