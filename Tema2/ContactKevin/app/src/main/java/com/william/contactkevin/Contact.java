package com.william.contactkevin;

public class Contact {
    private final String id;
    private final String name;
    private final String firstSurname;
    private final String secondSurname;
    private final String photo;
    private final String birth;
    private final String company;
    private final String email;
    private final String phone1;
    private final String phone2;
    private final String address;

    public Contact(String id, String name, String firstSurname, String secondSurname, String photo,
                   String birth, String company, String email, String phone1, String phone2,
                   String address){
        this.id = id;
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.photo = photo;
        this.birth = birth;
        this.company = company;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public String getBirth() {
        return birth;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", birth='" + birth + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
