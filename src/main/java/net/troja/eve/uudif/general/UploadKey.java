package net.troja.eve.uudif.general;

public class UploadKey {
    private String name;
    private String key;

    public UploadKey() {
	super();
    }

    public UploadKey(String name, String key) {
	super();
	this.name = name;
	this.key = key;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getKey() {
	return key;
    }

    public void setKey(String key) {
	this.key = key;
    }

    @Override
    public String toString() {
	return "UploadKey [name=" + name + ", key=" + key + "]";
    }
}
