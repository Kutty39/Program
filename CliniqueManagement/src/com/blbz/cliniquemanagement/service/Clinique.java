package com.blbz.cliniquemanagement.service;

import java.util.List;

public interface Clinique {
    void addDoctor(String name, String specialization, String availability);

    void addPatient(String pname, String ph, String age);

    String validateID(String string);

    void getAppointment(String date, String person);

    List<String> searchDoctor(String string);

    void createAppointment(String ptid, String dcid, String date);
}
