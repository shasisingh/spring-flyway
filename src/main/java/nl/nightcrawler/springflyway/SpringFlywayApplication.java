package nl.nightcrawler.springflyway;

import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.internal.jdbc.DriverDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringFlywayApplication {

    private final DataSource dataSource;

    public SpringFlywayApplication(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringFlywayApplication.class, args);
    }


    @PostConstruct
    public void apiDatabaseMigrations() {


        var flyway = Flyway.configure()
                .baselineOnMigrate(true)
                .validateMigrationNaming(true)
                .dataSource(dataSource)
                .encoding("UTF-8")
                .installedBy("[ME]")
                .locations("migration")
                .sqlMigrationPrefix("v")
                .sqlMigrationSeparator("__")
                .sqlMigrationSuffixes(".sql")
                .table("flyway_schema_history")
                .schemas("superman")
                .load();
        flyway.repair();
        flyway.migrate();
    }

    private DriverDataSource datasourceCustom() {
        return new DriverDataSource(Thread.currentThread().getContextClassLoader(), "org.postgresql.Driver", "jdbc:postgresql://localhost:5432/superman", "superman", "superman");
    }
}
