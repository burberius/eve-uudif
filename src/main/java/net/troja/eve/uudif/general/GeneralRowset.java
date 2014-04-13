package net.troja.eve.uudif.general;

import java.util.Date;

public abstract class GeneralRowset {
    private Date generatedAt;
    private Integer regionID;
    private Integer typeID;

    public GeneralRowset() {
	super();
    }

    public Date getGeneratedAt() {
	return generatedAt;
    }

    public void setGeneratedAt(Date generatedAt) {
	this.generatedAt = generatedAt;
    }

    public Integer getRegionID() {
	return regionID;
    }

    public void setRegionID(Integer regionID) {
	this.regionID = regionID;
    }

    public Integer getTypeID() {
	return typeID;
    }

    public void setTypeID(Integer typeID) {
	this.typeID = typeID;
    }

    @Override
    public String toString() {
	return "Rowset [generatedAt=" + generatedAt + ", regionId=" + regionID
		+ ", typeId=" + typeID + "]";
    }

}
