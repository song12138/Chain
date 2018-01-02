package xmlParse.sax;

import com.sun.org.apache.xml.internal.resolver.readers.SAXParserHandler;
import org.xml.sax.SAXException;
import xmlParse.Book;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by paul on 2017/12/22.
 */
public class SaxParse {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SaxParserHandler saxParserHandler = new SaxParserHandler();
            saxParser.parse("src/main/resources/book.xml", saxParserHandler);

            for (Book book : saxParserHandler.getBookList()) {
                System.out.println(book.getId());
                System.out.println(book.getName());
                System.out.println(book.getAuthor());
                System.out.println(book.getYear());
                System.out.println(book.getPrice());
                System.out.println(book.getLanguage());
                System.out.println("----finish----");
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
