package com.infirmarium.core.persistance.coredomain;

import java.io.Serializable;

public interface BaseEntity<PK> extends Serializable {

    PK getPrimaryKey();

    void setPrimaryKey(PK primaryKey);

    public static class Constants {
    }

    public static class Columns {
    }

    public static class Fields {
    }
}
