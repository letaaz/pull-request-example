package servletTest;

import car.tp4.servlet.AddBookServlet;
import com.mockrunner.mock.web.WebMockObjectFactory;
import com.mockrunner.servlet.ServletTestModule;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AddBookServletTest {

    private ServletTestModule tester;
    private WebMockObjectFactory factory;

    @Before
    public void setup() {
        factory = new WebMockObjectFactory();
        tester = new ServletTestModule(factory);
    }

    @Test
    public void testStatutCodeGET() {
        int expectedCode = 200;
        // instantiate the servlet
        tester.createServlet(AddBookServlet.class);
        // call doGet
        tester.doGet();
        // assertion: status code should be 500
        assertEquals(expectedCode, factory.getMockResponse().getStatusCode());
    }

    @Test
    public void testStatutCodePOST() {
        int expectedCode = 200;
        // instantiate the servlet
        tester.createServlet(AddBookServlet.class);
        // call doGet
        tester.doPost();
        // assertion: status code should be 500
        assertEquals(expectedCode, factory.getMockResponse().getStatusCode());
    }

    @Test
    public void test() throws IOException {
        tester.createServlet(AddBookServlet.class);
        tester.addRequestParameter("add_book", "http://localhost:8080");
        tester.doGet();
        assertEquals(200, factory.getMockResponse().getStatusCode());
        //BufferedReader reader = tester.getOutputAsBufferedReader();
        //System.out.println(reader.readLine().trim());

        System.out.println(tester.getOutput());

    }

}

