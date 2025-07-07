package _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "t_download_history")
public class Download {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "blacklist")
    private String blacklist;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "status")
    private String status;

    @Column(name = "comment")
    private String comment;

}
