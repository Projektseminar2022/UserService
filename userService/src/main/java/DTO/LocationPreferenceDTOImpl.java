package DTO;

import entities.LocationPreference;
import org.springframework.beans.factory.annotation.Autowired;

public class LocationPreferenceDTOImpl implements LocationPreferenceDTO {

    @Autowired
    private LocationPreference locationPreference;
    @Override
    public int getLocationPreferenceId() {
        return locationPreference.getLocationPreferenceId();
    }

    @Override
    public String getLocationPreferenceName() {
        return locationPreference.getLocationPreferenceName();
    }

    public void setLocationPreferenceId(int locationPreferenceId){
        locationPreference.setLocationPreferenceId(locationPreferenceId);
    }
    public void setLocationPreferenceName(String locationPreferenceName){
        locationPreference.setLocationPreferenceName(locationPreferenceName);
    }


}
