package com.student.management.MAINET10.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "TB_DOCUMENT")
@Data
public class DocumentEntity {
    @Column(name = "DOC_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long docId;

    @Column(name = "DOC_NAME")
    private String docName;

    @Column(name = "DOC_SIZE")
    private long docSize;

    @Column(name = "PATH")
    private String path;

    @Column(name = "DOC_TYPE")
    private String docType;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "CREATED_BY")
    private long createdBy;

}
