package model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Address {
    private String street;
    private String housenumber;
}
