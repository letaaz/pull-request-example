//package servletTest;
//
//import car.tp4.bean.BookBeanServiceItrf;
//import car.tp4.dataBase.Book;
//import car.tp4.servlet.AddBookServlet;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//public class AddBookTest {
//
//        @Mock
//        private HttpServletResponse response;
//
//        @Mock
//        private HttpServletRequest request;
//
//        @Mock
//        private RequestDispatcher requestDispatcher;
//
//        @Mock
//        private BookBeanServiceItrf bookBeanService;
//
//        @Before
//        public void setUp() {
//            MockitoAnnotations.initMocks(this);
//        }
//
//        @Test
//        public void testDoGet() throws Exception {
//            List<Book> books = new ArrayList<Book>() {{
//                add(new Book());
//                add(new Book());
//            }};
//
//            //when(bookBeanService.getAllBooks()).thenReturn(books);
//            when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
//
//            AddBookServlet servlet = new AddBookServlet();
//            servlet.doGet(request, response);
//
//            verify(request).setAttribute("books", books);
//            verify(request).getRequestDispatcher("books.jsp");
//        }
//    }
//
