package org.framework.bdd.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Gadget {
    private String id;
    private String name;
    private MiscellaneousData data;
}
