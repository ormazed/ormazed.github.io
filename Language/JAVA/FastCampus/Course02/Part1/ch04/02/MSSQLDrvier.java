package fc.java.model2;
// ojdbc.jar 의 역할
public class MSSQLDrvier implements Connection{
    @Override
    public void getConnection(String url, String username, String password) {
        System.out.println("mssql drvier : url, username, password 입니다.");
    }
}
