import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;



public class Db {
    private DataSource initDataSource(){
        DataSource dataSource= new MysqlDataSource();
        
    }
}
