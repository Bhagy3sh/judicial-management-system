package main.model;

import java.sql.Date;

public class Petitioner extends Person {
    private Date petitionFiledDate;
    private int legalRepresentative;

    // Getters and Setters
    public Date getPetitionFiledDate() {
        return petitionFiledDate;
    }

    public void setPetitionFiledDate(Date petitionFiledDate) {
        this.petitionFiledDate = petitionFiledDate;
    }

    public int getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(int legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }
}