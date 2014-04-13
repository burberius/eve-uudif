package net.troja.eve.uudif.raw;

import java.util.List;

import net.troja.eve.uudif.general.GeneralRowset;

public class RawRowset extends GeneralRowset {

    private List<List<String>> rows;

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }

}
