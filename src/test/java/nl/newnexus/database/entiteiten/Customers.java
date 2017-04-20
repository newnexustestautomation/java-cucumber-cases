package nl.newnexus.database.entiteiten;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Tester on 3/28/2017.
 */
@Entity
@Table(name="customers")
public class Customers {
    private int customersId;
    private String customersGender;
    private String customersFirstname;
    private String customersLastname;
    private Timestamp customersDob;
    private String customersEmailAddress;
    private Integer customersDefaultAddressId;
    private String customersTelephone;
    private String customersFax;
    private String customersPassword;
    private String customersNewsletter;

    @Id
    @Column(name = "customers_id", nullable = false)
    public int getCustomersId() {
        return customersId;
    }

    public void setCustomersId(int customersId) {
        this.customersId = customersId;
    }

    @Basic
    @Column(name = "customers_gender", nullable = true, length = 1)
    public String getCustomersGender() {
        return customersGender;
    }

    public void setCustomersGender(String customersGender) {
        this.customersGender = customersGender;
    }

    @Basic
    @Column(name = "customers_firstname", nullable = false, length = 255)
    public String getCustomersFirstname() {
        return customersFirstname;
    }

    public void setCustomersFirstname(String customersFirstname) {
        this.customersFirstname = customersFirstname;
    }

    @Basic
    @Column(name = "customers_lastname", nullable = false, length = 255)
    public String getCustomersLastname() {
        return customersLastname;
    }

    public void setCustomersLastname(String customersLastname) {
        this.customersLastname = customersLastname;
    }

    @Basic
    @Column(name = "customers_dob", nullable = false)
    public Timestamp getCustomersDob() {
        return customersDob;
    }

    public void setCustomersDob(Timestamp customersDob) {
        this.customersDob = customersDob;
    }

    @Basic
    @Column(name = "customers_email_address", nullable = false, length = 255)
    public String getCustomersEmailAddress() {
        return customersEmailAddress;
    }

    public void setCustomersEmailAddress(String customersEmailAddress) {
        this.customersEmailAddress = customersEmailAddress;
    }

    @Basic
    @Column(name = "customers_default_address_id", nullable = true)
    public Integer getCustomersDefaultAddressId() {
        return customersDefaultAddressId;
    }

    public void setCustomersDefaultAddressId(Integer customersDefaultAddressId) {
        this.customersDefaultAddressId = customersDefaultAddressId;
    }

    @Basic
    @Column(name = "customers_telephone", nullable = false, length = 255)
    public String getCustomersTelephone() {
        return customersTelephone;
    }

    public void setCustomersTelephone(String customersTelephone) {
        this.customersTelephone = customersTelephone;
    }

    @Basic
    @Column(name = "customers_fax", nullable = true, length = 255)
    public String getCustomersFax() {
        return customersFax;
    }

    public void setCustomersFax(String customersFax) {
        this.customersFax = customersFax;
    }

    @Basic
    @Column(name = "customers_password", nullable = false, length = 60)
    public String getCustomersPassword() {
        return customersPassword;
    }

    public void setCustomersPassword(String customersPassword) {
        this.customersPassword = customersPassword;
    }

    @Basic
    @Column(name = "customers_newsletter", nullable = true, length = 1)
    public String getCustomersNewsletter() {
        return customersNewsletter;
    }

    public void setCustomersNewsletter(String customersNewsletter) {
        this.customersNewsletter = customersNewsletter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customers customers = (Customers) o;

        if (customersId != customers.customersId) return false;
        if (customersGender != null ? !customersGender.equals(customers.customersGender) : customers.customersGender != null)
            return false;
        if (customersFirstname != null ? !customersFirstname.equals(customers.customersFirstname) : customers.customersFirstname != null)
            return false;
        if (customersLastname != null ? !customersLastname.equals(customers.customersLastname) : customers.customersLastname != null)
            return false;
        if (customersDob != null ? !customersDob.equals(customers.customersDob) : customers.customersDob != null)
            return false;
        if (customersEmailAddress != null ? !customersEmailAddress.equals(customers.customersEmailAddress) : customers.customersEmailAddress != null)
            return false;
        if (customersDefaultAddressId != null ? !customersDefaultAddressId.equals(customers.customersDefaultAddressId) : customers.customersDefaultAddressId != null)
            return false;
        if (customersTelephone != null ? !customersTelephone.equals(customers.customersTelephone) : customers.customersTelephone != null)
            return false;
        if (customersFax != null ? !customersFax.equals(customers.customersFax) : customers.customersFax != null)
            return false;
        if (customersPassword != null ? !customersPassword.equals(customers.customersPassword) : customers.customersPassword != null)
            return false;
        if (customersNewsletter != null ? !customersNewsletter.equals(customers.customersNewsletter) : customers.customersNewsletter != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customersId;
        result = 31 * result + (customersGender != null ? customersGender.hashCode() : 0);
        result = 31 * result + (customersFirstname != null ? customersFirstname.hashCode() : 0);
        result = 31 * result + (customersLastname != null ? customersLastname.hashCode() : 0);
        result = 31 * result + (customersDob != null ? customersDob.hashCode() : 0);
        result = 31 * result + (customersEmailAddress != null ? customersEmailAddress.hashCode() : 0);
        result = 31 * result + (customersDefaultAddressId != null ? customersDefaultAddressId.hashCode() : 0);
        result = 31 * result + (customersTelephone != null ? customersTelephone.hashCode() : 0);
        result = 31 * result + (customersFax != null ? customersFax.hashCode() : 0);
        result = 31 * result + (customersPassword != null ? customersPassword.hashCode() : 0);
        result = 31 * result + (customersNewsletter != null ? customersNewsletter.hashCode() : 0);
        return result;
    }
}