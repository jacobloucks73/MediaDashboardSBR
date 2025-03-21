package com.smugalpaca.mediadashboard.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;

@Setter
@Getter
@Entity
@Table(name = "aggdata", schema = "mediadashboarddb")
public class AggData {
    @Id
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "json_data", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> jsonData;

    @Column(name = "last_updated", nullable = false)
    private Instant lastUpdated;

}