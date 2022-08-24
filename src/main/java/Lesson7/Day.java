package Lesson7;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Day {

    @JsonProperty(value = "Icon")
    private String icon;
    @JsonProperty(value = "IconPhrase")
    private String iconPhrase;
    @JsonProperty(value = "HasPrecipitation")
    private String hasPrecipitation;
    @JsonProperty(value = "PrecipitationType")
    private String precipitationType;
    @JsonProperty(value = "PrecipitationIntensity")
    private String precipitationIntensity;


     String getIconPhrase() {
        if(iconPhrase.equals("Sunny")) {
            return "Солнечно";
        } else if(iconPhrase.equals("Mostly cloudy")) {
            return "Немного облачно";
        } else {
            return iconPhrase;
        }
    }
}
