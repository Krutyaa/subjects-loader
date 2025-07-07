package _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity;

import lombok.Data;

@Data
public class Info {
    private Long id;
    private String dt;
    private String nameOrg;
    private String inn;
    private String addr;
    private String site;
    private String info;
    private String dateUpdate;
    private boolean isLikvid;
    private String comment;
}
