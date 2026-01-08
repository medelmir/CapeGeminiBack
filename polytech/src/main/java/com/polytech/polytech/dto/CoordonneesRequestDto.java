package com.polytech.polytech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordonneesRequestDto {
    private String latitude;
    private String longitude;

    private Long boiteId;


    public Long getBoiteId() {
        return boiteId;
    }

    public void setBoiteId(Long boiteId) {
        this.boiteId = boiteId;
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


}
