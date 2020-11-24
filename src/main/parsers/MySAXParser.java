package main.parsers;

import main.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class MySAXParser extends DefaultHandler{
    private static final Hospital hospital = new Hospital();
    private static Department lastDepartment = null;
    private static Ward lastWard = null;

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MySAXParser.XMLHandler handler = new MySAXParser.XMLHandler();
        parser.parse(new File("src/resources/hospital.xml"), handler);

        Hospital.printHospitalInfo(hospital);
    }

    public static Hospital parseHospitalXml(String url) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MySAXParser.XMLHandler handler = new MySAXParser.XMLHandler();
        parser.parse(new File(url), handler);

        return hospital;
    }

    private static class XMLHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            if (qName.equals("hospital")) {
                String name = attributes.getValue("name");
                hospital.setName(name);
            }

            if (qName.equals("department")) {
                lastDepartment = new Department();
                String name = attributes.getValue("name");
                String phone = attributes.getValue("phone");
                lastDepartment.setName(name);
                lastDepartment.setPhone(phone);
            }
            if (qName.equals("ward")) {
                lastWard = new Ward();
                Integer placesNumber = Integer.parseInt(attributes.getValue("placesNumber"));
                Integer number  = Integer.parseInt(attributes.getValue("number"));
                String doctor = attributes.getValue("doctor");
                lastWard.setDoctor(doctor);
                lastWard.setNumber(number);
                lastWard.setPlacesNumber(placesNumber);
            }
            if (qName.equals("patient")) {
                Patient patient = new Patient.PatientBuilder()
                        .setName(attributes.getValue("name"))
                        .setAge(Integer.parseInt(attributes.getValue("age")))
                        .setDiagnosis(attributes.getValue("diagnosis"))
                        .setCovidStatus(attributes.getValue("covidStatus"))
                        .build();
                if(attributes.getValue("insuranceNumber") != null){
                    patient.setInsuranceNumber(attributes.getValue("insuranceNumber"));
                }
                if(attributes.getValue("covidStateCode") != null){
                    patient.setCovidStateCode(Integer.parseInt(attributes.getValue("covidStateCode")));
                }
                lastWard.addPatient(patient);
            }

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("department")) {
                hospital.addDepartment(lastDepartment);
                lastDepartment = null;
            }
            if (qName.equals("ward")) {
                lastDepartment.addWard(lastWard);
                lastWard = null;
            }
        }

    }
}
