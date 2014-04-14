package net.troja.eve.uudif.general;

public class UploadKey {
    private String name;
    private String key;

    public UploadKey() {
	super();
    }

    public UploadKey(final String name, final String key) {
	super();
	this.name = name;
	this.key = key;
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public String getKey() {
	return key;
    }

    public void setKey(final String key) {
	this.key = key;
    }

    @Override
    public String toString() {
	return "UploadKey [name=" + name + ", key=" + key + "]";
    }
}
