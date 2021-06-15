package com.lenny.surveyingDB.adapters;

import org.testcontainers.utility.DockerImageName;

public interface PostgreSQLTestImages
{
    DockerImageName POSTGRES_TEST_IMAGE = DockerImageName.parse("postgres:13.3");
}
