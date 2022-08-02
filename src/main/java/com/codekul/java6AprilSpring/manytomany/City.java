package com.codekul.java6AprilSpring.manytomany;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String cityCode;

    @ManyToMany
    @JoinTable(name = "city_pin_code",joinColumns = {@JoinColumn(name = "city_id",referencedColumnName = "id")},
            inverseJoinColumns ={@JoinColumn(name = "Pin_id",referencedColumnName = "id")} )
    private List<PinCode> pinCodes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public List<PinCode> getPinCodes() {
        return pinCodes;
    }

    public void setPinCodes(List<PinCode> pinCodes) {
        this.pinCodes = pinCodes;
    }
}
