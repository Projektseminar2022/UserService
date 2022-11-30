package entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "location_preference", schema = "seminarUserService")
public class LocationPreference {


    private int locationPreferenceId;


    private String locationPreferenceName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_preference_id")
    public int getLocationPreferenceId() {
        return locationPreferenceId;
    }

    public void setLocationPreferenceId(int locationPreferenceId) {
        this.locationPreferenceId = locationPreferenceId;
    }

    @Basic
    @Column(name = "location_preference_name")
    public String getLocationPreferenceName() {
        return locationPreferenceName;
    }

    public void setLocationPreferenceName(String locationPreferenceName) {
        this.locationPreferenceName = locationPreferenceName;
    }
}