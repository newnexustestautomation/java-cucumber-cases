package nl.newnexus.database.entiteiten;

import javax.persistence.*;

/**
 * Created by Tester on 3/28/2017.
 */
@Entity
@Table(name = "address_book", schema = "oscommerce", catalog = "")
public class AddressBook {
    private int addressBookId;
    private int customersId;
    private String entryGender;
    private String entryCompany;
    private String entryFirstname;
    private String entryLastname;
    private String entryStreetAddress;
    private String entrySuburb;
    private String entryPostcode;
    private String entryCity;
    private String entryState;
    private int entryCountryId;
    private int entryZoneId;

    @Id
    @Column(name = "address_book_id", nullable = false)
    public int getAddressBookId() {
        return addressBookId;
    }

    public void setAddressBookId(int addressBookId) {
        this.addressBookId = addressBookId;
    }

    @Basic
    @Column(name = "customers_id", nullable = false)
    public int getCustomersId() {
        return customersId;
    }

    public void setCustomersId(int customersId) {
        this.customersId = customersId;
    }

    @Basic
    @Column(name = "entry_gender", nullable = true, length = 1)
    public String getEntryGender() {
        return entryGender;
    }

    public void setEntryGender(String entryGender) {
        this.entryGender = entryGender;
    }

    @Basic
    @Column(name = "entry_company", nullable = true, length = 255)
    public String getEntryCompany() {
        return entryCompany;
    }

    public void setEntryCompany(String entryCompany) {
        this.entryCompany = entryCompany;
    }

    @Basic
    @Column(name = "entry_firstname", nullable = false, length = 255)
    public String getEntryFirstname() {
        return entryFirstname;
    }

    public void setEntryFirstname(String entryFirstname) {
        this.entryFirstname = entryFirstname;
    }

    @Basic
    @Column(name = "entry_lastname", nullable = false, length = 255)
    public String getEntryLastname() {
        return entryLastname;
    }

    public void setEntryLastname(String entryLastname) {
        this.entryLastname = entryLastname;
    }

    @Basic
    @Column(name = "entry_street_address", nullable = false, length = 255)
    public String getEntryStreetAddress() {
        return entryStreetAddress;
    }

    public void setEntryStreetAddress(String entryStreetAddress) {
        this.entryStreetAddress = entryStreetAddress;
    }

    @Basic
    @Column(name = "entry_suburb", nullable = true, length = 255)
    public String getEntrySuburb() {
        return entrySuburb;
    }

    public void setEntrySuburb(String entrySuburb) {
        this.entrySuburb = entrySuburb;
    }

    @Basic
    @Column(name = "entry_postcode", nullable = false, length = 255)
    public String getEntryPostcode() {
        return entryPostcode;
    }

    public void setEntryPostcode(String entryPostcode) {
        this.entryPostcode = entryPostcode;
    }

    @Basic
    @Column(name = "entry_city", nullable = false, length = 255)
    public String getEntryCity() {
        return entryCity;
    }

    public void setEntryCity(String entryCity) {
        this.entryCity = entryCity;
    }

    @Basic
    @Column(name = "entry_state", nullable = true, length = 255)
    public String getEntryState() {
        return entryState;
    }

    public void setEntryState(String entryState) {
        this.entryState = entryState;
    }

    @Basic
    @Column(name = "entry_country_id", nullable = false)
    public int getEntryCountryId() {
        return entryCountryId;
    }

    public void setEntryCountryId(int entryCountryId) {
        this.entryCountryId = entryCountryId;
    }

    @Basic
    @Column(name = "entry_zone_id", nullable = false)
    public int getEntryZoneId() {
        return entryZoneId;
    }

    public void setEntryZoneId(int entryZoneId) {
        this.entryZoneId = entryZoneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressBook that = (AddressBook) o;

        if (addressBookId != that.addressBookId) return false;
        if (customersId != that.customersId) return false;
        if (entryCountryId != that.entryCountryId) return false;
        if (entryZoneId != that.entryZoneId) return false;
        if (entryGender != null ? !entryGender.equals(that.entryGender) : that.entryGender != null) return false;
        if (entryCompany != null ? !entryCompany.equals(that.entryCompany) : that.entryCompany != null) return false;
        if (entryFirstname != null ? !entryFirstname.equals(that.entryFirstname) : that.entryFirstname != null)
            return false;
        if (entryLastname != null ? !entryLastname.equals(that.entryLastname) : that.entryLastname != null)
            return false;
        if (entryStreetAddress != null ? !entryStreetAddress.equals(that.entryStreetAddress) : that.entryStreetAddress != null)
            return false;
        if (entrySuburb != null ? !entrySuburb.equals(that.entrySuburb) : that.entrySuburb != null) return false;
        if (entryPostcode != null ? !entryPostcode.equals(that.entryPostcode) : that.entryPostcode != null)
            return false;
        if (entryCity != null ? !entryCity.equals(that.entryCity) : that.entryCity != null) return false;
        if (entryState != null ? !entryState.equals(that.entryState) : that.entryState != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressBookId;
        result = 31 * result + customersId;
        result = 31 * result + (entryGender != null ? entryGender.hashCode() : 0);
        result = 31 * result + (entryCompany != null ? entryCompany.hashCode() : 0);
        result = 31 * result + (entryFirstname != null ? entryFirstname.hashCode() : 0);
        result = 31 * result + (entryLastname != null ? entryLastname.hashCode() : 0);
        result = 31 * result + (entryStreetAddress != null ? entryStreetAddress.hashCode() : 0);
        result = 31 * result + (entrySuburb != null ? entrySuburb.hashCode() : 0);
        result = 31 * result + (entryPostcode != null ? entryPostcode.hashCode() : 0);
        result = 31 * result + (entryCity != null ? entryCity.hashCode() : 0);
        result = 31 * result + (entryState != null ? entryState.hashCode() : 0);
        result = 31 * result + entryCountryId;
        result = 31 * result + entryZoneId;
        return result;
    }
}
