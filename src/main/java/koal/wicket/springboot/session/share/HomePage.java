package koal.wicket.springboot.session.share;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;

@WicketHomePage
public class HomePage extends WebPage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomePage() {
		Form<?> form = new Form<Object>("form"){
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
					setResponsePage(SecondPage.class);
			}
		};
		queue(form);
		
		
		add(new Link<Void>("mylink") {

			private static final long serialVersionUID = 435995696249606846L;

					@Override
					public void onClick() {
						setResponsePage(SecondPage.class);
					}
		        	
		        });
	}
}
