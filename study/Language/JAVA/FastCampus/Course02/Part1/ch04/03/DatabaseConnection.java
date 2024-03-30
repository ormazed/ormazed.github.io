package fc.java.course2.part1;

import fc.java.model2.Connection;
import fc.java.model2.OracleDrvier;

public class DatabaseConnection {
    public static void main(String[] args) {
        Connection con = new OracleDrvier();
        con.getConnection("oracle","scott", "tiger");
    }
}
