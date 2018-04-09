package io.zipcoder.domain;

import javax.persistence.*;

/**
 * project: zcwbank
 * package: io.zipcoder.domain
 * author: https://github.com/vvmk
 * date: 4/9/18
 */

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String first_name;
    private String last_name;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
