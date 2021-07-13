package com.dm.nabidm.orm.domain;


import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@TableGenerator(
        name = "boardTableGen",
        table = "SEQUENCE_TABLE",
        allocationSize=1
)
public class Board {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="boardTableGen")
    @Column(columnDefinition = "int")
    private Integer id;

    @Column(nullable = false, columnDefinition = "text")
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String content;

    @Column(nullable = false, columnDefinition = "varchar(2) default 'N' ")
    private String deleteYn;

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
