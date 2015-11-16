package fragz.com.dataapp;

/**
 * Created by bill on 11/13/15.
 */
public class DataHolder {
    int id;
    String company_name;
    long credit_card;
    String email;
    String first_name;
    String last_name;
    String country;

    public String getCompany() {
        return company_name;
    }

    public long getCredit_card() {
        return credit_card;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public int getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }


    public String getCountry() {
        return country;
    }
    DataHolder(int id, String company,long credit_card,String email,String country, String first_name,String last_name){
        this.id=id;
        this.company_name = company;
        this.country = country;
        this.credit_card = credit_card;
        this. email = email;
        this. first_name = first_name;
        this.last_name = last_name;

    }
}
