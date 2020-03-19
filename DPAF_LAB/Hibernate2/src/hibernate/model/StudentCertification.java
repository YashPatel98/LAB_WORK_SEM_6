/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Yash
 */
@Entity
@Table(name="STUDENTCERTIFICATION")
public class StudentCertification {
    @Id @GeneratedValue
    private int certificationId;
    private String certificationName;

    public StudentCertification() {
    }

    public StudentCertification(String certificationName) {
        this.certificationName = certificationName;
    }

    public int getCertificationId() {
        return certificationId;
    }

    public String getCertificationName() {
        return certificationName;
    }

    public void setCertificationName(String certificationName) {
        this.certificationName = certificationName;
    }
    
    
}
