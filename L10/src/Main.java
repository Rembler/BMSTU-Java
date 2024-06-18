import org.apache.spark.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("������������� spark");

        SparkSession sparkSession = SparkSession.builder().appName("spark_test.com").master("local[*]").getOrCreate();
        sparkSession.sparkContext().setLogLevel("ERROR");

        String path = System.getProperty("user.dir") + "/pokemon_data.csv";
        Dataset<Row> dataset = sparkSession.read().format("csv").option("header", "true").load(path);
        dataset.createOrReplaceTempView("pokemon");

        System.out.println("\n\n���������� ��������:");

        System.out.println("\n1. ������ �������");
        sparkSession.sql("select * from pokemon limit 10").show();

        System.out.println("\n2. ������� ��������� �� ������������ ������");
        sparkSession.sql("select round(sum(case when type1 = 'Flying' or type2 = 'Flying' then 1 end) / count(*) * 100, 1) as `������� �������� ���������` from pokemon").show();

        System.out.println("\n3. ����� ������� ��������");
        sparkSession.sql("select name as `�������`, height as `����` from pokemon order by 2 desc limit 5").show();

        System.out.println("\n4. ������������� �� ��������");
        sparkSession.sql("select special_group as `��������`, count(*) as `���-��` from pokemon group by special_group order by 2").show();

        System.out.println("\n5. ������� ���-�� ����� �� ������ ��� ������� ������");
        sparkSession.sql("select type1 as `�����`, ROUND(AVG(base_exp), 1) as `������� ���-�� �����` from pokemon group by type1 order by 2 desc").show();

        System.out.println("\n6. ����� ������� ���������������� ��������");
        sparkSession.sql("select name as `�������`, total as `����� ����` from pokemon where egg_group1 = 'Human-Like' order by 2 desc limit 5").show();

        System.out.println("\n7. ��������, ���������� 'duck' � �����");
        sparkSession.sql("select name as `�������` from pokemon where name LIKE '%duck%'").show();

        System.out.println("\n8. ���-�� ��������� �� ������� ������������");
        sparkSession.sql("select count(*) from pokemon where hidden_ability is not null").show();

        System.out.println("\n9. �������� �� ��������� ���� ��������");
        sparkSession.sql("select name as `�������`, speed as `��������` from pokemon where speed < (select AVG(speed) from pokemon) order by 2").show();

        System.out.println("\n10. ������");
        sparkSession.sql("select * from pokemon where name = 'Pikachu'").show();

        sparkSession.stop();
    }
}