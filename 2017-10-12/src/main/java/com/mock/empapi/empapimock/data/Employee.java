package com.mock.empapi.empapimock.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Data
public class Employee {

    /**
     * Entspricht in DB: ID
     */
    private Integer id;

    /**
     * Entspricht in DB: VORNAME
     */
    private String firstName;

    /**
     * Entspricht in DB: NACHNAME
     */
    private String lastName;

    /**
     * Entspricht in DB: EMAIL
     */
    private String email;

    /**
     * Entspricht in DB: TELEFON_DIREKT
     */
    private String phone;

    /**
     * Entspricht in DB: SITZCODE
     */
    private String bankNumber;

    /**
     * Entspricht in DB: STELLE_NAME
     */
    private String jobTitle;

    /**
     * Entspricht in DB: JOBTITELNAME
     */
    private String jobRole;

    /**
     * Entspricht in DB: FUNKTION_BEZEICHNUNG
     */
    private String jobFunction;

    /**
     * Entspricht in DB: FUNKTION_STUFE
     */
    private String jobFunctionLevel;

    /**
     * Entspricht in DB: GRUPPE_NAME
     */
    private String team;

    /**
     * Entspricht in DB: DEPARTEMENT
     */
    private String department;

    /**
     * Entspricht in DB: ARBEITGEBER
     */
    private String company;

    /**
     * Entspricht in DB: EMPLOYEEID
     */
    private String empId;

    @JsonIgnore
    private URL imgFile;

    @JsonIgnore
    private PresenceState presenceState;

    public Employee(Integer id) throws IOException {
        this.id = id;
    }

    @JsonIgnore
    public InputStream getImageFile() throws IOException, NullPointerException {
        System.out.println("Bild wird angefordert für Mitarbeiter " + id + ": " + imgFile);
        return imgFile.openStream();
    }

    public Boolean isPortraitAvailable() {
        try {
            return getImageFile() != null;
        } catch (Exception e) {
            return false;
        }
    }
}
