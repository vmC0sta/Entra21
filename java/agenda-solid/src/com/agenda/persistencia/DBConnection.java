package com.agenda.persistencia;

import java.sql.Connection;

public interface DBConnection {
    Connection getConnection();
}
