package abp.project.mesapp.holstein;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataBaseConnection db = new DataBaseConnection();
        db.init();
        MenuFunciones menu = new MenuFunciones();
        menu.menuFunciones(db);
        // DESCONECTAR
        db.desconectar();
    }
}