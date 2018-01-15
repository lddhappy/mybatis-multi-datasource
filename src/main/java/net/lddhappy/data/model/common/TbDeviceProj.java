package net.lddhappy.data.model.common;

public class TbDeviceProj {

    public TbDeviceProj() {
    }

    public TbDeviceProj(String deviceName, Integer projectId, Integer deviceType, String note) {
        this.deviceName = deviceName;
        this.projectId = projectId;
        this.deviceType = deviceType;
        this.note = note;
    }

    private Integer ID;

    private String deviceName;

    private Integer projectId;

    private Integer deviceType;

    private String note;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}