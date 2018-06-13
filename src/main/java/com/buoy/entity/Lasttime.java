package com.buoy.entity;

public class Lasttime {
    private Integer ltId;

    private String ltBuoy;

    private String ltDate;

    public Integer getLtId() {
        return ltId;
    }

    public void setLtId(Integer ltId) {
        this.ltId = ltId;
    }

    public String getLtBuoy() {
        return ltBuoy;
    }

    public void setLtBuoy(String ltBuoy) {
        this.ltBuoy = ltBuoy == null ? null : ltBuoy.trim();
    }

    public String getLtDate() {
        return ltDate;
    }

    public void setLtDate(String ltDate) {
        this.ltDate = ltDate == null ? null : ltDate.trim();
    }
}