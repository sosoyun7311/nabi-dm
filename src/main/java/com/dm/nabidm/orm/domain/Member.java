package com.dm.nabidm.orm.domain;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@TableGenerator(
        name = "memberTableGen",
        table = "SEQUENCE_TABLE",
        allocationSize=1
)
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="memberTableGen")
    @Column(columnDefinition = "int")
    private Integer id;

    @Column(nullable = true, columnDefinition = "varchar(20) default ''")
    private String role;

    @Column(nullable = true, columnDefinition = "varchar(20) default ''")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(80) ")
    private String passwd;

    @Column(nullable=false, columnDefinition = "varchar(1) default 'N' ")
    private String deleted;

    @Column(nullable = true, columnDefinition = "TIMESTAMP default '1970-01-01 00:00:00'")
    private Date registrationDate;

    @Column(nullable = false, columnDefinition = "int")
    private Integer registrationId;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String registrationIp;

    @Column(nullable = true, columnDefinition = "TIMESTAMP default '1970-01-01 00:00:00'")
    private Date modificationDate;

    @Column(nullable = true, columnDefinition = "int")
    private Integer modificationId;

    @Column(nullable = true, columnDefinition = "varchar(20)")
    private String modificationIp;
}
