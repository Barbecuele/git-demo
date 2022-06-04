package dataSource.src.cn.itcast.dataSource.JdbcTemplate;

import cn.itcast.dataSource.domain.Emp;
import cn.itcast.dataSource.utils.JDBCUtil;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {
    //获取JJdbcTemplate对象
   private JdbcTemplate template =new JdbcTemplate(JDBCUtil.getDataSource());

    //定义SQL

    /**
     * 1.修改7566的薪资为2000
     */
    @Test
    public void test1(){
        //定义SQL
        String sql = "update emp set sal = 2000 where empno=7566";

        //执行SQL
        int count = template.update(sql);
        System.out.println(count);
    }

    /**
     * 添加一条记录
     */
    @Test
    public void test2(){
        String sql = "insert into emp(empno,ename,deptno) values(?,?,?)";

        int count = template.update(sql,7001,"lison",30);
        System.out.println(count);
    }

    /**
     * 删除刚才添加的记录
     */
    @Test
    public void test3(){
        String sql = "delete from emp where empno = 7001";

        int count = template.update(sql);
        System.out.println(count);
    }

    /**
     * 查询所有的记录，并将其封装为List集合
     */
    @Test
    public void test4(){
        String sql ="select *from emp";

        List<Map<String, Object>> lists = template.queryForList(sql);
        int i=1;
        for (Map<String, Object> list:lists
             ) {
            System.out.println((i++) + "," + list);
        }
    }

    /**
     * 查询empno为7566记录，并将其封装为Map集合
     * 注意这个方法查询的结果集的长度只能为1
     */
    @Test
    public void test5(){
        String sql = "select *from emp where empno=?";

        Map<String, Object> map = template.queryForMap(sql, 7566);

        System.out.println(map);
    }

    /**
     * 查询所有记录，将其封装为emp对象的List集合
     */
    @Test
    public void test6(){
        String sql = "select *from emp";

        List<Emp> lists = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                int mgr = rs.getInt("mgr");
                Date hiredate = rs.getDate("hiredate");
                double sal = rs.getDouble("sal");
                double comm = rs.getDouble("comm");
                int deptno = rs.getInt("deptno");

                emp.setEmpno(empno);
                emp.setEname(ename);
                emp.setJob(job);
                emp.setMgr(mgr);
                emp.setHiresate(hiredate);
                emp.setSal(sal);
                emp.setComm(comm);
                emp.setDeptno(deptno);

                return emp;
            }
        });

        for (Emp emp:lists
             ) {
            System.out.println(emp);
        }
    }

    @Test
    public void test6_2(){
        String sql = "select *from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));

        for (Emp emp:list
             ) {
            System.out.println(emp);
        }
    }

    /**
     * 查询总记录数
     * 一般用来执行聚合函数
     */
    @Test
    public void test7(){
        String sql ="select count(empno) from emp";

        Long total = template.queryForObject(sql, long.class);
        System.out.println(total);
    }
}
