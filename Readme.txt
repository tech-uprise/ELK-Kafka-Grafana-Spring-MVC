This is a Spring MVC web application. Its built using the following on macOS High Sierra (10.13.1 (17B1003))
a.	Spring v4.3.9
b.	Elasticsearch v5.4
c.	Logstash v5.4
d.	Kibana v5.4
e.	Kafka v0.10.2.0
f.	Grafana 4.6.3

Elasticsearch, Kibana and Kafka have to be started manually as described in the steps below but not the Logstash. Logstsh will be started when the application is run on your favorite web server. Logstash configuration is found under /WebContent/resources. Edit “logstash.conf” and “runlogstash.sh” as needed to point the correct location of 
-	Kafka, Elasticsearc (in logstsah.conf) &
-	logstsh.conf (in runlogstash.sh)

1.	Elasticsearch:
Download and unzip Elasticsearch [https://www.elastic.co/blog/elasticsearch-5-4-0-released]
Change the directory to Elasticsearch folder [ cd /exercise/installs/elastic/elasticsearch-5.4.0 ]
Run bin/elasticsearch
Elasticsearch instance should be running at http://localhost:9200/
Keep the terminal open where elastic search is running to be able to keep the instance running. you could also use nohup mode to run the instance in the background. 

2.	Kibana:
Download and unzip Kibana [https://www.elastic.co/blog/kibana-5-4-0-released]
Open config / Kibana.yml in an editor and Set elasticsearch.url to point at your Elasticsearch instance [elasticsearch.url: "http://localhost:9200"]
Change the directory to Kibana folder [ cd /exercise/installs/kibana/kibana-5.4.0-darwin-x86_64 ]
Run bin/kibana
Kibana instance should be running at http://localhost:5601/
Keep the terminal open where Kibana was run to be able to keep the instance running. you could also use nohup mode to run the instance in the background

3.	Kafka:
  Download and unzip Kafka [https://kafka.apache.org/downloads]
  Extract into your desired directory [example: /exercise/installs/kafka/kafka_2.12-1.0.0/]
	2.1	Zookeeper
		2.1.1	cd /exercise/installs/kafka/kafka_2.12-1.0.0/bin
		2.1.2	zookeeper-server-start ../config/zookeeper.properties
	2.2	Kafka
		2.2.1	cd /exercise/installs/kafka/kafka_2.12-1.0.0/bin
		2.2.2	kafka-server-start ../config/server.properties

4.	Logstash:
  Download and unzip Logstash [https://www.elastic.co/blog/logstash-5-4-0-released]
  Extract into your desired directory [example: /exercise/installs/logstash/logstash-5.4.0]
  
5.	Grafana:
	5.1	Install grafana (Mac)
		5.1.1	brew update
		5.1.2	brew install grafana
	5.2	Starting Grafana
		5.2.1	brew tap homebrew/services
	5.3	Configuration
		5.3.1	The Configuration file should be located at /usr/local/etc/grafana/grafana.ini.
	5.4	Logs
		5.4.1	The log file should be located at /usr/local/var/log/grafana/grafana.log.
	5.5	Plugins
		5.5.1	If you want to manually install a plugin place it here: /usr/local/var/lib/grafana/plugins.
	5.6	Database
		5.6.1	The default sqlite database is located at /usr/local/var/lib/grafan
	5.7	Access grafana UI: http://localhost:3000 (use admin/admin to login)
	5.8	Connecting to Elasticsearch
		5.8.1	Click on the “Add data source” button displayed in your Grafana Home Dashboard, and configure the connection with Elasticsearch.
		5.8.2	Use this cURL on the host on which Elasticsearch is installed to get a list of all Elasticsearch indices:
			5.8.2.1	curl -XGET 'localhost:9200/_cat/indices?v&pretty'
		5.8.3	Create a new dashboard
			5.8.3.1	Dashboards → New → Graph panel (most frequently-used panel type) → Click panel title and then Edit → Metrics → Add Query → Save
		
6.	Run Application:
Run the application and generate some data into Elasticsearch to create dashboards from Kibana

