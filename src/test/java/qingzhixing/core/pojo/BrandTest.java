package qingzhixing.core.pojo;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

class BrandTest {
    @Test
    public void testSelectAll() throws Exception {
        Properties properties = new Properties();
        properties.load(BrandTest.class.getResourceAsStream("/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();

        String sql = "SELECT * FROM tb_brand";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Brand> brandList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");

            Brand brand = new Brand(id, brandName, companyName, ordered, description, status);

            brandList.add(brand);
        }
        System.out.println(brandList);

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}