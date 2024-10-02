package com.william.listviewpaisos;

public class Country {

    private String countryName;
    private String countryCode;
    private String population;
    private String capital;

    public Country(String countryName, String countryCode, String population, String capital){
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.population = population;
        this.capital = capital;
    }


    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", population='" + population + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }
}
