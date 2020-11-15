package main;

import main.Employee;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXExample {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File("src/resource/company.xml"), handler);

        for (Employee employee : employees)
            System.out.println(String.format("Имя сотрудника: %s, его должность: %s", employee.getName(), employee.getJob()));
    }

    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {

            // Тут будет логика реакции на начало документа

        }

        @Override
        public void endDocument() throws SAXException {

            // Тут будет логика реакции на конец документа

        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Тут будет логика реакции на начало элемента
            // uri — это пространство, в котором находится элемент,
            // localName — это имя элемента без префикса,
            // qName — это имя элемента с префиксом (если он есть, иначе просто имя элемента).

            if (qName.equals("employee")) {
                String name = attributes.getValue("name");
                String job = attributes.getValue("job");
                employees.add(new Employee(name, job));
            }

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            // Тут будет логика реакции на конец элемента

        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Тут будет логика реакции на текст между элементами

        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

            // Тут будет логика реакции на пустое пространство внутри элементов (пробелы, переносы строчек и так далее).

        }
    }

    private static class AdvancedXMLHandler extends DefaultHandler {
        private String name, job, lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("name"))
                    name = information;
                if (lastElementName.equals("job"))
                    job = information;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ((name != null && !name.isEmpty()) && (job != null && !job.isEmpty())) {
                employees.add(new Employee(name, job));
                name = null;
                job = null;
            }
        }
    }
}
