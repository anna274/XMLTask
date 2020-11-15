package main.entity;

public enum CovidStatus {
    HEALTHY("healthy"),
    SICK("sick"),
    SICK_NO_SYMPTOMS("sick, no symptoms"),
    FIRST_LEVEL_CONTACT("first level contact"),
    SECOND_LEVEL_CONTACT("second level contact"),
    RECOVERED("recovered"),
    ;

    private String status;

    CovidStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
