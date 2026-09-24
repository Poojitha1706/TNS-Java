package com.mallmanagement.mall_management_service;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Mall.java
 * @Entity tells Spring Data JPA this class maps directly to a database table.
 */
@Entity
@Table(name = "mall")
public class Mall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mall_id")
    private int mallId;

    @NotBlank
    @Column(name = "mall_name", nullable = false, length = 100)
    private String mallName;

    @NotBlank
    @Column(name = "location", nullable = false, length = 150)
    private String location;

    @NotNull
    @Column(name = "total_floors", nullable = false)
    private int totalFloors;

    @NotNull
    @Column(name = "total_shops", nullable = false)
    private int totalShops;

    @NotBlank
    @Column(name = "opening_time", nullable = false, length = 20)
    private String openingTime;

    @NotBlank
    @Column(name = "closing_time", nullable = false, length = 20)
    private String closingTime;

    @Column(name = "contact_number", length = 15)
    private String contactNumber;

    public Mall() {
    }

    public Mall(String mallName, String location, int totalFloors, int totalShops,
                String openingTime, String closingTime, String contactNumber) {
        this.mallName = mallName;
        this.location = location;
        this.totalFloors = totalFloors;
        this.totalShops = totalShops;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.contactNumber = contactNumber;
    }

    public int getMallId() { return mallId; }
    public void setMallId(int mallId) { this.mallId = mallId; }

    public String getMallName() { return mallName; }
    public void setMallName(String mallName) { this.mallName = mallName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getTotalFloors() { return totalFloors; }
    public void setTotalFloors(int totalFloors) { this.totalFloors = totalFloors; }

    public int getTotalShops() { return totalShops; }
    public void setTotalShops(int totalShops) { this.totalShops = totalShops; }

    public String getOpeningTime() { return openingTime; }
    public void setOpeningTime(String openingTime) { this.openingTime = openingTime; }

    public String getClosingTime() { return closingTime; }
    public void setClosingTime(String closingTime) { this.closingTime = closingTime; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}