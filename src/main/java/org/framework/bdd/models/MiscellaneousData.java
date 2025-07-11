package org.framework.bdd.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MiscellaneousData {
    private int year;
    private Double price;
    @JsonProperty("CPU model")
    private CPU cpuModel;
    @JsonProperty("Hard disk size")
    private String hardDiskSize;
}
