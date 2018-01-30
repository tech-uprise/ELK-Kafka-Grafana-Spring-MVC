#!/usr/bin/env bash

echo

echo "Starting Logstash ..."

cd /exercise/installs/logstash/logstash-5.4.0

sudo bin/logstash -f /exercise/sts-workspace/elk-spring-mvc-web/WebContent/resources/logstash.conf

echo
echo

echo "Logstash is running and processing the data from Kafka to Elasticsearch..."