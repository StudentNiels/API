package Models;

public class Country {
    private String country;
    private String region;
    private String family;
    private double freedom;
    private double generosity;
    private int happinessRank;
    private double happinessScore;
    private double standardError;
    private double economyGdp;
    private double healthLifeExpectancy;
    private double trustInGovernment;
    private double dystopiaResidual;

    public Country(String country, String region, String family, double freedom, double generosity, int happinessRank, double happinessScore, double standardError, double economyGdp, double healthLifeExpectancy, double trustInGovernment, double dystopiaResidual) {
        this.country = country;
        this.region = region;
        this.family = family;
        this.freedom = freedom;
        this.generosity = generosity;
        this.happinessRank = happinessRank;
        this.happinessScore = happinessScore;
        this.standardError = standardError;
        this.economyGdp = economyGdp;
        this.healthLifeExpectancy = healthLifeExpectancy;
        this.trustInGovernment = trustInGovernment;
        this.dystopiaResidual = dystopiaResidual;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public double getFreedom() {
        return freedom;
    }

    public void setFreedom(double freedom) {
        this.freedom = freedom;
    }

    public double getGenerosity() {
        return generosity;
    }

    public void setGenerosity(double generosity) {
        this.generosity = generosity;
    }

    public int getHappinessRank() {
        return happinessRank;
    }

    public void setHappinessRank(int happinessRank) {
        this.happinessRank = happinessRank;
    }

    public double getHappinessScore() {
        return happinessScore;
    }

    public void setHappinessScore(double happinessScore) {
        this.happinessScore = happinessScore;
    }

    public double getStandardError() {
        return standardError;
    }

    public void setStandardError(double standardError) {
        this.standardError = standardError;
    }

    public double getEconomyGdp() {
        return economyGdp;
    }

    public void setEconomyGdp(double economyGdp) {
        this.economyGdp = economyGdp;
    }

    public double getHealthLifeExpectancy() {
        return healthLifeExpectancy;
    }

    public void setHealthLifeExpectancy(double healthLifeExpectancy) {
        this.healthLifeExpectancy = healthLifeExpectancy;
    }

    public double getTrustInGovernment() {
        return trustInGovernment;
    }

    public void setTrustInGovernment(double trustInGovernment) {
        this.trustInGovernment = trustInGovernment;
    }

    public double getDystopiaResidual() {
        return dystopiaResidual;
    }

    public void setDystopiaResidual(double dystopiaResidual) {
        this.dystopiaResidual = dystopiaResidual;
    }


}
