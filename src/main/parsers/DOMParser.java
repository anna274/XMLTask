package main.parsers;

import main.entity.Department;
import main.entity.Hospital;
import main.entity.Patient;
import main.entity.Ward;
import main.util.PrintEntityUtils;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.stream.IntStream;

public class DOMParser {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("src/resources/hospital.xml");
        Element root = document.getDocumentElement();

        NodeList nodeList = root.getElementsByTagName("hospital");
        IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item)
                .map(node -> parseHospitalElement((Element) node))
                .forEach(PrintEntityUtils::printHospitalInfo);
    }

    private static Hospital parseHospitalElement(Element hospitalElement) {
        Hospital hospital = new Hospital();
        NamedNodeMap attributes = hospitalElement.getAttributes();
        hospital.setName(attributes.getNamedItem("name").getNodeValue());
        NodeList departmentNodes = hospitalElement.getElementsByTagName("department");
        IntStream.range(0, departmentNodes.getLength())
                .mapToObj(i -> parseDepartmentElement((Element) departmentNodes.item(i)))
                .forEach(hospital::addDepartment);
        return hospital;
    }

    private static Department parseDepartmentElement(Element departmentElement) {
        Department department = new Department();
        NamedNodeMap attributes = departmentElement.getAttributes();
        department.setName(attributes.getNamedItem("name").getNodeValue());
        department.setPhone(attributes.getNamedItem("phone").getNodeValue());
        NodeList wardsNodes = departmentElement.getElementsByTagName("ward");
        IntStream.range(0, wardsNodes.getLength())
                .mapToObj(i -> parseWardElement((Element) wardsNodes.item(i)))
                .forEach(department::addWard);
        return department;
    }

    private static Ward parseWardElement(Element wardNode) {
        Ward ward = new Ward();
        NamedNodeMap attributes = wardNode.getAttributes();
        ward.setNumber(Integer.parseInt(attributes.getNamedItem("number").getNodeValue()));
        ward.setPlacesNumber(Integer.parseInt(attributes.getNamedItem("placesNumber").getNodeValue()));
        ward.setDoctor(attributes.getNamedItem("doctor").getNodeValue());
        NodeList patientNodes = wardNode.getElementsByTagName("patient");
        IntStream.range(0, patientNodes.getLength())
                .mapToObj(i -> parsePatientElement((Element) patientNodes.item(i)))
                .forEach(ward::addPatient);
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
            patient.setInsuranceNumber(insuranceNumberNode.getNodeValue());
        }
        return patient;
    }
}
