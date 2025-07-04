package _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_blacklist_subjects")
public class BlacklistSubject {

    @Id
    @Column(name = "id")
    private long id;

    @ManyToOne
    private Download download;

    @Column(name = "blacklist")
    private String blacklist;

    @Column(name = "subject_type")
    private String subjectType;

    @Column(name = "name")
    private String name;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "pasport_series")
    private String passportSeries;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "comment")
    private String comment;

    @Column(name = "is_published")
    private boolean isPublished;

}

