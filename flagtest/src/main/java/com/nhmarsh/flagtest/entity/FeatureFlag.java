package com.nhmarsh.flagtest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feature_flag")
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FeatureFlag {

    public static String NO_FLAG_VALUE = "None";

    @Column(name = "flag_name")
    @Id
    private String flagName;

    @Column(name = "flag_value")
    private String flagValue;

}
