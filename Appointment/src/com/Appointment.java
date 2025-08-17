package com;

import java.util.Date;


public class Appointment {
	//variables are private so they can only be modifeid by the class
	//and final so they can't be changed after initialization 
 private final String id;
 private final Date appointmentDate;
 private final String description;

 public Appointment(String id, Date appointmentDate, String description) {
     if (id == null || id.isEmpty() || id.length() > 10) {
         throw new IllegalArgumentException("Appointment ID must not be null, not be empty, and be 10 characters or less.");
     }
     if (appointmentDate == null || appointmentDate.before(new Date())) {
         throw new IllegalArgumentException("Appointment date must be non-null and not in the past.");
     }
     if (description == null || description.isEmpty() || description.length() > 50) {
         throw new IllegalArgumentException("Description must not be null, not be empty, and be 50 characters or less.");
     }
     this.id = id;
     this.appointmentDate = appointmentDate;
     this.description = description;
 }

 
 //getters 
 public String getId() {
     return id;
 }

 public Date getAppointmentDate() {
     return appointmentDate;
 }

 public String getDescription() {
     return description;
 }
}