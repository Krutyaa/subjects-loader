package _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity;

import lombok.Data;

import java.util.List;

@Data
public class CbrResponse {
    private List<Info> info;
    private List<Theme> signs;
    private List<Region> regions;
}
