package net.troja.eve.uudif.specific;

import java.util.ArrayList;
import java.util.List;

import net.troja.eve.uudif.general.GeneralRowset;

public class GenericRowset<T> extends GeneralRowset {
    private List<T> rows = new ArrayList<T>();

    public GenericRowset() {
	super();
    }

    public List<T> getRows() {
	return rows;
    }

    public void setRows(final List<T> rows) {
	this.rows = rows;
    }

    @Override
    public String toString() {
	return "OrderRowset [rows=" + rows + "]";
    }

    public void add(final T row) {
	rows.add(row);
    }
}
