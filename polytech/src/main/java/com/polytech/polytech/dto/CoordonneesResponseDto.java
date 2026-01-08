package com.polytech.polytech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordonneesResponseDto {
    private Long id;
    private String latitude;
    private String longitude;
    private List<Long> boiteId;


    public void setBoiteId(List<Long> boiteId) {
        this.boiteId = boiteId;
    }


    public List<Long> getBoiteId() {
        return boiteId;
    }


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }


    public void setId(Long id) {
        this.id = id;
    }

}
