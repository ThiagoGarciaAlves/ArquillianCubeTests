package br.eti.thiagogarciaalves.arquillian.cube;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
public class HelloWorldServletTest {

	@Deployment(testable=false)
	public static WebArchive create() {
		return ShrinkWrap.create(WebArchive.class, "hello.war").addClass(HelloWorldServlet.class);
	}

	@Test
	public void should_parse_and_load_configuration_file(@ArquillianResource URL resource) throws IOException {

		URL obj = new URL(resource, "HelloWorld");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		assertThat(response.toString(), is("Hello World"));

	}

}
