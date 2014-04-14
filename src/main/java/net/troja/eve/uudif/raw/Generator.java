package net.troja.eve.uudif.raw;

public class Generator {
    private String name;
    private String version;

    public Generator() {
	super();
    }

    public Generator(final String name, final String version) {
	super();
	this.name = name;
	this.version = version;
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public String getVersion() {
	return version;
    }

    public void setVersion(final String version) {
	this.version = version;
    }

    @Override
    public String toString() {
	return "Generator [name=" + name + ", version=" + version + "]";
    }
}
