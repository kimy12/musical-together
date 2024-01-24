package com.musicaltogether.mugether.openApi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "boxofs")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoxofsListDto {

    private List<BoxofsDto> boxofsDtoInfo;

    @XmlElementWrapper(name="boxofs")
    public List<BoxofsDto> getBoxofsDtoInfo() {
        return boxofsDtoInfo;
    }

    public void setMemberInfo(List<BoxofsDto> boxofsDtoInfo) {
        this.boxofsDtoInfo = boxofsDtoInfo;
    }

}
