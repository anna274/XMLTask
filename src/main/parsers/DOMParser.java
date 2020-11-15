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
        System.out.println(hospital);
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
        Patient patient = new Patient();
        NamedNodeMap attributes = patientNode.getAttributes();
        patient.setName(attributes.getNamedItem("name").getNodeValue());
        patient.setAge(Integer.parseInt(attributes.getNamedItem("age").getNodeValue()));
        patient.setCovidStatus(attributes.getNamedItem("covidStatus").getNodeValue());
        patient.setDiagnosis(attributes.getNamedItem("diagnosis").getNodeValue());
        Node insuranceNumberNode = attributes.getNamedItem("insuranceNumber");
        if(insuranceNumberNode != null) {
            patient.setInsuranceNumber(Long.parseLong(insuranceNumberNode.getNodeValue()));
        }
        return patient;
    }
}
