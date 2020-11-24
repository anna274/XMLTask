package main.parsers;

import main.entity.Department;
import main.entity.Hospital;
import main.entity.Patient;
import main.entity.Ward;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParser {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("src/resources/hospital.xml");
        Element root = document.getDocumentElement();
        Node hospitalNode = root.getElementsByTagName("hospital").item(0);
        Hospital hospital = parseHospitalElement((Element)hospitalNode);
        Hospital.printHospitalInfo(hospital);
    }

    public static Hospital parseHospitalXml(String url) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            Document document = null;
            document = builder.parse(url);
            Element root = document.getDocumentElement();
            Node hospitalNode = root.getElementsByTagName("hospital").item(0);
            return parseHospitalElement((Element)hospitalNode);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Hospital parseHospitalElement(Element hospitalElement) {
        Hospital hospital = new Hospital();
        NamedNodeMap attributes = hospitalElement.getAttributes();
        hospital.setName(attributes.getNamedItem("name").getNodeValue());
        NodeList departmentNodes = hospitalElement.getElementsByTagName("department");
        for (int i = 0; i < departmentNodes.getLength(); i++) {
            hospital.addDepartment(parseDepartmentElement((Element)departmentNodes.item(i)));
        }
        return hospital;
    }

    private static Department parseDepartmentElement(Element departmentElement) {
        Department department = new Department();
        NamedNodeMap attributes = departmentElement.getAttributes();
        department.setName(attributes.getNamedItem("name").getNodeValue());
        department.setPhone(attributes.getNamedItem("phone").getNodeValue());
        NodeList wardsNodes = departmentElement.getElementsByTagName("ward");
        for (int i = 0; i < wardsNodes.getLength(); i++) {
            department.addWard(parseWardElement((Element)wardsNodes.item(i)));
        }
        return department;
    }

    private static Ward parseWardElement(Element wardNode) {
        Ward ward = new Ward();
        NamedNodeMap attributes = wardNode.getAttributes();
        ward.setNumber(Integer.parseInt(attributes.getNamedItem("number").getNodeValue()));
        ward.setPlacesNumber(Integer.parseInt(attributes.getNamedItem("placesNumber").getNodeValue()));
        ward.setDoctor(attributes.getNamedItem("doctor").getNodeValue());
        NodeList patientNodes = wardNode.getElementsByTagName("patient");
        for (int i = 0; i < patientNodes.getLength(); i++) {
            ward.addPatient(parsePatientElement((Element)patientNodes.item(i)));
        }
        return ward;
    }

    private static Patient parsePatientElement(Element patientNode) {
        NamedNodeMap attributes = patientNode.getAttributes();
        Patient patient = new Patient.PatientBuilder()
                .setName(attributes.getNamedItem("name").getNodeValue())
                .setAge(Integer.parseInt(attributes.getNamedItem("age").getNodeValue()))
                .setDiagnosis(attributes.getNamedItem("diagnosis").getNodeValue())
                .setCovidStatus(attributes.getNamedItem("covidStatus").getNodeValue())
                .build();
        Node insuranceNumberNode = attributes.getNamedItem("insuranceNumber");
        Node covidStateCodeNode = attributes.getNamedItem("covidStateCode");
        if(insuranceNumberNode != null) {
            patient.setInsuranceNumber(insuranceNumberNode.getNodeValue());
        }
        if(covidStateCodeNode != null) {
            patient.setCovidStateCode(Integer.parseInt(covidStateCodeNode.getNodeValue()));
        }
        return patient;
    }
}
