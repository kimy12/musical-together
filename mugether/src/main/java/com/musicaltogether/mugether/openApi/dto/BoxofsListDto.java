package com.musicaltogether.mugether.openApi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "boxofs")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class BoxofsListDto {

    @XmlElement(name = "boxof")
    private List<BoxofsDto> boxofsDtoInfo;
}
