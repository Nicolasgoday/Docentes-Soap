package com.docentes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class MateriasDao {

    private static final Logger logger = LogManager.getLogger(MateriasDao.class);

    private final JdbcTemplate jdbcTemplate;

    public MateriasDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Materias> findAllPureJdbc() {
        List<Materias> results = new LinkedList<Materias>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Materias");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Materias Materias = new Materias(resultSet.getLong("id"), resultSet.getString("name"));

                results.add(Materias);
            }
        } catch (SQLException ex) {
            logger.error(ex);
            throw new RuntimeException(ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    logger.warn(ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    logger.warn(ex);
                }
            }
        }

        return results;
    }

    public List<Materias> findAll() {
        return jdbcTemplate.query("SELECT * FROM Materias", new MateriasRowMapper());
    }

    public List<Materias> findByName(String name) {
        return jdbcTemplate.query("SELECT * FROM Materias WHERE name LIKE ?", new Object[] { name },
                new MateriasRowMapper());
    }

    public Materias findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Materias WHERE id = ?",
                new Object[] { id }, new MateriasRowMapper());
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Materias", Integer.class);
    }

    public int deleteAll() {
        return jdbcTemplate.update("DELETE from Materias");
    }

    public void insertWithQuery(String name, int population) {
        jdbcTemplate.update("INSERT INTO Materias (name, population) VALUES(?,?)", name, population);
    }

    public void insertBatch(List<Materias> countries, int batchSize) {
        String sql = "INSERT INTO Materias (name, population) VALUES(?,?)";

        jdbcTemplate.batchUpdate(sql, countries, batchSize,
                (PreparedStatement ps, Materias Materias) -> {
                    ps.setString(1, Materias.getName());
                }
        );
    }

    public long insert(String name, int population) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate.getDataSource())
                .withTableName("Materias").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", name);
        parameters.put("population", population);
        return simpleJdbcInsert.executeAndReturnKey(parameters).longValue();
    }

    public Integer callProcedure(String name) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("search");

        SqlParameterSource in = new MapSqlParameterSource().addValue("name", name);

        Map<String, Object> out = simpleJdbcCall.execute(in);
        return (Integer) out.get("total");
    }

    public Integer callFunction(String name) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withFunctionName("search2");

        SqlParameterSource in = new MapSqlParameterSource().addValue("name", name);

        return simpleJdbcCall.executeFunction(Integer.class, in);
    }

    private static class MateriasRowMapper implements RowMapper<Materias> {
        @Override
        public Materias mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Materias(rs.getLong("id"), rs.getString("name"));
        }
    }

}