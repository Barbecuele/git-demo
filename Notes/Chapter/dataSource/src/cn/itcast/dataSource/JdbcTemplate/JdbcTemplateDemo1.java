package cn.itcast.dataSource.JdbcTemplate;

import cn.itcast.dataSource.utils.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate入门
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

        //调用方法
        String sql = "update t_cat set balance = 2000 where actno = ?";
        int count = template.update(sql, "B");

        System.out.println(count);
        //JdbcTemplate内部进行了封装会自动释放资源，归还连接
    }
}
